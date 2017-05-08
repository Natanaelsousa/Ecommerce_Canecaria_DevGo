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

    private boolean renderedPagamento;
    private FinalizarCompra compra = new FinalizarCompra();
        
        

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

    public boolean isRenderedPagamento() {
        return renderedPagamento;
    }

    public void setRenderedPagamento(boolean renderedPagamento) {
        this.renderedPagamento = renderedPagamento;
    }

    public void renderizar() {

        renderedPagamento = true;

    }
    
     /* Finalizar a compra do usario */
    public void CadastrarCompra() throws Exception {
        
                
         StatusPedido();
         
        compra.setCodCliente(1);
        
                
        FinalizarCompraDAO finalizar = new FinalizarCompraDAOImpl();
        
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
