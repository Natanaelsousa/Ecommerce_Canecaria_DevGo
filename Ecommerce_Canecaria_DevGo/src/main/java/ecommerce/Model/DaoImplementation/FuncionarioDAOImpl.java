package ecommerce.Model.DaoImplementation;

import ecommerce.Model.MetodosAcessores.Funcionario;
import ecommerce.Model.Dao.FuncionarioDAO;
import java.sql.SQLException;

/* @author sibele */
public class FuncionarioDAOImpl extends GenericaDAOImpl implements FuncionarioDAO {

    //Insere os dados do funcionario no banco
    public void CadastrarFuncionario(Funcionario funcionario) throws SQLException {
        String query = "INSERT INTO funcionario(nome,senha,cpf,email,depto) "
                + "VALUES(?,?,?,?,?)";
        insert(query, funcionario.getNome_funcionario(), funcionario.getSenha_funcionario(),funcionario.getCpf_funcionario(), funcionario.getLogin_funcionario(),funcionario.getDepartamento_funcionario());

    }

     //Editar os dados do funcionario no banco
    public void EditarCadastroFuncionario(Funcionario funcionario) throws SQLException {

        String query = "UPDATE funcionario "
                + "SET nome_funcionario = ?,cpf_funcionario = ?,login_funcionario = ?,senha_funcionario = ?"
                + "WHERE cpf_funcionario = ?";

        update(query, funcionario.getNome_funcionario(), funcionario.getCpf_funcionario(), funcionario.getLogin_funcionario(), funcionario.getSenha_funcionario());

    }
}
