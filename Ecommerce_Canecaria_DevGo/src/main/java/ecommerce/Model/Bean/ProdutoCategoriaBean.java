package ecommerce.Model.Bean;

import ecommerce.Model.Dao.ProdutoDAO;
import ecommerce.Model.DaoImplementation.ProdutoDAOImpl;
import ecommerce.Model.MetodosAcessores.Produto;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Erik
 */
@ManagedBean
@ViewScoped
public class ProdutoCategoriaBean {

    public ProdutoCategoriaBean() {
        
    }
    private String categoria;
    private ProdutoDAO produtosDao = new ProdutoDAOImpl();
    List<Produto> listaProdutos ;

    @PostConstruct
    public void iniciar() {
        
        try {
            buscaProdutosPorCategoria();
        } catch (Exception ex) {
           System.err.println("Erro");
        }
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }
   
             
     /* Buscar os produtos de acordo com a categoria */
    public List<Produto> buscaProdutosPorCategoria() throws Exception {
        
             
        listaProdutos = produtosDao.ListarProdutosPorCategoria(categoria);
                
        return listaProdutos;
        
    }

   
    public ProdutoDAO getProdutosDao() {
        return produtosDao;
    }

   
    public void setProdutosDao(ProdutoDAO produtosDao) {
        this.produtosDao = produtosDao;
    }
    
}
