
package ecommerce.Model.Main;

import ecommerce.Model.DaoImplementation.ConexaoBDImpl;

/* @author Sibele */
public class Main {
    public static void main(String[] args) {
        System.out.println("Main - Verificando conexão.");
        ConexaoBDImpl conexaoDao = new ConexaoBDImpl();
        conexaoDao.getConnection();
    }
}
