package ecommerce.Model.Bean;

import ecommerce.Model.Dao.PagamentoDAO;
import ecommerce.Model.DaoImplementation.PagamentoDAOImpl;
import ecommerce.Model.MetodosAcessores.Pagamento;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;

/*  @author Erik */
@ManagedBean(name = "PagamentoBean")
public class PagamentoBean {

    private Pagamento pagamento = new Pagamento();

    public Pagamento getCategoria() {
        return pagamento;
    }

    public void setCategoria(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public PagamentoBean() {
        
    }

    
     /* Lista os tipos de pagamento */
    public List<Pagamento> ListarTipoPagamento() throws Exception {
        PagamentoDAO pagamentoDao = new PagamentoDAOImpl();

        List<Pagamento> pagamentos = pagamentoDao.ListarPagamento();

        return pagamentos;

    }
 
     // Responsavel por buscar uma forma de pagamento pelo ID
    public String buscarPagamentoPorId(int cod_pagamento) {
        PagamentoDAO pagamentoDAO = new PagamentoDAOImpl();
        Pagamento pagamentoEncontrado = null;
        try {
            pagamentoEncontrado = pagamentoDAO.BuscarFormaPagamento(cod_pagamento);
        } catch (SQLException erro) {
            System.err.println("Não foi possivel localizar as vendas");
        }
        
        String nomePagamento = pagamentoEncontrado.getForma_pagamento();
        return nomePagamento;
    }
}
