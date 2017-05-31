/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Model.DaoImplementation;

import ecommerce.Model.Dao.CarrinhoDAO;
import ecommerce.Model.MetodosAcessores.Carrinho;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Erik
 */
public class CarrinhoDAOImpl extends GenericaDAOImpl implements CarrinhoDAO {

    //Lista de vendas por status
    public List<Carrinho> listarCarrinhoPorPedido(int pedido) throws SQLException {
        String query = "SELECT * FROM CARRINHO WHERE COD_PEDIDO = " + pedido + " ";
        List<Carrinho> carrinho = new ArrayList<Carrinho>();

        PreparedStatement stmt
                = getConnection().prepareStatement(query);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Carrinho carrinhoPedido = new Carrinho();
            carrinhoPedido.setCod_pedido(rs.getInt("COD_PEDIDO"));
            carrinhoPedido.setCod_carrinho(rs.getInt("COD_CARRINHO"));
            carrinhoPedido.setCod_cliente(rs.getInt("COD_CLIENTE"));
            carrinhoPedido.setCod_produto(rs.getInt("COD_PROD"));
            carrinhoPedido.setQtde_produto(rs.getInt("QTDE_PRODUTO"));
            carrinhoPedido.setSubtotal(rs.getDouble("SUB_TOTAL"));

            carrinho.add(carrinhoPedido);
        }

        rs.close();
        stmt.close();
        return carrinho;
    }

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
