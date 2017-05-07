package ecommerce.Model.DaoImplementation;

import ecommerce.Model.Dao.FinalizarCompraDAO;
import ecommerce.Model.MetodosAcessores.FinalizarCompra;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Erik
 */
public class FinalizarCompraDAOImpl extends GenericaDAOImpl implements FinalizarCompraDAO {

    @Override
    public void CadastrarPedido(FinalizarCompra finalizaCompra) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FinalizarCompra> ListarPedidos(Integer codCliente) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
