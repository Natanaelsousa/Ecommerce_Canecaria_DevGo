package ecommerce.Model.DaoImplementation;

import ecommerce.Model.Dao.TipoSolicitacaoDAO;
import ecommerce.Model.MetodosAcessores.TipoSolicitacao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author sibele */
public class TipoSolicitacaoDAOImpl extends GenericaDAOImpl implements TipoSolicitacaoDAO {

    //Lista todos os tipos de solicitações possiveis
    public List<TipoSolicitacao> ListarTiposDeSolicitacoes() throws SQLException {
        List<TipoSolicitacao> tiposSolicitacoes = new ArrayList<TipoSolicitacao>();

        String query = "SELECT * FROM TIPOSOLICITACAO";

        PreparedStatement stmt
                = getConnection().prepareStatement(query);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            TipoSolicitacao solicitacoes = new TipoSolicitacao();
            solicitacoes.setCod_tipo_solicitacao(rs.getInt("COD_TIPO_SOLICITACAO"));
            solicitacoes.setTipo_solicitacao_nome(rs.getString("TIPO_SOLICIACAO_NOME"));

            tiposSolicitacoes.add(solicitacoes);
        }

        rs.close();
        stmt.close();

        return tiposSolicitacoes;

    }

}
