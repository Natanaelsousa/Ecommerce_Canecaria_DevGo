package ecommerce.Model.DaoImplementation;

import ecommerce.Model.Dao.VendaDAO;
import ecommerce.Model.MetodosAcessores.Categoria;
import ecommerce.Model.MetodosAcessores.Produto;
import ecommerce.Model.MetodosAcessores.Venda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Erik
 */
public class VendaDAOImpl extends GenericaDAOImpl implements VendaDAO {

    @Override
    
    // periodooo
    public List<Venda> ListarVendas(Date dataInicial , Date dataFinal) throws SQLException {

        List<Venda> venda = new ArrayList<Venda>();

        String query = "SELECT a.COD_PEDIDO,b.NOME,b.CPF, c.FORMA_PAGAMENTO, a.VALOR_TOTAL_COMPRA,a.DATA_PEDIDO, d.ESTADO "
                + "FROM pedido a "
                + "INNER JOIN cliente b ON (a.COD_CLIENTE = b.COD_CLIENTE) "
                + "INNER JOIN pagamento c ON (a.COD_PAGAMENTO = c.COD_PAGAMENTO) "
                + "INNER JOIN status  d ON (a.COD_STATUS = d.COD_STATUS)"
                + "BETWEEN  '"+dataInicial+"' AND'"+dataFinal+"'" ;

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
        closeConnetion();

        return venda;

    }

    public List<Produto> ListarProduto() throws SQLException {

        List<Produto> produto = new ArrayList<Produto>();

        String query = "SELECT b.NOME_PRODUTO, COUNT(*) AS QUANTIDADE FROM carrinho a\n"
                + "INNER JOIN produto b ON (a.COD_PROD = b.COD_PROD)\n"
                + "INNER JOIN pedido c ON (a.COD_PEDIDO = c.COD_PEDIDO)\n"
                + "WHERE (a.COD_PEDIDO <> 0) AND (c.COD_STATUS = 3) OR (c.COD_STATUS = 4) AND (DATE(c.DATA_PEDIDO) \n"
                + "BETWEEN DATE (NOW()) AND DATE_ADD(DATE(NOW()),INTERVAL -10 DAY))GROUP BY b.NOME_PRODUTO ORDER BY QUANTIDADE DESC LIMIT 10";

          PreparedStatement stmt
                = getConnection().prepareStatement(query);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Produto produtos = new Produto();
                      
           
            produtos.setNome_produto(rs.getString("NOME_PRODUTO"));
            produtos.setQuantRelatorio(rs.getInt("QUANTIDADE"));
            
        
            

            produto.add(produtos);
        }

        rs.close();
        stmt.close();
        closeConnetion();

        return produto;


}
    
    public List<Categoria> ListarCategoria() throws SQLException {

        List<Categoria> categoria = new ArrayList<Categoria>();

        String query = "SELECT d.NOME_CATEGORIA, COUNT(*) AS QUANTIDADE FROM carrinho a INNER JOIN produto b ON "
                + "(a.COD_PROD = b.COD_PROD)INNER JOIN pedido c ON (a.COD_PEDIDO = c.COD_PEDIDO)"
                + "INNER JOIN categoria d ON (b.COD_CATEGORIA = d.COD_CATEGORIA)WHERE (a.COD_PEDIDO <> 0) "
                + "AND (c.COD_STATUS = 3) OR (c.COD_STATUS = 4) AND (DATE(c.DATA_PEDIDO) BETWEEN DATE (NOW()) "
                + "AND DATE_ADD(DATE(NOW()),INTERVAL -10 DAY))GROUP BY d.NOME_CATEGORIA ORDER BY d.NOME_CATEGORIA ASC";

          PreparedStatement stmt
                = getConnection().prepareStatement(query);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Categoria categorias = new Categoria();

           
           
            categorias.setNome_categoria(rs.getString("NOME_CATEGORIA"));
            categorias.setQuant(rs.getInt("QUANTIDADE"));
            

            categoria.add(categorias);
        }

        rs.close();
        stmt.close();
        closeConnetion();

        return categoria;


}
}
