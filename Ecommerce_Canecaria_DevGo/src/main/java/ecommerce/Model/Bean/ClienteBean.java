/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Model.Bean;

import ecommerce.Model.Dao.ClienteDAO;
import ecommerce.Model.DaoImplementation.ClienteDAOImpl;
import ecommerce.Model.MetodosAcessores.Cliente;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

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
    public void cadastrarCliente() throws SQLException {
        getCriptoUser().setSenha(cliente.getSenha());
        cliente.setSenha(getCriptoUser().getHashSenha());
        ClienteDAOImpl daoCadastro = new ClienteDAOImpl();
        String usuarioJaRegistrado = daoCadastro.buscaClientesPorEmail(cliente.getEmail());
        if(!cliente.getEmail().equalsIgnoreCase(usuarioJaRegistrado)){
        try {
            daoCadastro.cadastrarCliente(cliente);
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Cadastro realizado com sucesso!"));
            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getFlash().setKeepMessages(true);

            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getFlash().setKeepMessages(true);
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteBean.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Falha ao cadastrar!"));
            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getFlash().setKeepMessages(true);

            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getFlash().setKeepMessages(true);
        }
        }else{
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Login já existe!"));
            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getFlash().setKeepMessages(true);

            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getFlash().setKeepMessages(true);
        }
        cliente = new Cliente();
    }

    public boolean editarCliente(Cliente cliente) {
        ClienteDAOImpl daoEditar = new ClienteDAOImpl();
        getCriptoUser().setSenha(cliente.getSenha());
        cliente.setSenha(getCriptoUser().getHashSenha());
        boolean resp = false;
        try {
            daoEditar.editarCadastroCliente(cliente);
            resp = true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteBean.class.getName()).log(Level.SEVERE, null, ex);
           resp = false;
        }
     return resp;   
    }

    // Responsavel por buscar um cliente pelo ID
    public String buscarClientePorId(int cod_cliente) {
        ClienteDAO clienteDAO = new ClienteDAOImpl();
        Cliente clienteEncontrado = null;
        try {
            clienteEncontrado = clienteDAO.buscaClientesPorId(cod_cliente);
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
