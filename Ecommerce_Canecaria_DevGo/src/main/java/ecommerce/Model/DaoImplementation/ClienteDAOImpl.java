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
    public void cadastrarCliente(Cliente cliente) throws SQLException {
        String query = "INSERT INTO CLIENTE(NOME ,CPF,DATA_NASCIMENTO, SEXO,CEP,RUA,"
                + "NUMERO,BAIRRO,CIDADE,ESTADO,TELEFONE_RESIDENCIAL,CELULAR,EMAIL,SENHA) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        insert(query, cliente.getNome(), cliente.getCpf(), cliente.getData_nascimento(), cliente.getSexo(),
                cliente.getCep(), cliente.getRua(), cliente.getNumero(), cliente.getBairro(),
                cliente.getCidade(), cliente.getEstado(), cliente.getTelefone_residencial(),
                cliente.getCelular(), cliente.getEmail(), cliente.getSenha());
    }

    //Editar os dados do cliente no banco
    public void editarCadastroCliente(Cliente cliente) throws SQLException {
        Cliente cliente2 = cliente;
        String query = "UPDATE CLIENTE "
                + "SET NOME = ?, DATA_NASCIMENTO = ?,SEXO = ?, CEP = ?,RUA = ?,NUMERO = ?,BAIRRO = ?,CIDADE = ?, ESTADO = ?, "
                + "TELEFONE_RESIDENCIAL = ?,CELULAR = ?,EMAIL = ?, SENHA = ?, CPF = ? "
                + "WHERE COD_CLIENTE = ?";
        update(query, cliente.getNome(), cliente.getData_nascimento(), cliente.getSexo(), cliente.getCep(),
                cliente.getRua(), cliente.getNumero(), cliente.getBairro(), cliente.getCidade(), cliente.getEstado(),
                cliente.getTelefone_residencial(), cliente.getCelular(), cliente.getEmail(), cliente.getSenha(),
                cliente.getCpf(), cliente.getCod_cliente());
    }

    //Pela regra de negocio, o cliente tem o direito de excluir seu cadastro, se informar seu CPF e Senha de acesso corretamente
    public void exclusaoDeCadastroCliente(Cliente cliente, String cpf_cliente, String senha) throws SQLException {
        String query = "DELETE * FROM CLIENTE WHERE COD_CLIENTE = " + cpf_cliente + " and SENHA = " + senha;
        delete(query, cliente.getNome(), cliente.getCpf(), cliente.getData_nascimento(), cliente.getSexo(), cliente.getCep(), cliente.getRua(), cliente.getNumero(), cliente.getBairro(), cliente.getCidade(), cliente.getEstado(), cliente.getTelefone_residencial(), cliente.getCelular(), cliente.getEmail(), cliente.getSenha());
    }

    public Cliente EncontraUserCliente(String email, String senha) throws SQLException {
        String select = "SELECT * FROM CLIENTE WHERE EMAIL ='" + email + "'";

        Cliente cliente = null;

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
            cliente.setRua(rs.getString("RUA"));
            cliente.setTelefone_residencial(rs.getString("TELEFONE_RESIDENCIAL"));
            cliente.setCep(rs.getString("CEP"));
            cliente.setEmail(rs.getString("EMAIL"));
            cliente.setBairro(rs.getString("BAIRRO"));
            cliente.setSexo(rs.getString("SEXO"));
            cliente.setCpf(rs.getString("CPF"));
        }

        rs.close();
        stmt.close();
        closeConnetion();
        return cliente;
    }

    public List<Cliente> buscaClientes() throws SQLException {
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
        closeConnetion();
        return clientes;
    }

    // Responsavel por buscar um cliente pelo ID
    public Cliente buscaClientesPorId(int cod_cliente) throws SQLException {
        Cliente cliente = new Cliente();
        String select = "SELECT * FROM CLIENTE WHERE COD_CLIENTE = " + cod_cliente + " ";

        PreparedStatement stmt
                = getConnection().prepareStatement(select);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
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
        }

        rs.close();
        stmt.close();
        closeConnetion();
        
        return cliente;
    }

    public String buscaClientesPorEmail(String email) throws SQLException {
        String emailGravado = "";
        String select = "SELECT * FROM CLIENTE WHERE EMAIL ='" + email + "'";

        PreparedStatement stmt
                = getConnection().prepareStatement(select);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            emailGravado = rs.getString("EMAIL");

        }

        rs.close();
        stmt.close();
        closeConnetion();

        return emailGravado;
    }
}
