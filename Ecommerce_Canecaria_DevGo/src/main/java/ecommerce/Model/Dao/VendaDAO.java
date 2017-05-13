
package ecommerce.Model.Dao;

import ecommerce.Model.MetodosAcessores.Venda;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Erik
 */
public interface VendaDAO {
    
     public List<Venda> ListarVendas() throws SQLException;
    
}
