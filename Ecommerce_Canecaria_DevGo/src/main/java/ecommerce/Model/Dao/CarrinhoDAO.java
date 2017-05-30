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
    
        // Responsavel por cadastrar a compra do cliente
    public void CadastrarPedido(Carrinho carrinho) throws SQLException;
}
