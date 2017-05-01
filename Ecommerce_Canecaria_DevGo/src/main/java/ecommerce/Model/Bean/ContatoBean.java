/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Model.Bean;

import ecommerce.Model.Dao.ContatoDAO;
import ecommerce.Model.DaoImplementation.ContatoDAOImpl;
import ecommerce.Model.MetodosAcessores.Contato;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/*  @author sibele */
@ManagedBean(name = "ContatoBean")
public class ContatoBean implements Serializable{

    private Contato contato = null;
    private Integer cod_solicitacao;
    private Integer cod_tipo_solicitacao;
    private String nome_completo;
    private String email_contato;
    private String descricao_contato;
    private Integer status_solicitacao;

    public ContatoBean() {
    }

    public Integer getStatus_solicitacao() {
        return status_solicitacao;
    }

    public void setStatus_solicitacao(Integer status_solicitacao) {
        this.status_solicitacao = status_solicitacao;
    }

    public Integer getCod_solicitacao() {
        return cod_solicitacao;
    }

    public void setCod_solicitacao(Integer cod_solicitacao) {
        this.cod_solicitacao = cod_solicitacao;
    }

    public Integer getCod_tipo_solicitacao() {
        return cod_tipo_solicitacao;
    }

    public void setCod_tipo_solicitacao(Integer cod_tipo_solicitacao) {
        this.cod_tipo_solicitacao = cod_tipo_solicitacao;
    }

    public String getNome_completo() {
        return nome_completo;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public String getEmail_contato() {
        return email_contato;
    }

    public void setEmail_contato(String email_contato) {
        this.email_contato = email_contato;
    }

    public String getDescricao_contato() {
        return descricao_contato;
    }

    public void setDescricao_contato(String descricao_contato) {
        this.descricao_contato = descricao_contato;
    }

    public Contato getContato() throws SQLException {
        ContatoDAO contatosDao = new ContatoDAOImpl();
        List<Contato> contatoList = null;
        if (contato == null) {
            FacesContext fc = FacesContext.getCurrentInstance();
            Map<String, String> params = fc.getExternalContext()
                    .getRequestParameterMap();
            String cod_tipo_solicitacao = params.get("cod_tipo_solicitacao");
            if (cod_tipo_solicitacao != null) {
                contatoList = contatosDao.ListarSolicitacoesDeFila(Integer.parseInt(cod_tipo_solicitacao));
            } else {
                contatoList = new ArrayList<Contato>();
            }
        }
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

}
