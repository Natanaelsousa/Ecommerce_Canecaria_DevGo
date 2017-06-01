package ecommerce.Model.Dao;

import ecommerce.Model.MetodosAcessores.Categoria;
import ecommerce.Model.MetodosAcessores.Produto;
import ecommerce.Model.MetodosAcessores.Venda;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Erik
 */
public interface VendaDAO {

    public List<Venda> ListarVendas(Date dataInicial , Date dataFinal) throws SQLException;

    public List<Produto> ListarProduto() throws SQLException;

    public List<Categoria> ListarCategoria() throws SQLException;

}
