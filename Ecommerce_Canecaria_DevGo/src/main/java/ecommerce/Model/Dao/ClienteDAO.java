package ecommerce.Model.Dao;

import ecommerce.Model.MetodosAcessores.Cliente;
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
public interface ClienteDAO {

    // Responsavel por buscar um cliente pelo ID
    public Cliente buscaClientesPorId(int cod_cliente) throws SQLException;

    public void cadastrarCliente(Cliente cliente) throws SQLException;

    public void editarCadastroCliente(Cliente cliente) throws SQLException;

    public void exclusaoDeCadastroCliente(Cliente cliente, String cpf_cliente, String senha) throws SQLException;
}
