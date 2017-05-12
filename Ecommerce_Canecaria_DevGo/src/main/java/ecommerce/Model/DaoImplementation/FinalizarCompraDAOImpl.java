package ecommerce.Model.DaoImplementation;

import ecommerce.Model.Dao.FinalizarCompraDAO;
import ecommerce.Model.MetodosAcessores.FinalizarCompra;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Erik
 */
public class FinalizarCompraDAOImpl extends GenericaDAOImpl implements FinalizarCompraDAO {
    
    
    @Override
    public void CadastrarPedido(FinalizarCompra finalizaCompra) throws SQLException {
        
           String query = 
                   "INSERT INTO PEDIDO (COD_PAGAMENTO, COD_CLIENTE,COD_STATUS, CEP,RUA, NUMERO, BAIRRO, CIDADE, ESTADO, COD_FINALIZACAO_COMPRA, VALOR_TOTAL_COMPRA) "
                   + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";

   

        insert(query, 
                finalizaCompra.getCodPagamento(),finalizaCompra.getCodCliente(), 
                finalizaCompra.getCodStatus(), finalizaCompra.getCep(), 
                finalizaCompra.getRua(), finalizaCompra.getNumero(), 
                finalizaCompra.getBairro(), finalizaCompra.getCidade(), finalizaCompra.getEstado(), 
                finalizaCompra.getCodFinalizacaoCompra(), finalizaCompra.getValorTotalCompra());
       
    }

    @Override
    public List<FinalizarCompra> ListarPedidos(Integer codCliente) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double ValorTotal(Integer codCliente) throws SQLException {
        
        double totalCompra = 0;

        String query = "SELECT SUM(SUB_TOTAL) AS valorTotal FROM carrinho WHERE COD_PEDIDO = 0 AND COD_CLIENTE = "+codCliente;

        PreparedStatement stmt
                = getConnection().prepareStatement(query);

        ResultSet rs = stmt.executeQuery();
        
              if(rs != null && rs.next()){
                   
              totalCompra = rs.getFloat("valorTotal");
        
              }
        
       
        rs.close();
        stmt.close();

        return totalCompra;
        
    }
    
}
