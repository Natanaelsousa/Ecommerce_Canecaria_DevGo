package ecommerce.Model.DaoImplementation;

import ecommerce.Model.MetodosAcessores.Pagamento;
import ecommerce.Model.Dao.PagamentoDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sibele.nsantos
 */
public class PagamentoDAOImpl extends GenericaDAOImpl implements PagamentoDAO {

//    Busca uma determinada forma de pagamento
    public Pagamento BuscarFormaPagamento(int cod_pagamento) throws SQLException {

        String sql = "SELECT * FROM PAGAMENTO WHERE COD_PAGAMENTO =" + cod_pagamento;

        Pagamento pagamento = new Pagamento();

        PreparedStatement stmt
                = getConnection().prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            pagamento.setCod_pagamento(rs.getInt("COD_PAGAMENTO"));
            pagamento.setForma_pagamento(rs.getString("FORMA_PAGAMENTO"));

        }

        rs.close();
        stmt.close();
        return pagamento;
    }
    
    
    //Lista todos os tipos de pagamentos
    @Override
    public List<Pagamento> ListarPagamento() throws SQLException {
        List<Pagamento> pagamento = new ArrayList<Pagamento>();

        String query = "SELECT * FROM  PAGAMENTO";

        PreparedStatement stmt
                = getConnection().prepareStatement(query);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Pagamento pagamentos = new Pagamento();
            pagamentos.setCod_pagamento(rs.getInt("COD_PAGAMENTO"));
            pagamentos.setForma_pagamento(rs.getString("FORMA_PAGAMENTO"));

            pagamento.add(pagamentos);
        }

        rs.close();
        stmt.close();

        return pagamento;
    }
}
