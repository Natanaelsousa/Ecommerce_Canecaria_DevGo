/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Model.Bean;

import ecommerce.Model.Dao.ProdutoDAO;
import ecommerce.Model.DaoImplementation.ProdutoDAOImpl;
import ecommerce.Model.MetodosAcessores.Produto;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Erik
 */
@ManagedBean
@ViewScoped
public class DetalharProdutoBean {

    private int id;
    private Produto produto = new Produto();

    public DetalharProdutoBean() {
    }

    @PostConstruct
    public void initialize() {
        try {
            detalharProduto();
        } catch (Exception ex) {
           System.err.println("Erro");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void loadData() {
        System.out.println("Id: " + getId());
    }
    
    /*Detalhar o Produto*/
    public void detalharProduto() throws Exception {
        
        ProdutoDAO produtos = new ProdutoDAOImpl();
       
        try {
            setProduto(produtos.BuscarProdutoPorID(getId()));
            
        } catch (SQLException erro) {
            System.err.println("Erro");
        }
    }

    
    public Produto getProduto() {
        return produto;
    }

    
    public void setProduto(Produto produto) {
        this.produto = produto;
    }


}
