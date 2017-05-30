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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


/**
 *
 * @author Erik
 */
@ManagedBean
@ViewScoped
public class VendaBean {

  private Venda venda = new Venda();
  private Produto prod = new Produto();
  List<Produto> produtos = new ArrayList<>();
   private Categoria categoria = new Categoria();
  List<Categoria> categorias = new ArrayList<>();
  List<Venda> vendas =  new ArrayList<>();
  VendaDAO vendaDao = new VendaDAOImpl();
  
   private Timestamp dataInicial;
    private Timestamp dataFinal;

    public Timestamp getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Timestamp dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Timestamp getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Timestamp dataFinal) {
        this.dataFinal = dataFinal;
    }
        
    public VendaBean() {

    }
    
      /* Lista as categorias cadastradas no banco */
    public List<Venda> ListarVendas( Timestamp dataInicial , Timestamp dataFinal ) throws Exception {
      

        vendas = vendaDao.ListarVendas(dataInicial ,  dataFinal);
        
        return vendas;

    }

    
    
   

}
