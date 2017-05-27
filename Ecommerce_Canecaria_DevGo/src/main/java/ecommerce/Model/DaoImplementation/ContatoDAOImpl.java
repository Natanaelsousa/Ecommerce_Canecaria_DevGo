/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Model.DaoImplementation;

import ecommerce.Model.Dao.ContatoDAO;
import ecommerce.Model.MetodosAcessores.Contato;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* @author sibele */
public class ContatoDAOImpl extends GenericaDAOImpl implements ContatoDAO {

    //Insere os dados do produto no banco
    public void cadastrarSolicitacaoContato(Contato contato) throws SQLException {

        String query = "INSERT INTO CONTATO (COD_TIPO_SOLICITACAO, NOME_COMPLETO, EMAIL_CONTATO, DESCRICAO_CONTATO,STATUS_SOLICITACAO) VALUES (?,?,?,?,?)";

        // Ao cadastrar uma nova solicitação, o status dele inicia por padrão como 0
        contato.setStatus_solicitacao(0);

        insert(query, contato.getCod_tipo_solicitacao(), contato.getNome_completo(), contato.getEmail_contato(), contato.getDescricao_contato(), contato.getStatus_solicitacao());

    }

   //Lista os chamados por seus tipo de fila diferente
    public List<Contato> listarSolicitacoesContatos() throws SQLException {
        List<Contato> contato = new ArrayList<Contato>();

        String query = "SELECT DISTINCT COD_TIPO_SOLICITACAO FROM CONTATO";

        PreparedStatement stmt
                = getConnection().prepareStatement(query);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Contato contatos = new Contato();

            contatos.setCod_tipo_solicitacao(rs.getInt("COD_TIPO_SOLICITACAO"));

            contato.add(contatos);
        }

        rs.close();
        stmt.close();

        return contato;

    }

    //Verifica quantos chamados tem em cada fila 
    @Override
    public int countSolicitacaoChamadoContato(int cod_tipo_solicitacao) throws SQLException {

        String query = "select count(*) from contato where COD_TIPO_SOLICITACAO = " + cod_tipo_solicitacao + " and STATUS_SOLICITACAO = 0";
        int quantidadeChamadosFila = 0;
        ResultSet rs = getConnection().createStatement().executeQuery(query);

        while (rs.next()) {
            quantidadeChamadosFila = rs.getInt(1);
        }

        rs.close();

        return quantidadeChamadosFila;

    }

    //Seleciona os chamados de um tipo de fila com status 0(em aberto)
    public List<Contato> ListarSolicitacoesDeFila(int cod_fila) throws SQLException {

        List<Contato> contato = new ArrayList<Contato>();

        String query = "SELECT * FROM CONTATO WHERE COD_TIPO_SOLICITACAO = " + cod_fila + " AND STATUS_SOLICITACAO = 0 ";

        PreparedStatement stmt
                = getConnection().prepareStatement(query);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Contato contatos = new Contato();

            contatos.setCod_solicitacao(rs.getInt("COD_SOLICITACAO"));
            contatos.setCod_tipo_solicitacao(rs.getInt("COD_TIPO_SOLICITACAO"));
            contatos.setNome_completo(rs.getString("NOME_COMPLETO"));
            contatos.setEmail_contato(rs.getString("EMAIL_CONTATO"));
            contatos.setDescricao_contato(rs.getString("DESCRICAO_CONTATO"));
            contatos.setStatus_solicitacao(rs.getInt("STATUS_SOLICITACAO"));

            contato.add(contatos);
        }

        rs.close();
        stmt.close();

        return contato;

    }

    //Lista os chamados
    public List<Contato> encontrarFilaPorId(int id_fila) throws SQLException {
        String query = "SELECT * FROM CONTATO WHERE COD_TIPO_SOLICITACAO = " + id_fila + " and STATUS_SOLICITACAO = 0 ";
        List<Contato> contatos = new ArrayList<Contato>();

        PreparedStatement stmt
                = getConnection().prepareStatement(query);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Contato contato = new Contato();
            contato.setCod_solicitacao(rs.getInt("COD_SOLICITACAO"));
            contato.setCod_tipo_solicitacao(rs.getInt("COD_TIPO_SOLICITACAO"));
            contato.setNome_completo(rs.getString("NOME_COMPLETO"));
            contato.setEmail_contato(rs.getString("EMAIL_CONTATO"));
            contato.setDescricao_contato(rs.getString("DESCRICAO_CONTATO"));
            contato.setStatus_solicitacao(rs.getInt("STATUS_SOLICITACAO"));
            contatos.add(contato);
        }

        rs.close();
        stmt.close();
        return contatos;
    }
    
    
     //Encerrar chamado
    @Override
    public void finalizarChamado(Contato contato,int cod_chamado) throws SQLException {

        String query = "UPDATE contato "
                + "SET STATUS_SOLICITACAO = ? "
                + " WHERE COD_SOLICITACAO = ? ";

        contato.setCod_solicitacao(cod_chamado);
        contato.setStatus_solicitacao(1);
        update(query, contato.getCod_solicitacao(),contato.getStatus_solicitacao());

    }
}
