package ecommerce.Model.Dao;

import ecommerce.Model.MetodosAcessores.TipoSolicitacao;
import java.sql.SQLException;
import java.util.List;

/*  @author sibele */
public interface TipoSolicitacaoDAO {

    public List<TipoSolicitacao> listarTiposDeSolicitacoes() throws SQLException;
}
