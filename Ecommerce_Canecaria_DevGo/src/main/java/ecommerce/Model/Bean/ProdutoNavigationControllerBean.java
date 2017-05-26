package ecommerce.Model.Bean;

import ecommerce.Model.Dao.ProdutoDAO;
import ecommerce.Model.DaoImplementation.ProdutoDAOImpl;
import ecommerce.Model.MetodosAcessores.Produto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Erik
 */
@ManagedBean(eager = true)
@RequestScoped
public class ProdutoNavigationControllerBean implements Serializable {
    
 private String categoria;
  
    private List<Produto> produtos = null;
   
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

    public List<Produto> getProdutos() {

        try {
            return ListarProdutosPorCategoria();
        } catch (Exception ex) {
            return null;
        }
    }
    
    public List<Integer> getNumeros() {
        List<Integer> listaIds = new ArrayList<Integer>();
        List<Produto> prods = getProdutos();
        for (Produto p : prods) {
            listaIds.add(p.getCod_categoria());
        }
        return listaIds;
    }

}

