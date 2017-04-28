
package ecommerce.Model.Bean;

import ecommerce.Model.Dao.FuncionarioDAO;
import ecommerce.Model.DaoImplementation.FuncionarioDAOImpl;
import ecommerce.Model.MetodosAcessores.Funcionario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/* @author Alessandra */
@ManagedBean(name="FuncionarioBean")
@RequestScoped

public class FuncionarioBean {

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

     public String CadastrarFuncionario() throws Exception {
        FuncionarioDAO funcionarios = new FuncionarioDAOImpl();
        funcionarios.CadastrarFuncionario(funcionario);
        return "Cadastrado";
    }

}
