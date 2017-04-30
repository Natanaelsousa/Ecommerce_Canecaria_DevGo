/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Model.Bean;

import ecommerce.Model.DaoImplementation.ClienteDAOImpl;
import ecommerce.Model.MetodosAcessores.Cliente;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ClienteBean {

    private Cliente cliente = new Cliente();
    private UsuarioSistema criptoUser = new UsuarioSistema();

    /**
     * Creates a new instance of CadastroCliente
     */

    public void CadastrarCliente() {
        criptoUser.setSenha(cliente.getSenha());
        cliente.setSenha(criptoUser.getHashSenha());
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

    public void validaLogin() throws SQLException, IOException {
            ClienteDAOImpl daoValidar = new ClienteDAOImpl();
        RequestContext context = RequestContext.getCurrentInstance();
        criptoUser.setSenha(cliente.getSenha());
        cliente.setSenha(criptoUser.getHashSenha());
        String mensagem = "Erro ao se tentar se logar!";
        
        if(daoValidar.EncontraUserCliente(cliente) != null){
      FacesContext.getCurrentInstance().getExternalContext().redirect("AmbienteCliente.xhtml"); 
   }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Usuário ou senha inválidos", "Usuário ou senha inválidos");
            FacesContext.getCurrentInstance().addMessage(null, message);
            context.addCallbackParam("loggedIn", mensagem);
   }
        cliente = new Cliente();
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

}
