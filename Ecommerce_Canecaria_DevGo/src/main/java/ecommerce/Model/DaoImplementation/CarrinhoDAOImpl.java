/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Model.DaoImplementation;

import ecommerce.Model.Dao.CarrinhoDAO;
import ecommerce.Model.MetodosAcessores.Carrinho;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Erik
 */
public class CarrinhoDAOImpl extends GenericaDAOImpl implements CarrinhoDAO{

    @Override
    public List<Carrinho> ListarPedidosCarrinho() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void CadastrarPedido(Carrinho carrinho) throws SQLException {
            String query = "INSERT INTO CARRINHO (QTDE_PRODUTO, COD_PEDIDO, COD_CLIENTE,COD_PROD,) VALUES (?,?,?,?)";

        // Ao cadastrar um produto, a quantidade dele inicia por padrão como 0
        carrinho.setCod_pedido(0);
        insert(query, carrinho.getQtde_produto(), carrinho.getCod_pedido(), carrinho.getCod_cliente(),
        carrinho.getCod_produto());
    }
    
}
