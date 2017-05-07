package ecommerce.Model.Bean;

import ecommerce.Model.Dao.FinalizarCompraDAO;
import ecommerce.Model.Dao.PagamentoDAO;
import ecommerce.Model.DaoImplementation.FinalizarCompraDAOImpl;
import ecommerce.Model.DaoImplementation.PagamentoDAOImpl;
import ecommerce.Model.MetodosAcessores.FinalizarCompra;
import ecommerce.Model.MetodosAcessores.Pagamento;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 *
 * @author Erik
 */
@ManagedBean
@RequestScoped
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
        FinalizarCompraDAO finalizar = new FinalizarCompraDAOImpl();
        try {
            System.out.println("A444 "+compra.getCodPagamento());
            System.out.println("A33 "+compra.getCep());
              finalizar.CadastrarPedido(compra);
              
        } catch (SQLException erro) {
            
            System.err.println("zzzzzz  "+ erro);
            
        }
        compra = new FinalizarCompra();
 
    }
    
    
    public void estado(){
        
        System.out.println("A444 "+compra.getCodPagamento());
            System.out.println("A33 "+compra.getCep());
        
    }


   

}
