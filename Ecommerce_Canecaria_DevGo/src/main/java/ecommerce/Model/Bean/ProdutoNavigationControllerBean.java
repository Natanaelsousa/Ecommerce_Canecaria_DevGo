package ecommerce.Model.Bean;

import ecommerce.Model.Dao.ProdutoDAO;
import ecommerce.Model.DaoImplementation.ProdutoDAOImpl;
import ecommerce.Model.MetodosAcessores.Produto;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Erik
 */
@ManagedBean(eager = true)
@RequestScoped
public class ProdutoNavigationControllerBean implements Serializable {
    
 private String categoria;
  ProdutoDAO produtosDao = new ProdutoDAOImpl();
 List<Produto> listaProdutos ;

    public ProdutoNavigationControllerBean() throws SQLException {
        this.listaProdutos = produtosDao.ListarProdutos();
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public ProdutoDAO getProdutosDao() {
        return produtosDao;
    }

    public void setProdutosDao(ProdutoDAO produtosDao) {
        this.produtosDao = produtosDao;
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }
   
   
   private String getCategoria( FacesContext context ){
		Map<String, String> attrs = context.getExternalContext().getRequestParameterMap();
		return (String) attrs.get("cat");
	}
   
      public String setCategoria(){
		FacesContext context = FacesContext.getCurrentInstance();
		this.categoria = getCategoria( context );
		return null;
	}

   
    public List<Produto> ListarProdutosPorCategoria() throws Exception {
           
         setCategoria();
        
        ProdutoDAO Dao = new ProdutoDAOImpl();

        listaProdutos = Dao.ListarProdutosCategoria(categoria);
    
        return listaProdutos;
    }
}

