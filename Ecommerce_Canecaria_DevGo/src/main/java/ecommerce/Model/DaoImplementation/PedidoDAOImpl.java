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
    @Override
    public void CadastrarPedido(Pedido pedido) throws SQLException {
        String query = "INSERT INTO pedido(cod_cliente,cod_pagamento,valor_a_pagar,data_pedido,cod_status) "
                + "VALUES()";
        insert(query, pedido.getCod_cliente(), pedido.getCod_pagamento(), pedido.getValor_a_pagar(), pedido.getCod_pedido(), pedido.getCod_status());
    }

    //Edita os dados do pedido feito
    @Override
    public void EditarPedido(Pedido pedido) throws SQLException {
        String query = "UPDATE pedido "
                + "SET cod_cliente = ?, cod_pagamento = ? ,valor_a_pagar =?,cod_status = ?"
                + "WHERE cod_pedido = ?";
        insert(query, pedido.getCod_cliente(), pedido.getCod_pagamento(), pedido.getValor_a_pagar(), pedido.getCod_status());
    }

    //Lista de vendas por status
    @Override
    public List<Pedido> encontrarVendasPeloStatus(int id_status) throws SQLException {
        String queryPedidoPago = "SELECT * FROM PEDIDO WHERE COD_STATUS = " + id_status + " ";
        String queryPedidoSemPagamento = "SELECT * FROM PEDIDO WHERE COD_STATUS = " + id_status + " AND DATA_PEDIDO BETWEEN TIMESTAMP(DATE_SUB(NOW(), INTERVAL 3 day)) AND NOW() ";
        String queryPedidoEnviadosEcancelados = "SELECT * FROM PEDIDO WHERE COD_STATUS = " + id_status + " AND DATA_PEDIDO BETWEEN TIMESTAMP(DATE_SUB(NOW(), INTERVAL 30 day)) AND NOW() ";
        String query = null;

        if (id_status == 3) {
            query = queryPedidoPago;
        } else if (id_status == 2) {
            query = queryPedidoSemPagamento;
        } else if (id_status == 1 || id_status == 4) {
            query = queryPedidoEnviadosEcancelados;
        }
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

    
    //Atualiza um pedido para pago
    public void atualizarPedidoParaPago(Pedido pedido) throws SQLException {
        String update = "UPDATE pedido "
                + "SET cod_status = 4"
                + "WHERE cod_pedido = ?";
        update(update, pedido.getCod_status());
    }
    
    
    
}
