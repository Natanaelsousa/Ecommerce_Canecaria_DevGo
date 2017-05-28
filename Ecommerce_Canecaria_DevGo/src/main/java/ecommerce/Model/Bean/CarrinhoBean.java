/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Model.Bean;

import ecommerce.Model.Dao.ProdutoDAO;
import ecommerce.Model.DaoImplementation.ProdutoDAOImpl;
import ecommerce.Model.MetodosAcessores.Produto;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

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

    public CarrinhoBean() {

    }

    public String adicionar(int produto) throws SQLException {
        Produto prod = produtosDao.BuscarProdutoPorID(produto);
        prod.setQtde_produto(1);
        for(int i = 0; i < produtos.size(); i++){
            if (produtos.get(i).getNome_produto().equals(prod.getNome_produto()) ) {
                prod.setValor_produto(produtos.get(i).getValor_produto() + prod.getValor_produto());
                prod.setQtde_produto(produtos.get(i).getQtde_produto() + 1);
                
                produtos.remove(produtos.get(i));
                
            }
        }

        produtos.add(prod);
        this.valorTotal += prod.getValor_produto();

        return "Produtos";
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
