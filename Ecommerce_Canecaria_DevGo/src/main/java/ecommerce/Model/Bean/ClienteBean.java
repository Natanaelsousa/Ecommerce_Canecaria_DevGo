/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Model.Bean;

import ecommerce.Model.Dao.ClienteDAO;
import ecommerce.Model.DaoImplementation.ClienteDAOImpl;
import ecommerce.Model.MetodosAcessores.Cliente;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Natanael Santos
 */
@ManagedBean(name = "ClienteBean")
@RequestScoped
@SessionScoped
public class ClienteBean implements Serializable {

    private Cliente cliente = new Cliente();
    private UsuarioSistema criptoUser = new UsuarioSistema();

    /**
     * Creates a new instance of CadastroCliente
     */
    public void CadastrarCliente() {
        getCriptoUser().setSenha(cliente.getSenha());
        cliente.setSenha(getCriptoUser().getHashSenha());
        ClienteDAOImpl daoCadastro = new ClienteDAOImpl();
        try {
            daoCadastro.CadastrarCliente(cliente);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        cliente = new Cliente();
    }

    public void editarCliente() {
        ClienteDAOImpl daoEditar = new ClienteDAOImpl();
        try {
            daoEditar.EditarCadastroCliente(cliente);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        cliente = new Cliente();
    }

    public String validaLogin() throws SQLException, IOException {
        ClienteDAOImpl daoValidar = new ClienteDAOImpl();
        RequestContext context = RequestContext.getCurrentInstance();

        String mensagem = "Erro ao se tentar se logar!";

        if (getCriptoUser().obterUsuario(cliente.getEmail(), cliente.getSenha()) != null) {
            return "/protegido/AmbienteCliente.xhtml?faces-redirect=true";
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Usuário ou senha inválidos", "Usuário ou senha inválidos");
            FacesContext.getCurrentInstance().addMessage(null, message);
            context.addCallbackParam("loggedIn", mensagem);

            return "MinhaConta.xhtml?faces-redirect=true";
        }

    }

    // Responsavel por buscar um cliente pelo ID
    public String buscarClientePorId(int cod_cliente) {
        ClienteDAO clienteDAO = new ClienteDAOImpl();
        Cliente clienteEncontrado = null;
        try {
            clienteEncontrado = clienteDAO.BuscaClientesPorId(cod_cliente);
        } catch (SQLException erro) {
            System.err.println("Não foi possivel localizar as vendas");
        }
        
        String nomeCliente = clienteEncontrado.getNome();
        return nomeCliente;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the criptoUser
     */
    public UsuarioSistema getCriptoUser() {
        return criptoUser;
    }

    /**
     * @param criptoUser the criptoUser to set
     */
    public void setCriptoUser(UsuarioSistema criptoUser) {
        this.criptoUser = criptoUser;
    }

}
