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
        String cpfJaRegistrado = funcionarios.buscaFuncionarioCPF(cpf);
        if (!funcionario.getCpf_funcionario().equalsIgnoreCase(cpfJaRegistrado)) {

            try {
                funcionarios.CadastrarFuncionario(funcionario);
                FacesContext.getCurrentInstance().addMessage(
                        null, new FacesMessage("Cadastro realizado com sucesso!"));
                FacesContext.getCurrentInstance()
                        .getExternalContext()
                        .getFlash().setKeepMessages(true);

                FacesContext.getCurrentInstance()
                        .getExternalContext()
                        .getFlash().setKeepMessages(true);

            } catch (SQLException ex) {
                Logger.getLogger(FuncionarioBean.class.getName()).log(Level.SEVERE, null, ex);
                FacesContext.getCurrentInstance().addMessage(
                        null, new FacesMessage("Falha ao cadastrar!"));
                FacesContext.getCurrentInstance()
                        .getExternalContext()
                        .getFlash().setKeepMessages(true);

                FacesContext.getCurrentInstance()
                        .getExternalContext()
                        .getFlash().setKeepMessages(true);
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Login já existe!"));
            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getFlash().setKeepMessages(true);

            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getFlash().setKeepMessages(true);
        }

        funcionario = new Funcionario();

    }

    public void EditarFuncionario() throws Exception {
        getCriptoUserFunc().setSenha(funcionario.getSenha_funcionario());
        funcionario.setSenha_funcionario(getCriptoUserFunc().getHashSenha());
        FuncionarioDAO funcionarios = new FuncionarioDAOImpl();

      
            
             try {
             funcionarios.EditarCadastroFuncionario(funcionario);
                FacesContext.getCurrentInstance().addMessage(
                        null, new FacesMessage("Edição realizado com sucesso!"));
                FacesContext.getCurrentInstance()
                        .getExternalContext()
                        .getFlash().setKeepMessages(true);

                FacesContext.getCurrentInstance()
                        .getExternalContext()
                        .getFlash().setKeepMessages(true);

            } catch (SQLException ex) {
                Logger.getLogger(FuncionarioBean.class.getName()).log(Level.SEVERE, null, ex);
                FacesContext.getCurrentInstance().addMessage(
                        null, new FacesMessage("Falha ao editar!"));
                FacesContext.getCurrentInstance()
                        .getExternalContext()
                        .getFlash().setKeepMessages(true);

                FacesContext.getCurrentInstance()
                        .getExternalContext()
                        .getFlash().setKeepMessages(true);
            }
         

        funcionario = new Funcionario();

    }

    public String BuscarFuncionario() throws Exception {
        FuncionarioDAO funcionarios = new FuncionarioDAOImpl();
          String retorno = null;
          try{
        funcionario = funcionarios.findByCPF(cpf);
          }catch (SQLException erro) {
            System.err.println("Não foi possivel encontrar o CPF");
        }

        if (funcionario.getCpf_funcionario() != null) {

            retorno = "EditarCadastroFuncionario";
        } else {
            retorno = "BuscarCadastroFuncionario";
        }
        return retorno;
    }

    public void validaLogin() throws SQLException, IOException {
        FuncionarioDAOImpl daoValidarFunc = new FuncionarioDAOImpl();
        RequestContext context = RequestContext.getCurrentInstance();

        String mensagem = "Erro ao se tentar se logar!";

        if (getCriptoUserFunc().obterUsuarioFunc(funcionario.getLogin_funcionario(), funcionario.getSenha_funcionario()) != null && funcionario.getStatus_funcionario().equals("ativo")) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("AmbienteFuncionario.xhtml");
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Usuário ou senha inválidos", "Usuário ou senha inválidos");
            FacesContext.getCurrentInstance().addMessage(null, message);
            context.addCallbackParam("loggedIn", mensagem);
        }
        funcionario = new Funcionario();
    }

}
