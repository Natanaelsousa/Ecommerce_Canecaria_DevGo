package ecommerce.Model.DaoImplementation;

import ecommerce.Model.MetodosAcessores.Funcionario;
import ecommerce.Model.Dao.FuncionarioDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/* @author sibele */
public class FuncionarioDAOImpl extends GenericaDAOImpl implements FuncionarioDAO {

    //Insere os dados do funcionario no banco
    public void CadastrarFuncionario(Funcionario funcionario) throws SQLException {
        String query = "INSERT INTO funcionario(nome,senha,cpf,login,depto) "
                + "VALUES(?,?,?,?,?)";
        insert(query, funcionario.getNome_funcionario(), funcionario.getSenha_funcionario(),funcionario.getCpf_funcionario(), funcionario.getLogin_funcionario(),funcionario.getDepartamento_funcionario());

    }

     //Editar os dados do funcionario no banco
    public void EditarCadastroFuncionario(Funcionario funcionario) throws SQLException {

        String query = "UPDATE funcionario "
                + "SET nome = ?,senha = ?, cpf = ?,login = ?,depto = ? "
                + "WHERE cpf = ?";

        update(query, funcionario.getCpf_funcionario(),funcionario.getNome_funcionario(), funcionario.getSenha_funcionario(),funcionario.getCpf_funcionario(), funcionario.getLogin_funcionario(),funcionario.getDepartamento_funcionario());

    }

    

    public Funcionario findByCPF(String cpf) throws SQLException {
        String select = "SELECT * FROM FUNCIONARIO WHERE cpf ='"+cpf+"'";
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
            funcionario.setCod_funcionario(rs.getInt("cod_funcionario"));
            
        
        }

        rs.close();
        stmt.close();
        return funcionario;
    }

   
 
}
