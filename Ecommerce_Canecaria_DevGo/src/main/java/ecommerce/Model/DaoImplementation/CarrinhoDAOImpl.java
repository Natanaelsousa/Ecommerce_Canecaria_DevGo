/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Model.DaoImplementation;

import ecommerce.Model.Dao.CarrinhoDAO;
import ecommerce.Model.MetodosAcessores.Carrinho;
import ecommerce.Model.MetodosAcessores.Pedido;
import ecommerce.Model.MetodosAcessores.Produto;
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

    //Retira produtos do estoque e atualiza o status do pedido para 5
    @Override
    public void retirarProdutoDoEstoque(List<Carrinho> itensCarrinho) throws SQLException {
        Carrinho carrinho = new Carrinho();
        for (int i = 0; i < itensCarrinho.size(); i++) {
          
            carrinho = itensCarrinho.get(i);
            String update = "update produto set QTDE_PRODUTO = QTDE_PRODUTO - ? where COD_PROD = ? ";
            update(update, carrinho.getCod_produto(), carrinho.getQtde_produto());
        }
     

    }
      @Override
    public void CadastrarPedido(List<Produto> produtos , int cod_cliente) throws SQLException {
        String query = "INSERT INTO CARRINHO (QTDE_PRODUTO, COD_PEDIDO, COD_CLIENTE,COD_PROD) VALUES (?,?,?,?)";

        // Ao cadastrar um produto, a quantidade dele inicia por padrão como 0
        int codPedido  = 0;
        for(int i=0; i<produtos.size(); i++){
        insert(query, produtos.get(i).getQtde_produto(), codPedido, cod_cliente,
              produtos.get(i).getCod_produto());
        }
    }
}
