package ecommerce.Model.Dao;

import ecommerce.Model.MetodosAcessores.Carrinho;
import ecommerce.Model.MetodosAcessores.Pedido;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Erik
 */
public interface CarrinhoDAO {

    public List<Carrinho> listarCarrinhoPorPedido(int pedido) throws SQLException;

    public List<Carrinho> ListarPedidosCarrinho() throws SQLException;
}
