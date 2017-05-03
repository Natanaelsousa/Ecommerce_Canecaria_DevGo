/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Model.Bean;

import ecommerce.Model.Dao.ContatoDAO;
import ecommerce.Model.DaoImplementation.ContatoDAOImpl;
import ecommerce.Model.MetodosAcessores.Contato;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/*  @author sibele */
@ManagedBean(name = "ContatoBean")
@RequestScoped
public class ContatoBean  {

    private Contato contato = new Contato();

    public ContatoBean() {
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    /*Responsavel pelo insert dos formularios de solicitação*/
    public void CadastrarSolicitacaoContato() throws Exception {
        ContatoDAO contatos = new ContatoDAOImpl();
        try{
        contatos.CadastrarSolicitacaoContato(contato);
        }catch(SQLException erro){
            System.err.println("Não foi possivel realizar solicitação");
        }
        contato = new Contato();
    }

    /* Verifica quantos chamados tem em cada fila */
    public int CountSolicitacaoChamadoContato(int cod_tipo_solicitacao) throws Exception {
        ContatoDAO contatos = new ContatoDAOImpl();
        int quantidadeChamados = contatos.CountSolicitacaoChamadoContato(cod_tipo_solicitacao);

        return quantidadeChamados;
    }

    /* Lista os produtos cadastrados no banco */
    public List<Contato> ListarSolicitacoesContatos() throws Exception {
        ContatoDAO contatosDao = new ContatoDAOImpl();
        List<Contato> ListarSolicitacoesContatos = null;
        ListarSolicitacoesContatos = contatosDao.ListarSolicitacoesContatos();

        if (ListarSolicitacoesContatos.isEmpty()) {
            ListarSolicitacoesContatos = null;
        }
        return ListarSolicitacoesContatos;
    }

    //    private Contato contato = null;
    //    public Contato getContato() throws SQLException {
//        ContatoDAO contatosDao = new ContatoDAOImpl();
//        List<Contato> contatoList = null;
//        if (contato == null) {
//            FacesContext fc = FacesContext.getCurrentInstance();
//            Map<String, String> params = fc.getExternalContext()
//                    .getRequestParameterMap();
//            String cod_tipo_solicitacao = params.get("cod_tipo_solicitacao");
//            if (cod_tipo_solicitacao != null) {
//                contatoList = contatosDao.ListarSolicitacoesDeFila(Integer.parseInt(cod_tipo_solicitacao));
//            } else {
//                contatoList = new ArrayList<Contato>();
//            }
//        }
//        return contato;
//    }
}
