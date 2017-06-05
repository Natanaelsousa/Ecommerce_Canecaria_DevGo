/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Model.Bean;

import ecommerce.Model.Dao.CarrinhoDAO;
import ecommerce.Model.Dao.PedidoDAO;
import ecommerce.Model.Dao.ProdutoDAO;
import ecommerce.Model.DaoImplementation.CarrinhoDAOImpl;
import ecommerce.Model.DaoImplementation.PedidoDAOImpl;
import ecommerce.Model.DaoImplementation.ProdutoDAOImpl;
import ecommerce.Model.MetodosAcessores.Carrinho;
import ecommerce.Model.MetodosAcessores.Produto;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author natanael.ssousa
 */
@Named
@SessionScoped
public class CarrinhoBean implements Serializable {

    private List<Produto> produtos = new ArrayList<>();
    ProdutoDAO produtosDao = new ProdutoDAOImpl();
    private double valorTotal = 0.00;
    private int qtde = 0;
    private int cod_pedido;
    private List<Carrinho> listarItensCarrinho = new ArrayList<Carrinho>();
    FacesContext fc = FacesContext.getCurrentInstance();
    LoginBean usuario = fc.getApplication()
            .evaluateExpressionGet(fc, "#{LoginBean}",
                    LoginBean.class);

    public List<Carrinho> getListarItensCarrinho() {
        return listarItensCarrinho;
    }

    public void setListarItensCarrinho(List<Carrinho> listarItensCarrinho) {
        this.listarItensCarrinho = listarItensCarrinho;
    }

    public int getCod_pedido() {
        return cod_pedido;
    }

    public void setCod_pedido(int cod_pedido) {
        this.cod_pedido = cod_pedido;
    }

    public CarrinhoBean() {

    }
    // Metodo que add produto no carrinho e valida se tem disponivel no estoque by: Natanael Santos

    public String adicionar(int produto) throws SQLException {
        Produto prod = produtosDao.BuscarProdutoPorID(produto);
        int qtdeEstoque = prod.getQtde_produto();
        double valorQueEntra = prod.getValor_produto();
        prod.setQtde_produto(1);

        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getNome_produto().equals(prod.getNome_produto())) {
                if (qtdeEstoque >= produtos.get(i).getQtde_produto() + 1) {
                    prod.setValor_produto(produtos.get(i).getValor_produto() + prod.getValor_produto());
                    prod.setQtde_produto(produtos.get(i).getQtde_produto() + 1);

                    produtos.remove(produtos.get(i));
                }
            }
        }

        // Logica errada na condição abaixo by Natanael Santos
        int i = 0;
        while (i <= produtos.size()) {

            if (produtos.isEmpty()
                    || !prod.getNome_produto().equals(produtos.get(i).getNome_produto())) {
                if (qtdeEstoque != 0) {
                    produtos.add(prod);
                    this.valorTotal += valorQueEntra;
                } else {
                    FacesContext.getCurrentInstance().addMessage(
                            null, new FacesMessage("Falta do produto em estoque!"));
                    FacesContext.getCurrentInstance()
                            .getExternalContext()
                            .getFlash().setKeepMessages(true);

                    FacesContext.getCurrentInstance()
                            .getExternalContext()
                            .getFlash().setKeepMessages(true);
                    return "Produtos.xhtml?faces-redirect=true";
                }
            } else {
                FacesContext.getCurrentInstance().addMessage(
                        null, new FacesMessage("Falta do produto em estoque!"));
                FacesContext.getCurrentInstance()
                        .getExternalContext()
                        .getFlash().setKeepMessages(true);

                FacesContext.getCurrentInstance()
                        .getExternalContext()
                        .getFlash().setKeepMessages(true);
                return "Produtos.xhtml?faces-redirect=true";
            }
            i++;
            break;
        }

        FacesContext.getCurrentInstance().addMessage(
                null, new FacesMessage("Produto adicionado com sucesso!"));
        FacesContext.getCurrentInstance()
                .getExternalContext()
                .getFlash().setKeepMessages(true);

        FacesContext.getCurrentInstance()
                .getExternalContext()
                .getFlash().setKeepMessages(true);
        return "Produtos.xhtml?faces-redirect=true";
    }

    public String listarCarrinhoPorPedido(int pedido) throws SQLException {
        CarrinhoDAO carrinhoDao = new CarrinhoDAOImpl();
        try {
            listarItensCarrinho = carrinhoDao.listarCarrinhoPorPedido(pedido);
            setCod_pedido(pedido);
        } catch (SQLException ec) {
            System.out.println("Nao foi possivel listar os itens do pedido");

        }

        return "listarItensPedidosEmpresa";

    }

    public String retirarProdutoDoEstoque(List<Carrinho> itensCarrinho) throws SQLException {
        CarrinhoDAO carrinhoDao = new CarrinhoDAOImpl();
        PedidoDAO pedidoDao = new PedidoDAOImpl();
        try {
            //Retira os produtos que estao na lista, do estoque.
            carrinhoDao.retirarProdutoDoEstoque(itensCarrinho);
            int codpedido = itensCarrinho.get(0).getCod_pedido();
            
            //Atualiza o status do pedido para 4(Pedido enviado).
            pedidoDao.atualizarPedidoParaPagoPorCodpedido(codpedido);

        } catch (SQLException ec) {
            System.out.println("Nao foi atualizar status do pedido ou não retirar o produto do estoque");

        }
        return "AcompanhamentoVendasPagas";

    }

    public void remover(String nome) {

        int valor = Integer.parseInt(nome);

        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getCod_produto() == valor) {
                this.valorTotal = valorTotal - produtos.get(i).getValor_produto();
                produtos.remove(i);
            }
        }
    }

    public String finalizarPedido() throws SQLException {
        CarrinhoDAO carrinhoDao = new CarrinhoDAOImpl();

        Integer codCliente = usuario.getCliente().getCod_cliente();
        if (produtos.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Carrinho de compras esta vazio!"));
            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getFlash().setKeepMessages(true);

            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getFlash().setKeepMessages(true);
            return null;
        } else {
            if (codCliente != null) {
                carrinhoDao.CadastrarPedido(produtos, codCliente);
                produtos.clear();
                valorTotal = 0;
                return "protegido/Checkout.xhtml?faces-redirect=true";
            } else {
                return "MinhaConta_Checkout.xhtml?faces-redirect=true";
            }

        }
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

}
