package ecommerce.Model.DaoImplementation;

import ecommerce.Model.MetodosAcessores.Cliente;
import ecommerce.Model.Dao.ClienteDAO;
import java.sql.SQLException;

/* @author sibele */
public class ClienteDAOImpl  extends GenericaDAOImpl  implements ClienteDAO{

    //Insere os dados do cliente no banco
    public void CadastrarCliente(Cliente cliente) throws SQLException {
        String query = "INSERT INTO CLIENTE(NOME ,CPF,DATA_NASCIMENTO, SEXO,CEP,RUA,"
                + "NUMERO,BAIRRO,CIDADE,ESTADO,TELEFONE_RESIDENCIAL,CELULAR,EMAIL,SENHA) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        insert(query, cliente.getNome(), cliente.getCpf(), cliente.getData_nascimento(), cliente.getSexo(),
                cliente.getCep(), cliente.getRua(), cliente.getNumero(), cliente.getBairro(),
                cliente.getCidade(), cliente.getEstado(), cliente.getTelefone_residencial(),
                cliente.getCelular(), cliente.getEmail(), cliente.getSenha());
    }

    //Editar os dados do cliente no banco
    public void EditarCadastroCliente(Cliente cliente) throws SQLException {
        String query = "UPDATE cliente "
                + "SET nome = ?, data_nascimento = ?,sexo = ?, cep = ?,rua = ?,numero = ?,bairro = ?,cidade = ?, estado = ?, "
                + "telefone_residencial = ?,celular = ?,email = ?, senha = ? "
                + "WHERE cpf = ?";
        update(query, cliente.getNome(), cliente.getCpf(), cliente.getData_nascimento(), cliente.getSexo(), cliente.getCep(), cliente.getRua(), cliente.getNumero(), cliente.getBairro(), cliente.getCidade(), cliente.getEstado(), cliente.getTelefone_residencial(), cliente.getCelular(), cliente.getEmail(), cliente.getSenha());
    }

    //Pela regra de negocio, o cliente tem o direito de excluir seu cadastro, se informar seu CPF e Senha de acesso corretamente
    public void ExclusaoDeCadastroCliente(Cliente cliente, String cpf_cliente, String senha) throws SQLException {
        String query = "DELETE * FROM CLIENTE WHERE COD_CLIENTE = " + cpf_cliente + " and SENHA = " + senha;
        delete(query, cliente.getNome(), cliente.getCpf(), cliente.getData_nascimento(), cliente.getSexo(), cliente.getCep(), cliente.getRua(), cliente.getNumero(), cliente.getBairro(), cliente.getCidade(), cliente.getEstado(), cliente.getTelefone_residencial(), cliente.getCelular(), cliente.getEmail(), cliente.getSenha());
    }
}
