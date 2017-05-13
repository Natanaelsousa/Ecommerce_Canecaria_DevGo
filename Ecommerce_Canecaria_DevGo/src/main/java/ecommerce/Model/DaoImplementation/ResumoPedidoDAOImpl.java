/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Model.DaoImplementation;

import ecommerce.Model.MetodosAcessores.ResumoPedido;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ecommerce.Model.Dao.ResumoPedidoDAO;

/**
 *
 * @author Erik
 */
public class ResumoPedidoDAOImpl extends GenericaDAOImpl implements ResumoPedidoDAO {

    @Override
    public List<ResumoPedido> ListarItensPedido(Integer codCliente) throws SQLException {
        
        
         List<ResumoPedido> resumoPedido = new ArrayList<ResumoPedido>();

        String query = "SELECT b.NOME_PRODUTO, a.QTDE_PRODUTO,a.SUB_TOTAL\n" +
                        "FROM carrinho a\n" +
                        "INNER JOIN produto b ON (a.COD_PROD = b.COD_PROD)\n" +
                        "WHERE a.COD_PEDIDO = 0 AND COD_CLIENTE = "+codCliente;

        PreparedStatement stmt
                = getConnection().prepareStatement(query);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            
            ResumoPedido resumoPedidos = new ResumoPedido();
            
            resumoPedidos.setNomeProduto(rs.getString("NOME_PRODUTO"));
            
            resumoPedidos.setQuantidadeProduto(rs.getInt("QTDE_PRODUTO"));
                        
            resumoPedidos.setSubtotal(rs.getDouble("SUB_TOTAL"));
            
  
            resumoPedido.add(resumoPedidos);
        }

        rs.close();
        stmt.close();

        return resumoPedido;
        
        
    }
    
}
