package ecommerce.Model.Dao;

import ecommerce.Model.MetodosAcessores.Pedido;
import java.sql.SQLException;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sibele.nsantos
 */
public interface PedidoDAO {

    // Responsavel por cadastrar a compra do cliente
    public void CadastrarPedido(Pedido pedido) throws SQLException;

    // Responsavel por localizar vendas de acordo com o status
    public List<Pedido> encontrarVendasPeloStatus(int id_status) throws SQLException;

    //Atualiza um pedido para pago
    public void atualizarPedidoParaPago(Pedido pedido) throws SQLException;

    public void EditarPedido(Pedido pedido) throws SQLException;
}
