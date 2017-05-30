/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Model.Bean;

import ecommerce.Model.DaoImplementation.ClienteDAOImpl;
import ecommerce.Model.DaoImplementation.FuncionarioDAOImpl;
import ecommerce.Model.MetodosAcessores.Cliente;
import ecommerce.Model.MetodosAcessores.Funcionario;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;


/**
 *
 * @author natan
 */
@ManagedBean(name = "LoginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private Cliente cliente = new Cliente();
    private UsuarioSistema criptoUser = new UsuarioSistema();
    private ClienteBean user = new ClienteBean();

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
     private Funcionario funcionario = new Funcionario();

    public ClienteBean getUser() {
        return user;
    }

    public void setUser(ClienteBean user) {
        this.user = user;
    }
    
    
    public LoginBean() {
    }
    public String editarUsuarioLogado(){
        boolean resp = user.editarCliente(cliente);
        if(resp == true){
        return "../AmbienteCliente.xhtml?faces-redirect=true";
        }else{
            return "EditarCadastroCliente.xhtml?faces-redirect=true";
        }
    } 
      public String validaLogin() throws SQLException, IOException {
        ClienteDAOImpl daoValidar = new ClienteDAOImpl();
        RequestContext context = RequestContext.getCurrentInstance();

        String mensagem = "Erro ao se tentar se logar!";
         cliente =  criptoUser.obterUsuario(cliente.getEmail(),cliente.getSenha());
        if (cliente != null) {
            return "/protegido/AmbienteCliente.xhtml?faces-redirect=true";
        } else {
          

            return "MinhaConta.xhtml?faces-redirect=true";
        }

    }
      
      
       
    
        public String validaLoginFuncionario() throws SQLException, IOException {
            FuncionarioDAOImpl daoValidarFunc = new FuncionarioDAOImpl();
        RequestContext context = RequestContext.getCurrentInstance();
   
        String mensagem = "Erro ao se tentar se logar!";
        
      
         funcionario =  criptoUser.obterUsuarioFunc(funcionario.getLogin_funcionario(),funcionario.getSenha_funcionario());
        if (funcionario != null) {
            return "/protegido/AmbienteFuncionario.xhtml?faces-redirect=true";
        } else {
          

            return "LoginEmpresa.xhtml?faces-redirect=true";
        }

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public UsuarioSistema getCriptoUser() {
        return criptoUser;
    }

    public void setCriptoUser(UsuarioSistema criptoUser) {
        this.criptoUser = criptoUser;
    }
    
}
