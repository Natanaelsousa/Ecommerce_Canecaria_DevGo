/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Model.Bean;

import ecommerce.Model.Dao.PagamentoDAO;
import ecommerce.Model.DaoImplementation.PagamentoDAOImpl;
import ecommerce.Model.MetodosAcessores.Pagamento;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Erik
 */
@ManagedBean
@SessionScoped
public class FinalizarCompraBean {

    private boolean renderedPagamento = true;
    private int tipoPagamento;

    /**
     * Creates a new instance of FinalizarCompra
     */
    public FinalizarCompraBean() {
    }

    private Pagamento pagamento;

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public boolean isRenderedPagamento() {
        return renderedPagamento;
    }

    public void setRenderedPagamento(boolean renderedPagamento) {
        this.renderedPagamento = renderedPagamento;
    }

    public int getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(int tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public void renderizar() {

   
           renderedPagamento = true;
          

    }

    /* Lista as categorias cadastradas no banco */
 /* Lista as categorias cadastradas no banco */
    public List<Pagamento> ListarTipoPagamento() throws Exception {
        PagamentoDAO pagamentoDao = new PagamentoDAOImpl();

        List<Pagamento> pagamentos = pagamentoDao.ListarPagamento();

        return pagamentos;

    }

 

    

}
