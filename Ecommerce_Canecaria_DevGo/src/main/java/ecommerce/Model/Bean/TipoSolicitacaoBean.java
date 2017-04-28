package ecommerce.Model.Bean;

import ecommerce.Model.Dao.TipoSolicitacaoDAO;
import ecommerce.Model.DaoImplementation.TipoSolicitacaoDAOImpl;
import ecommerce.Model.MetodosAcessores.TipoSolicitacao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

/*  @author sibele */
@ManagedBean(name = "TipoSolicitacaoBean")
public class TipoSolicitacaoBean {

   private TipoSolicitacao tiposSolicitacoes = new TipoSolicitacao();

    public TipoSolicitacao getTiposSolicitacoes() {
        return tiposSolicitacoes;
    }

    public void setTiposSolicitacoes(TipoSolicitacao tiposSolicitacoes) {
        this.tiposSolicitacoes = tiposSolicitacoes;
    }

   
   
   /* Lista os tipos de solicitações cadastrados no banco */
    public List<SelectItem> ListarTiposDeSolicitacoes() throws Exception {
        TipoSolicitacaoDAO tipoSolicitacaoDAO = new TipoSolicitacaoDAOImpl();

        List<TipoSolicitacao> listarSolicitacoes = tipoSolicitacaoDAO.ListarTiposDeSolicitacoes();
        List<SelectItem> itensSolicitacoes = new ArrayList<SelectItem>(listarSolicitacoes.size());

        for (TipoSolicitacao solic : listarSolicitacoes) {
            itensSolicitacoes.add(new SelectItem(solic.getCod_tipo_solicitacao(), solic.getTipo_solicitacao_nome()));
        }
        return itensSolicitacoes;
    }
    
    
    public TipoSolicitacaoBean() {
    }

}
