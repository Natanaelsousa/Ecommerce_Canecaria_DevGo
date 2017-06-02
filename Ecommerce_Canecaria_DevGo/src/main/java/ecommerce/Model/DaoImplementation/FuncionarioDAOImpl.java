package ecommerce.Model.DaoImplementation;

import ecommerce.Model.MetodosAcessores.Funcionario;
import ecommerce.Model.Dao.FuncionarioDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author sibele */
public class FuncionarioDAOImpl extends GenericaDAOImpl implements FuncionarioDAO {

    //Insere os dados do funcionario no banco
    public void CadastrarFuncionario(Funcionario funcionario) throws SQLException {
        String query = "INSERT INTO funcionario(nome,senha,cpf,login,depto,status) "
                + "VALUES(?,?,?,?,?,?)";
        insert(query, funcionario.getNome_funcionario(), funcionario.getSenha_funcionario(), funcionario.getCpf_funcionario(), funcionario.getLogin_funcionario(), funcionario.getDepartamento_funcionario(), funcionario.getStatus_funcionario());

    }

    //Editar os dados do funcionario no banco
    public void EditarCadastroFuncionario(Funcionario funcionario) throws SQLException {

        String query = "UPDATE funcionario "
                + "SET nome = ?,senha = ?, cpf = ?,login = ?,depto = ?, status = ? "
                + "WHERE cpf = ?";
        update(query, funcionario.getCpf_funcionario(), funcionario.getNome_funcionario(), funcionario.getSenha_funcionario(), funcionario.getCpf_funcionario(), funcionario.getLogin_funcionario(), funcionario.getDepartamento_funcionario(), funcionario.getStatus_funcionario());

    }

//encontrar funcionario atraves do CPF
    public Funcionario findByCPF(String cpf) throws SQLException {
        String select = "SELECT * FROM FUNCIONARIO WHERE cpf ='" + cpf + "'";
        Funcionario funcionario = new Funcionario();

        PreparedStatement stmt
                = getConnection().prepareStatement(select);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            funcionario.setNome_funcionario(rs.getString("nome"));
            funcionario.setSenha_funcionario(rs.getString("senha"));
            funcionario.setCpf_funcionario(rs.getString("cpf"));
            funcionario.setLogin_funcionario(rs.getString("login"));
            funcionario.setDepartamento_funcionario(rs.getString("depto"));
            funcionario.setStatus_funcionario(rs.getString("status"));
            funcionario.setCod_funcionario(rs.getInt("cod_funcionario"));

        }

        rs.close();
        stmt.close();
        closeConnetion();
        return funcionario;
    }

    public Funcionario EncontraUserFuncionario(String login, String senha) throws SQLException {
        String select = "SELECT * FROM FUNCIONARIO WHERE LOGIN ='" + login + "'";
        Funcionario funcionario1 = null;

        PreparedStatement stmt
                = getConnection().prepareStatement(select);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            funcionario1 = new Funcionario();
            funcionario1.setNome_funcionario(rs.getString("nome"));
            funcionario1.setSenha_funcionario(rs.getString("senha"));
            funcionario1.setCpf_funcionario(rs.getString("cpf"));
            funcionario1.setLogin_funcionario(rs.getString("login"));
            funcionario1.setDepartamento_funcionario(rs.getString("depto"));
            funcionario1.setStatus_funcionario(rs.getString("status"));
            funcionario1.setCod_funcionario(rs.getInt("cod_funcionario"));
        }

        rs.close();
        stmt.close();
        closeConnetion();
        return funcionario1;
    }
    
        public String buscaFuncionarioCPF(String cpf) throws SQLException {
        String cpfGravado = "";
        String select = "SELECT * FROM FUNCIONARIO WHERE CPF ='"+cpf+"'";

        PreparedStatement stmt
                = getConnection().prepareStatement(select);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            cpfGravado = rs.getString("CPF");

        }

        rs.close();
        stmt.close();
        closeConnetion();

        return cpfGravado;
    }

}
