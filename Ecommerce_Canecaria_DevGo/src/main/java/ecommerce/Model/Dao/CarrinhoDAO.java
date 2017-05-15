package ecommerce.Model.Dao;

import ecommerce.Model.MetodosAcessores.Carrinho;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author Erik
 */
public interface CarrinhoDAO {
    
    public List<Carrinho> ListarPedidosCarrinho() throws SQLException;
}
