package ecommerce.Model.Dao;

import ecommerce.Model.MetodosAcessores.Pedido;
import java.sql.SQLException;

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

    public void CadastrarPedido(Pedido pedido) throws SQLException;

    public void EditarPedido(Pedido pedido) throws SQLException;
}
