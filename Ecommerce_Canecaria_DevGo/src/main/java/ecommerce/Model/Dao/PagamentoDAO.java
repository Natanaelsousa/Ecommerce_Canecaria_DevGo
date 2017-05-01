package ecommerce.Model.Dao;

import ecommerce.Model.MetodosAcessores.Pagamento;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author sibele.nsantos
 */
public interface PagamentoDAO {
    public Pagamento BuscarFormaPagamento(int cod_pagamento) throws SQLException ;
    public List<Pagamento> ListarPagamento() throws SQLException;
}
