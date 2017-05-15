
package ecommerce.Model.Dao;

import ecommerce.Model.MetodosAcessores.ResumoPedido;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Erik
 */
public interface ResumoPedidoDAO {
    
    public List<ResumoPedido> ListarItensPedido(Integer codCliente) throws SQLException;
    
}
