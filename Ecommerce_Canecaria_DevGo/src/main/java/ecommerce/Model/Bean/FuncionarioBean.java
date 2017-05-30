package ecommerce.Model.Bean;

import ecommerce.Model.Dao.FuncionarioDAO;
import ecommerce.Model.DaoImplementation.FuncionarioDAOImpl;
import ecommerce.Model.MetodosAcessores.Funcionario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/* @author Alessandra */
@ManagedBean(name = "FuncionarioBean")
@RequestScoped

public class FuncionarioBean {

    private String cpf;

    public String getCpf() {
        return cpf;
    }

    private UsuarioSistema criptoUserFunc = new UsuarioSistema();

    public UsuarioSistema getCriptoUserFunc() {
        return criptoUserFunc;
    }

    public void setCriptoUserFunc(UsuarioSistema criptoUserFunc) {
        this.criptoUserFunc = criptoUserFunc;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    private Funcionario funcionario = new Funcionario();

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public FuncionarioBean() {

    }

    FuncionarioDAOImpl funcionarioDao = new FuncionarioDAOImpl();

    public void CadastrarFuncionario() throws Exception {

        getCriptoUserFunc().setSenha(funcionario.getSenha_funcionario());
        funcionario.setSenha_funcionario(getCriptoUserFunc().getHashSenha());
        FuncionarioDAO funcionarios = new FuncionarioDAOImpl();
        try {
            funcionarios.CadastrarFuncionario(funcionario);
        } catch (SQLException ex) {

            Logger.getLogger(FuncionarioBean.class.getName()).log(Level.SEVERE, null, ex);;
        }

        funcionario = new Funcionario();

       
    }

    public void EditarFuncionario() throws Exception {
        getCriptoUserFunc().setSenha(funcionario.getSenha_funcionario());
        funcionario.setSenha_funcionario(getCriptoUserFunc().getHashSenha());
        FuncionarioDAO funcionarios = new FuncionarioDAOImpl();

        try {
            funcionarios.EditarCadastroFuncionario(funcionario);
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        funcionario = new Funcionario();

       

    }

    public String BuscarFuncionario() throws Exception {
        FuncionarioDAO funcionarios = new FuncionarioDAOImpl();
        funcionario = funcionarios.findByCPF(cpf);

        return "EditarCadastroFuncionario";

    }



}
