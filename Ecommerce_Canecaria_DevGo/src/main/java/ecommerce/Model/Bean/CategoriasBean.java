package ecommerce.Model.Bean;

import ecommerce.Model.Dao.CategoriaDAO;
import ecommerce.Model.DaoImplementation.CategoriaDAOImpl;
import ecommerce.Model.MetodosAcessores.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

/*  @author sibele */
@ManagedBean(name = "CategoriasBean")
public class CategoriasBean {

    private Categoria categoria = new Categoria();
    
       private Integer quant;

    public Integer getQuant() {
        return quant;
    }

    public void setQuant(Integer quant) {
        this.quant = quant;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public CategoriasBean() {
    }

    /* Lista as categorias cadastradas no banco */
    public List<Categoria> ListarCategorias() throws Exception {
        CategoriaDAO categoriaDao = new CategoriaDAOImpl();

        List<Categoria> ListaCategorias = categoriaDao.ListarCategoriaPorIDeNome();
        
        return ListaCategorias;

    }
    
 
}
