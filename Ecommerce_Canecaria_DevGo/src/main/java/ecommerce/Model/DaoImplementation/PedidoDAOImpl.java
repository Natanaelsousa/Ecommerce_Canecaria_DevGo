package ecommerce.Model.DaoImplementation;

import ecommerce.Model.MetodosAcessores.Pedido;
import ecommerce.Model.Dao.PedidoDAO;
import java.sql.SQLException;

/* @author sibele */
public class PedidoDAOImpl extends GenericaDAOImpl implements PedidoDAO{

    //Insere os dados do pedido realizado pelo cliente no banco
    public void CadastrarPedido(Pedido pedido) throws SQLException {
        String query = "INSERT INTO pedido(cod_cliente,cod_pagamento,valor_a_pagar,data_pedido,cod_status) "
                + "VALUES()";
        insert(query, pedido.getCod_cliente(), pedido.getCod_pagamento(), pedido.getValor_a_pagar(),pedido.getCod_pedido(),pedido.getCod_status());
    }
    
    //Edita os dados do pedido feito
    public void EditarPedido(Pedido pedido) throws SQLException {
        String query = "UPDATE pedido "
                + "SET cod_cliente = ?, cod_pagamento = ? ,valor_a_pagar =?,cod_status = ?"
                + "WHERE cod_pedido = ?";
        insert(query, pedido.getCod_cliente(), pedido.getCod_pagamento(), pedido.getValor_a_pagar(),pedido.getCod_status());
    }
}
