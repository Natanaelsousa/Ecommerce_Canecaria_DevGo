/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Model.Bean;

import ecommerce.Model.DaoImplementation.ClienteDAOImpl;
import ecommerce.Model.MetodosAcessores.Cliente;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

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
    

  public void CadastrarCliente (){
     criptoUser.setSenha(cliente.getSenha());
     cliente.setSenha(criptoUser.getHashSenha());
     ClienteDAOImpl daoCadastro = new ClienteDAOImpl (); 
     try{
         daoCadastro.CadastrarCliente(cliente);
     }  catch (SQLException ex) {
            Logger.getLogger(ClienteBean.class.getName()).log(Level.SEVERE, null, ex);
        }
     cliente = new Cliente ();
  }
  public void editarCliente (){
    ClienteDAOImpl daoEditar = new ClienteDAOImpl (); 
     try{
         daoEditar.EditarCadastroCliente(cliente);
     }  catch (SQLException ex) {
            Logger.getLogger(ClienteBean.class.getName()).log(Level.SEVERE, null, ex);
        }  
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
