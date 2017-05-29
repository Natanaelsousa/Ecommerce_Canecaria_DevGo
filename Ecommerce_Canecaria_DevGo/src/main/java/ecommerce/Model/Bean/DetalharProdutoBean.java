
package ecommerce.Model.Bean;

import ecommerce.Model.Dao.ProdutoDAO;
import ecommerce.Model.DaoImplementation.ProdutoDAOImpl;
import ecommerce.Model.MetodosAcessores.Produto;
import java.sql.SQLException;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Erik
 */
@ManagedBean
@ViewScoped
public class DetalharProdutoBean {

    private int id;
    private int quantidade;
    private Produto produto = new Produto();
    ProdutoDAO produtos = new ProdutoDAOImpl();

    public DetalharProdutoBean() {
    }

    @PostConstruct
    public void iniciar() {
        try {
            detalharProduto();
        } catch (Exception ex) {
           System.err.println("Erro");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   
    /*Detalhar o Produto*/
    public void detalharProduto() throws Exception {
           try {
            setProduto(produtos.BuscarProdutoPorID(getId()));
            setQuantidade(produtos.quantidadeEstoque(getId()));
        } catch (SQLException erro) {
            System.err.println("Erro");
        }
    }

    
    public Produto getProduto() {
        return produto;
    }

    
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
 
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
