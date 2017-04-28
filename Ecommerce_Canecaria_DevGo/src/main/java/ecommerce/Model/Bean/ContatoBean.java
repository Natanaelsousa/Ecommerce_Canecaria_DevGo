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

/*  @author sibele */
@ManagedBean(name = "ContatoBean")
public class ContatoBean {

    private Contato contato = new Contato();

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    /*Responsavel pelo insert dos formularios de solicitação*/
    public String CadastrarSolicitacaoContato() throws Exception {
        ContatoDAO contatos = new ContatoDAOImpl();
        contatos.CadastrarSolicitacaoContato(contato);
        return "Solicitação de contato enviada";
    }

    /* Verifica quantos chamados tem em cada fila */
    public int CountSolicitacaoChamadoContato(int cod_tipo_solicitacao) throws Exception {
        ContatoDAO contatos = new ContatoDAOImpl();
        int quantidadeChamados= contatos.CountSolicitacaoChamadoContato(cod_tipo_solicitacao);
        
        return quantidadeChamados;
    }
    
    
     /* Lista os produtos cadastrados no banco */
    public List<Contato> ListarSolicitacoesContatos() throws Exception {
        ContatoDAO contatosDao = new ContatoDAOImpl();

     List<Contato> ListarSolicitacoesContatos = contatosDao.ListarSolicitacoesContatos();

        return ListarSolicitacoesContatos;
    }
    

    
    public ContatoBean() {
    }

}
