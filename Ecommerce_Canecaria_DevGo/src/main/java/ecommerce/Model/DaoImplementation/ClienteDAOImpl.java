package ecommerce.Model.DaoImplementation;

import ecommerce.Model.MetodosAcessores.Cliente;
import ecommerce.Model.Dao.ClienteDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author sibele */
public class ClienteDAOImpl extends GenericaDAOImpl implements ClienteDAO {

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
        String query = "UPDATE CLIENTE "
                + "SET NOME = ?, DATA_NASCIMENTO = ?,SEXO = ?, CEP = ?,RUA = ?,NUMERO = ?,BAIRRO = ?,CIDADE = ?, ESTADO = ?, "
                + "TELEFONE_RESIDENCIAL = ?,CELULAR = ?,EMAIL = ?, SENHA = ? "
                + "WHERE CPF = ?";
        update(query, cliente.getNome(), cliente.getCpf(), cliente.getData_nascimento(), cliente.getSexo(), cliente.getCep(), cliente.getRua(), cliente.getNumero(), cliente.getBairro(), cliente.getCidade(), cliente.getEstado(), cliente.getTelefone_residencial(), cliente.getCelular(), cliente.getEmail(), cliente.getSenha());
    }

    //Pela regra de negocio, o cliente tem o direito de excluir seu cadastro, se informar seu CPF e Senha de acesso corretamente
    public void ExclusaoDeCadastroCliente(Cliente cliente, String cpf_cliente, String senha) throws SQLException {
        String query = "DELETE * FROM CLIENTE WHERE COD_CLIENTE = " + cpf_cliente + " and SENHA = " + senha;
        delete(query, cliente.getNome(), cliente.getCpf(), cliente.getData_nascimento(), cliente.getSexo(), cliente.getCep(), cliente.getRua(), cliente.getNumero(), cliente.getBairro(), cliente.getCidade(), cliente.getEstado(), cliente.getTelefone_residencial(), cliente.getCelular(), cliente.getEmail(), cliente.getSenha());
    }

    public Cliente EncontraUserCliente(Cliente cliente) throws SQLException {
        String select = "SELECT * FROM CLIENTE WHERE EMAIL ='" + cliente.getEmail() +
                "' and senha = '" + cliente.getSenha() + "'";
        Cliente cliente1 = null;
        
        PreparedStatement stmt
                = getConnection().prepareStatement(select);
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            cliente1 = new Cliente();
            cliente1.setCidade(rs.getString("CIDADE"));
            cliente1.setCod_cliente(rs.getInt("COD_CLIENTE"));
            cliente1.setData_nascimento(rs.getDate("DATA_NASCIMENTO"));
            cliente1.setCelular(rs.getString("CELULAR"));
            cliente1.setEstado(rs.getString("ESTADO"));
            cliente1.setNumero(rs.getString("NUMERO"));
            cliente1.setSenha(rs.getString("SENHA"));
            cliente1.setNome(rs.getString("NOME"));
            cliente1.setRua(rs.getNString("RUA"));
            cliente1.setTelefone_residencial(rs.getString("TELEFONE_RESIDENCIAL"));
            cliente1.setCep(rs.getString("CEP"));
            cliente1.setEmail(rs.getNString("EMAIL"));
            cliente1.setBairro(rs.getNString("BAIRRO"));
            cliente1.setSexo(rs.getNString("SEXO"));
            cliente1.setCpf(rs.getNString("CPF"));
        }
        
        rs.close();
        stmt.close();
        return cliente1;
    }
     public List<Cliente> BuscaClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<Cliente>();
        Cliente cliente = null;
        String select = "SELECT * FROM CLIENTE";

        PreparedStatement stmt
                = getConnection().prepareStatement(select);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            cliente = new Cliente();
            cliente.setCidade(rs.getString("CIDADE"));
            cliente.setCod_cliente(rs.getInt("COD_CLIENTE"));
            cliente.setData_nascimento(rs.getDate("DATA_NASCIMENTO"));
            cliente.setCelular(rs.getString("CELULAR"));
            cliente.setEstado(rs.getString("ESTADO"));
            cliente.setNumero(rs.getString("NUMERO"));
            cliente.setSenha(rs.getString("SENHA"));
            cliente.setNome(rs.getString("NOME"));
            cliente.setRua(rs.getNString("RUA"));
            cliente.setTelefone_residencial(rs.getString("TELEFONE_RESIDENCIAL"));
            cliente.setCep(rs.getString("CEP"));
            cliente.setEmail(rs.getNString("EMAIL"));
            cliente.setBairro(rs.getNString("BAIRRO"));
            cliente.setSexo(rs.getNString("SEXO"));
            cliente.setCpf(rs.getNString("CPF"));
            clientes.add(cliente);
        }

        rs.close();
        stmt.close();

        return clientes;
    }
}
