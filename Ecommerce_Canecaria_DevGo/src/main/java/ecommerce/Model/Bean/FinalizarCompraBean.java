package ecommerce.Model.Bean;

import ecommerce.Model.Dao.FinalizarCompraDAO;
import ecommerce.Model.DaoImplementation.FinalizarCompraDAOImpl;
import ecommerce.Model.MetodosAcessores.FinalizarCompra;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


/**
 *
 * @author Erik
 */
@ManagedBean
@ViewScoped
public class FinalizarCompraBean {

    FinalizarCompra compra = new FinalizarCompra();
    
    FinalizarCompraDAO finalizar = new FinalizarCompraDAOImpl();
    
    private double total;
        
        

    /**
     * Creates a new instance of FinalizarCompra
     */
    public FinalizarCompraBean() {

    }
    
     public FinalizarCompra getFinalizarCompra() {
        return compra;
    }

    public void setFinalizarCompra(FinalizarCompra compra) {
        this.compra = compra;
    }
      
    /* Finalizar a compra do usuario */
    public void CadastrarCompra() throws Exception {
        
        StatusPedido();
        
                
        compra.setCodCliente(1);
        
          try {
              
             
            finalizar.CadastrarPedido(compra);
              
        } catch (SQLException erro) {
                  
        }
        compra = new FinalizarCompra();
 
    }
    
    
    public void estado(){
        
        System.out.println("A444 "+compra.getCodPagamento());
        System.out.println("A33 "+compra.getCep());
        
    }
    
    public void StatusPedido(){
        
        int status;
        
        if(compra.getCodPagamento() == 1){
            
          compra.setCodStatus(2);
            
        }else{
            
           compra.setCodStatus(3);
            
        } 
        
    }


   

}
