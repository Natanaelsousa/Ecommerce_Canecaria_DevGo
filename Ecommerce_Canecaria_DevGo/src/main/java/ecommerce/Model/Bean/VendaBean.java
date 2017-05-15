/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Model.Bean;

import ecommerce.Model.Dao.VendaDAO;
import ecommerce.Model.DaoImplementation.VendaDAOImpl;
import ecommerce.Model.MetodosAcessores.Categoria;
import ecommerce.Model.MetodosAcessores.Venda;
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
  List<Venda> vendas =  new ArrayList<>();
  VendaDAO vendaDao = new VendaDAOImpl();
        
    public VendaBean() {

    }
    
      /* Lista as categorias cadastradas no banco */
    public List<Venda> ListarVendas() throws Exception {
      

        vendas = vendaDao.ListarVendas();
        
        return vendas;

    }
    
    
    
   

}
