package ecommerce.Model.Bean;

import ecommerce.Model.Dao.PedidoDAO;
import ecommerce.Model.DaoImplementation.PedidoDAOImpl;
import ecommerce.Model.MetodosAcessores.Pedido;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/* @author sibele */
@ManagedBean(name = "PedidosBean")
@SessionScoped
public class PedidosBean {
    
    private Pedido pedido = new Pedido();
    private int id_status_venda;
    
    public Pedido getPedido() {
        return pedido;
    }
    
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    public int getId_status_venda() {
        return id_status_venda;
    }
    
    public void setId_status_venda(int id_status_venda) {
        this.id_status_venda = id_status_venda;
    }
    
    public PedidosBean() {
    }

    //Busca vendas de um determinado status e direciona para a tela certa
    public String buscarVendasPeloStatus() throws Exception {
        PedidoDAO pedidosDAO = new PedidoDAOImpl();
        List<Pedido> listaDosPedidos = null;
        
        String retorno = null;
        try {
            listaDosPedidos = pedidosDAO.encontrarVendasPeloStatus(id_status_venda);
        } catch (SQLException erro) {
            System.err.println("Não foi possivel vendas com este ID");
        }
        
        if (id_status_venda == 1) {
            //Para vendas canceladas
            retorno = "AcompanhamentoVendasCanceladas";
            
        } else if (id_status_venda == 2) {
            //Para vendas pendentes de pagamento
            retorno = "AcompanhamentoVendasPendentesPagamento";
            
        } else if (id_status_venda == 3) {
            //Para vendas pagas
            retorno = "AcompanhamentoVendasPagas";
            
        } else if (id_status_venda == 4) {
            //Para vendas enviadas para os clientes
            retorno = "AcompanhamentoVendasEnviadas";
        } else {
            retorno = "AreaDeVendas";
        }
        return retorno;
    }
    
    public List<Pedido> listEncontrarVendasPeloStatus() throws Exception {
        PedidoDAO pedidosDAO = new PedidoDAOImpl();
        List<Pedido> listarVendas = null;
        try {
            listarVendas = pedidosDAO.encontrarVendasPeloStatus(id_status_venda);
        } catch (SQLException erro) {
            System.err.println("Não foi possivel localizar as vendas");
        }
        return listarVendas;
    }
    
    public String redirecionandoParaTelaVendas() throws Exception {
        FacesContext.getCurrentInstance().getExternalContext().redirect("AreaDeVendas.xhtml");
        return "OK";
    }

    //Atualiza um pedido para pago
    public void atualizarPedidoParaPago(Pedido pedido) throws SQLException {
        PedidoDAO pedidosDAO = new PedidoDAOImpl();
        try {
            pedidosDAO.atualizarPedidoParaPago(pedido);
        } catch (SQLException erro) {
            System.err.println("Não foi atualizar o satus do pedido");
        }
    }
    
    
    
}
