package ecommerce.Model.Bean;

import ecommerce.Model.Dao.ProdutoDAO;
import ecommerce.Model.DaoImplementation.ProdutoDAOImpl;
import ecommerce.Model.MetodosAcessores.Produto;
import java.io.Serializable;
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
        
        ProdutoDAO produtosDao = new ProdutoDAOImpl();

        List<Produto> ListaProdutos = produtosDao.ListarProdutosCategoria(categoria);
    
        return ListaProdutos;
    }
}

