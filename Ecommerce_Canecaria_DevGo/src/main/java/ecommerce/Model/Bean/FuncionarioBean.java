
package ecommerce.Model.Bean;

import ecommerce.Model.Dao.FuncionarioDAO;
import ecommerce.Model.DaoImplementation.FuncionarioDAOImpl;
import ecommerce.Model.MetodosAcessores.Funcionario;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/* @author Alessandra */
@ManagedBean(name="FuncionarioBean")
@SessionScoped

public class FuncionarioBean {
    
    private String cpf;

    public String getCpf() {
        return cpf;
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

     public String CadastrarFuncionario() throws Exception {
        FuncionarioDAO funcionarios = new FuncionarioDAOImpl();
        funcionarios.CadastrarFuncionario(funcionario);
        return "Cadastrado";
    }
     
   public String EditarFuncionario() throws Exception {
        FuncionarioDAO funcionarios = new FuncionarioDAOImpl();
        funcionarios.EditarCadastroFuncionario(funcionario);
        return "Alterado";
    }
   
     
     public String BuscarFuncionario() throws Exception {
        FuncionarioDAO funcionarios = new FuncionarioDAOImpl();
        funcionario = funcionarios.findByCPF(cpf);
        
        return "EditarCadastroFuncionario";
        
    }

       public String ExcluirFuncionario() throws Exception {
        FuncionarioDAO funcionarios = new FuncionarioDAOImpl();
        funcionarios.ExclusaoDeCadastroFuncionario(funcionario);
        return "Excluido";
    }
       
           /* Lista os produtos cadastrados no banco */
    public List<Funcionario> ListarProdutosIdENome() throws Exception {
        FuncionarioDAO funcionariosDao = new FuncionarioDAOImpl();

        List<Funcionario> ListaFuncionarios = funcionariosDao.ListarProdutosPorIDeNome();

        return ListaFuncionarios;
    }
     
}
