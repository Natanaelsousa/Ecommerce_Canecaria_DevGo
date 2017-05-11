package ecommerce.Model.Dao;

import ecommerce.Model.MetodosAcessores.FinalizarCompra;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Erik
 */
public interface FinalizarCompraDAO {
    
    public void CadastrarPedido(FinalizarCompra finalizaCompra) throws SQLException;
    
    public List<FinalizarCompra> ListarPedidos(Integer codCliente) throws SQLException;
    
    public double ValorTotal(Integer codCliente) throws SQLException;
    

}
