/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Model.Bean;

import ecommerce.Model.Dao.VendaDAO;
import ecommerce.Model.DaoImplementation.VendaDAOImpl;
import ecommerce.Model.MetodosAcessores.Categoria;
import ecommerce.Model.MetodosAcessores.Produto;
import ecommerce.Model.MetodosAcessores.Venda;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Alessandra
 */
@ManagedBean(name = "relatoriosBean")

public class RelatoriosBean {

    Categoria categor = new Categoria();
    private Venda venda = new Venda();
    private Produto prod = new Produto();
    List<Produto> produtos = new ArrayList<>();
    private Categoria categoria = new Categoria();
    List<Categoria> categorias = new ArrayList<>();
    List<Venda> vendas = new ArrayList<>();
    VendaDAO vendaDao = new VendaDAOImpl();

    

   
    public RelatoriosBean() {
    }

    /*Listar Produtos mais vendidos*/
    public List<Produto> ListarProduto() throws Exception {

        produtos = vendaDao.ListarProduto();

        return produtos;

    }
    /*Listar Categoria*/

    public List<Categoria> ListarCategoria() throws Exception {

        categorias = vendaDao.ListarCategoria();

        return categorias;

    }

}
