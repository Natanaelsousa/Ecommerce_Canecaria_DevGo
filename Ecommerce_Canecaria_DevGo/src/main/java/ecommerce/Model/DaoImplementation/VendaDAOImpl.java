
package ecommerce.Model.DaoImplementation;

import ecommerce.Model.Dao.VendaDAO;
import ecommerce.Model.MetodosAcessores.Venda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Erik
 */
public class VendaDAOImpl  extends GenericaDAOImpl implements VendaDAO{

    @Override
    public List<Venda> ListarVendas() throws SQLException {
        
         List<Venda> venda = new ArrayList<Venda>();

        String query = "SELECT a.COD_PEDIDO,b.NOME,b.CPF, c.FORMA_PAGAMENTO, a.VALOR_TOTAL_COMPRA,a.DATA_PEDIDO, d.ESTADO " +
            "FROM pedido a " +
            "INNER JOIN cliente b ON (a.COD_CLIENTE = b.COD_CLIENTE) " +
            "INNER JOIN pagamento c ON (a.COD_PAGAMENTO = c.COD_PAGAMENTO) " +
            "INNER JOIN status  d ON (a.COD_STATUS = d.COD_STATUS)";

        PreparedStatement stmt
                = getConnection().prepareStatement(query);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Venda vendas = new Venda();
            vendas.setCodPedido(rs.getInt("COD_PEDIDO"));
            vendas.setNome(rs.getString("NOME"));
            vendas.setCpf(rs.getString("CPF"));
            vendas.setFormaPagamento(rs.getString("FORMA_PAGAMENTO"));
            vendas.setValorTotal(rs.getDouble("VALOR_TOTAL_COMPRA"));
            vendas.setDataPedido(rs.getTimestamp("DATA_PEDIDO"));
            vendas.setEstadoCompra(rs.getString("ESTADO"));
  
            venda.add(vendas);
        }

        rs.close();
        stmt.close();

        return venda;
        
    }
    
    
       
    
}
