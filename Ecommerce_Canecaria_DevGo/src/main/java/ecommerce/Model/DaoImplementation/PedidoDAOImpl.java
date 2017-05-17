package ecommerce.Model.DaoImplementation;

import ecommerce.Model.MetodosAcessores.Pedido;
import ecommerce.Model.Dao.PedidoDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author sibele */
public class PedidoDAOImpl extends GenericaDAOImpl implements PedidoDAO {

    //Insere os dados do pedido realizado pelo cliente no banco
    public void CadastrarPedido(Pedido pedido) throws SQLException {
        String query = "INSERT INTO pedido(cod_cliente,cod_pagamento,valor_a_pagar,data_pedido,cod_status) "
                + "VALUES()";
        insert(query, pedido.getCod_cliente(), pedido.getCod_pagamento(), pedido.getValor_a_pagar(), pedido.getCod_pedido(), pedido.getCod_status());
    }

    //Edita os dados do pedido feito
    public void EditarPedido(Pedido pedido) throws SQLException {
        String query = "UPDATE pedido "
                + "SET cod_cliente = ?, cod_pagamento = ? ,valor_a_pagar =?,cod_status = ?"
                + "WHERE cod_pedido = ?";
        insert(query, pedido.getCod_cliente(), pedido.getCod_pagamento(), pedido.getValor_a_pagar(), pedido.getCod_status());
    }

    //Lista de vendas por status
    public List<Pedido> encontrarVendasPeloStatus(int id_status) throws SQLException {
        String query = "SELECT * FROM PEDIDO WHERE COD_STATUS = " + id_status + " ";
        List<Pedido> pedidos = new ArrayList<Pedido>();

        PreparedStatement stmt
                = getConnection().prepareStatement(query);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Pedido pedido = new Pedido();
            pedido.setCod_pedido(rs.getInt("COD_PEDIDO"));
            pedido.setCod_cliente(rs.getInt("COD_CLIENTE"));
            pedido.setCod_pagamento(rs.getInt("COD_PAGAMENTO"));
            pedido.setCod_status(rs.getInt("COD_STATUS"));
            pedido.setData_pedido(rs.getTimestamp("DATA_PEDIDO"));
            pedido.setValor_a_pagar(rs.getInt("VALOR_TOTAL_COMPRA"));
            pedido.setCep(rs.getString("CEP"));
            pedido.setRua(rs.getString("RUA"));
            pedido.setNumero(rs.getString("NUMERO"));
            pedido.setBairro(rs.getString("BAIRRO"));
            pedido.setCidade(rs.getString("CIDADE"));
            pedido.setEstado(rs.getString("ESTADO"));
            pedidos.add(pedido);
        }

        rs.close();
        stmt.close();
        return pedidos;
    }
}
