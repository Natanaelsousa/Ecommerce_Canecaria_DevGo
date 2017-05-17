
package ecommerce.Model.DaoImplementation;

import ecommerce.Model.Dao.StatusDAO;
import ecommerce.Model.MetodosAcessores.Status;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*@author sibele*/
public class StatusDAOImpl extends GenericaDAOImpl implements StatusDAO{
    
    //Lista os possiveis status das vendas
    public List<Status> ListarStatusDasVenda() throws SQLException {
        List<Status> statusVenda = new ArrayList<Status>();

        String query = "SELECT * FROM STATUS";

        PreparedStatement stmt
                = getConnection().prepareStatement(query);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
          Status statusVendas = new Status();

            statusVendas.setCod_status(rs.getInt("COD_STATUS"));
            statusVendas.setNome_status(rs.getString("ESTADO"));

            statusVenda.add(statusVendas);
        }

        rs.close();
        stmt.close();

        return statusVenda;

    }
}
