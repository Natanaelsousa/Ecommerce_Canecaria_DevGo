package ecommerce.Model.Dao;

import ecommerce.Model.MetodosAcessores.Categoria;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author sibele.nsantos
 */
public interface CategoriaDAO {

    public void CadastrarNovaCategoria(Categoria categoria) throws SQLException;

    public void EditarCadastroCategoria(Categoria categoria) throws SQLException;

    public void ExcluirCategoria(Categoria categoria) throws SQLException;

    public List<Categoria> ListarCategoriaPorIDeNome() throws SQLException;
}
