
package ecommerce.Model.Main;

import ecommerce.Model.Bean.CarrinhoBean;
import ecommerce.Model.DaoImplementation.ConexaoBDImpl;
import java.sql.SQLException;

/* @author Sibele */
public class Main {
    public static void main(String[] args) throws SQLException {
        CarrinhoBean carrinho = new CarrinhoBean();
        
   
        
        System.out.println("Main - Verificando conexão.");
        ConexaoBDImpl conexaoDao = new ConexaoBDImpl();
        conexaoDao.getConnection();
    }
    
    
}
