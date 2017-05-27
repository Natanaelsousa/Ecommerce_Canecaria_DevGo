package ecommerce.Model.Bean;

import ecommerce.Model.Dao.ContatoDAO;
import ecommerce.Model.DaoImplementation.ContatoDAOImpl;
import ecommerce.Model.MetodosAcessores.Contato;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/*  @author sibele */
@ManagedBean(name = "ContatoBean")
@SessionScoped
public class ContatoBean {

    private Contato contato = new Contato();
    private int id_contato;

    public ContatoBean() {
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public int getId_contato() {
        return id_contato;
    }

    public void setId_contato(int id_contato) {
        this.id_contato = id_contato;
    }

    /*Responsavel pelo insert dos formularios de solicitação*/
    public void cadastrarSolicitacaoContato() throws Exception {
        ContatoDAO contatos = new ContatoDAOImpl();
        try {
            contatos.cadastrarSolicitacaoContato(contato);
        } catch (SQLException erro) {
            System.err.println("Não foi possivel realizar solicitação");
        }
        contato = new Contato();
    }

    /* Verifica quantos chamados tem em cada fila */
    public int countSolicitacaoChamadoContato(int cod_tipo_solicitacao) throws Exception {
        ContatoDAO contatos = new ContatoDAOImpl();
        int quantidadeChamados = contatos.countSolicitacaoChamadoContato(cod_tipo_solicitacao);

        return quantidadeChamados;
    }

    /* Lista os produtos cadastrados no banco */
    public List<Contato> listarSolicitacoesContatos() throws Exception {
        ContatoDAO contatosDao = new ContatoDAOImpl();
        List<Contato> listarSolicitacoesContatos = null;
        listarSolicitacoesContatos = contatosDao.listarSolicitacoesContatos();

        if (listarSolicitacoesContatos.isEmpty()) {
            listarSolicitacoesContatos = null;
        }
        return listarSolicitacoesContatos;
    }

    public String encontrarFilaPorId() throws Exception {
        ContatoDAO contatos = new ContatoDAOImpl();
        String retorno = null;
        List<Contato> listarSolicitacoesContatos = null;
        try {
            listarSolicitacoesContatos = contatos.encontrarFilaPorId(id_contato);
        } catch (SQLException erro) {
            System.err.println("Não foi possivel localizar fila");
        }
        if (id_contato == 1 || id_contato == 2 || id_contato == 3 || id_contato == 4 || id_contato == 5 || id_contato == 6) {
            retorno = "RespondendoFaleConosco";
        } else {
            retorno = "AcompanhamentoFaleConosco";
        }
        return retorno;
    }

    public List<Contato> listEncontrarFilaPorId() throws Exception {
        ContatoDAO contatos = new ContatoDAOImpl();
        List<Contato> listarSolicitacoesContatos = null;
        try {
            listarSolicitacoesContatos = contatos.encontrarFilaPorId(id_contato);
        } catch (SQLException erro) {
            System.err.println("Não foi possivel localizar fila");
        }
        return listarSolicitacoesContatos;
    }

    public String finalizandoChamado(int cod_chamado) throws Exception {
        ContatoDAO contatos = new ContatoDAOImpl();
        try {
            contatos.finalizarChamado(contato, cod_chamado);
        } catch (SQLException erro) {
            System.err.println("Não foi possivel realizar solicitação");
        }
        FacesContext.getCurrentInstance().getExternalContext().redirect("AcompanhamentoFaleConosco.xhtml");
        return "OK";
    }
    
     public String voltando() throws Exception {
    
        FacesContext.getCurrentInstance().getExternalContext().redirect("AcompanhamentoFaleConosco.xhtml");
        return "OK";
    }

}
