package ecommerce.Model.Bean;

import ecommerce.Model.Dao.ProdutoDAO;
import ecommerce.Model.DaoImplementation.ProdutoDAOImpl;
import ecommerce.Model.MetodosAcessores.Produto;
import java.io.Serializable;
import java.util.ArrayList;
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

    private List<Produto> produtos = null;
    
    // Solução proposta no link https://stackoverflow.com/a/2120183 - Ver item 4.
    // A lista de produtos selecionada precisa estar ativa no momento do clique no botão.
    @PostConstruct
    public void init() {
        setCategoria();
        ProdutoDAO produtosDao = new ProdutoDAOImpl();
        produtos = produtosDao.ListarProdutosCategoria(categoria);
    }

    private String getCategoria(FacesContext context) {
        Map<String, String> attrs = context.getExternalContext().getRequestParameterMap();
        return (String) attrs.get("cat");
    }

    public String setCategoria() {
        FacesContext context = FacesContext.getCurrentInstance();
        this.categoria = getCategoria(context);
        return null;
    }

    @Deprecated
    public List<Produto> ListarProdutosPorCategoria() throws Exception {
        return getProdutos();
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
    
    public String getCategoria() {
        return categoria;
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
