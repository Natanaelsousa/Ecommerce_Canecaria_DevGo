/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Model.Dao;

import ecommerce.Model.MetodosAcessores.Contato;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author sibele
 */
public interface ContatoDAO {

    public void CadastrarSolicitacaoContato(Contato contato) throws SQLException;
public List<Contato> encontrarFilaPorId(int id_fila) throws SQLException ;
    /* Verifica quantos chamados tem em cada fila */
    public int CountSolicitacaoChamadoContato(int cod_tipo_solicitacao) throws SQLException;


    public List<Contato> ListarSolicitacoesContatos() throws Exception;

    /* Traz as solicitações pendentes de uma determinada fila */
    public List<Contato> ListarSolicitacoesDeFila(int cod_fila) throws SQLException;
}
