package ecommerce.Model.Bean;

import ecommerce.Model.Dao.ProdutoDAO;
import ecommerce.Model.DaoImplementation.ProdutoDAOImpl;
import ecommerce.Model.MetodosAcessores.Produto;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;

/*  @author sibele */
@ManagedBean(name = "ProdutosBean")
public class ProdutosBean {

    private Produto produto = new Produto();
    private int id_produto;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public ProdutosBean() {
    }

    /*Responsavel pelo cadastro do produto*/
    public void CadastrarProduto() throws Exception {
        ProdutoDAO produtos = new ProdutoDAOImpl();
        try {
            produtos.CadastrarProduto(produto);
        } catch (SQLException erro) {
            System.err.println("Este produto ja foi cadastrado.");
        }
        produto = new Produto();

    }

    /*Busca produto para em seguida edita-lo*/
    public String buscandoProduto() throws Exception {
        ProdutoDAO produtos = new ProdutoDAOImpl();
        String retorno = null;
        try {
            produto = produtos.BuscarProdutoPorID(id_produto);
        } catch (SQLException erro) {
            System.err.println("Não foi possivel localizar o produto");
        }

        // Verifica se algum produto foi escolhido
        if (produto.getCod_produto() != null) {
            retorno = "EditarCadastroProdutos";
        } else {
            retorno = "Produto nao selecionado";
        }
        return retorno;
    }

    /* Edita dados, no banco, do produto selecionado*/
    public String  editarProduto() throws Exception {
        ProdutoDAO produtos = new ProdutoDAOImpl();
        try {
            produtos.EditarCadastroProduto(produto,id_produto);
        } catch (SQLException erro) {
            System.err.println("Não foi possivel alterar os dados deste produto.");
        }

        return "BuscarProdutoEditar";
    }

    /* Insere quantidade de produtos(Ja cadastrados) no banco */
    public void InserirProdutosNoEstoque() throws Exception {
        ProdutoDAO produtos = new ProdutoDAOImpl();
        try {
            produtos.InserirQuantidadeDeProdutoExistente(produto);
        } catch (SQLException erro) {
            System.err.println("Não foi possivel incluir produtos no estoque.");
        }
        produto = new Produto();
    }

    /* Excluir produtos do banco (DEFINITIVAMENTE)*/
    public void ExcluirProduto() throws Exception {
        ProdutoDAO produtos = new ProdutoDAOImpl();
        produtos.ExclusaoDeCadastroProduto(produto);
    }

    /* Lista os produtos cadastrados no banco */
    public List<Produto> ListarProdutosIdENome() throws Exception {
        ProdutoDAO produtosDao = new ProdutoDAOImpl();

        List<Produto> ListaProdutos = produtosDao.ListarProdutosPorIDeNome();

        return ListaProdutos;
    }

}
