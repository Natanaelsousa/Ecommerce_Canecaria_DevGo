package ecommerce.Model.DaoImplementation;

import ecommerce.Model.MetodosAcessores.Categoria;
import ecommerce.Model.Dao.CategoriaDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*  @author sibele */
public class CategoriaDAOImpl extends GenericaDAOImpl implements CategoriaDAO {

    //Lista todos as categorias
    public List<Categoria> ListarCategoriaPorIDeNome() throws SQLException {
        List<Categoria> categoria = new ArrayList<Categoria>();

        String query = "SELECT COD_CATEGORIA,NOME_CATEGORIA FROM CATEGORIA";

        PreparedStatement stmt
                = getConnection().prepareStatement(query);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Categoria categorias = new Categoria();
            categorias.setCod_categoria(rs.getInt("COD_CATEGORIA"));
            categorias.setNome_categoria(rs.getString("NOME_CATEGORIA"));

            categoria.add(categorias);
        }

        rs.close();
        stmt.close();
        closeConnetion();

        return categoria;

    }

    //Insere os dados da nova categoria no banco
    public void CadastrarNovaCategoria(Categoria categoria) throws SQLException {
        String query = "INSERT INTO categoria(nome_categoria)"
                + "VALUES(?,?)";

        insert(query, categoria.getNome_categoria());

    }

    //Edita os dados da categoria no banco
    public void EditarCadastroCategoria(Categoria categoria) throws SQLException {
        String query = "UPDATE cliente "
                + "SET nome_categoria = ? "
                + "WHERE cod_categoria = ?";
        update(query, categoria.getNome_categoria());
    }

    public List<Categoria> ListarCategorias() throws SQLException {
        List<Categoria> categorias = new ArrayList<Categoria>();

        String select = "SELECT * FROM CATEGORIA ORDER BY COD_CATEGORIA";

        PreparedStatement stmt
                = getConnection().prepareStatement(select);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Categoria categoria = new Categoria();

            categoria.setNome_categoria(rs.getString("nome_categoria"));

            categorias.add(categoria);
        }

        rs.close();
        stmt.close();
       

        return categorias;
    }

    @Override
    public void ExcluirCategoria(Categoria categoria) throws SQLException {
        String query = "DELETE * FROM CLIENTE WHERE COD_CATEGORIA = " + categoria.getCod_categoria() + " and NOME_CATEGORIA = " + categoria.getNome_categoria();
        delete(query, categoria.getCod_categoria(), categoria.getNome_categoria());
    }
}
