package ecommerce.Model.DaoImplementation;

import ecommerce.Model.Dao.FinalizarCompraDAO;
import ecommerce.Model.MetodosAcessores.FinalizarCompra;
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
                   "INSERT INTO PRODUTO (NOME_PRODUTO, VALOR_PRODUTO, DESCRICAO_PRODUTO,QTDE_PRODUTO, COD_CATEGORIA) VALUES (?,?,?,?,?)";

   

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
    
}
