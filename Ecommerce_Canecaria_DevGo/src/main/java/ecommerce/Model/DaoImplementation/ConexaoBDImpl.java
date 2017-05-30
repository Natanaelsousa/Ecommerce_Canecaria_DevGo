package ecommerce.Model.DaoImplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/* @author sibele */
public class ConexaoBDImpl {

    private static final String URL = "jdbc:mysql://localhost:3306/ECOMMERCE"; //url de conexao
    private static final String DRIVER = "com.mysql.jdbc.Driver"; //driver mysql
    private static final String USUARIO = "root"; //nome do usuário do banco de dados
    private static final String SENHA = "beli1771"; //senha do usuário do banco de dados

    public static Connection getConnection() {

        Connection conn = null;

        try {
            Class.forName(DRIVER);
            System.out.println("Conectou");
            return DriverManager.getConnection(URL, USUARIO, SENHA);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
