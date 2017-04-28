package ecommerce.Model.Dao;

import ecommerce.Model.MetodosAcessores.Funcionario;
import java.sql.SQLException;

/**
 *
 * @author sibele.nsantos
 */
public interface FuncionarioDAO {

    public void CadastrarFuncionario(Funcionario funcionario) throws SQLException;

    public void EditarCadastroFuncionario(Funcionario funcionario) throws SQLException;
}
