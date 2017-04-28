package ecommerce.Model.DaoImplementation;

import ecommerce.Model.MetodosAcessores.Pagamento;
import ecommerce.Model.Dao.PagamentoDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
