/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Model.Bean;

import ecommerce.Model.Dao.VendaDAO;
import ecommerce.Model.DaoImplementation.VendaDAOImpl;
import ecommerce.Model.MetodosAcessores.Categoria;
import ecommerce.Model.MetodosAcessores.Produto;
import ecommerce.Model.MetodosAcessores.Venda;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Erik
 */
@ManagedBean
@SessionScoped
public class VendaBean {

    private Venda venda = new Venda();
    private Produto prod = new Produto();
    List<Produto> produtos = new ArrayList<>();
    private Categoria categoria = new Categoria();
    List<Categoria> categorias = new ArrayList<>();
    List<Venda> vendas = new ArrayList<>();
    VendaDAO vendaDao = new VendaDAOImpl();

    private Date dataInicial;

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }
    private Date dataFinal;

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public VendaBean() {

    }

    public String ListarVendas() throws Exception {
        String retorno = null;
        try {
            vendas = vendaDao.ListarVendas(dataInicial, dataFinal);
        } catch (SQLException erro) {
            System.err.println("Não foi possivel exibir o relatorio");
        }

        if( dataInicial == null || dataFinal == null || dataInicial.after(dataFinal) || vendas == null) {
            
              Logger.getLogger(FuncionarioBean.class.getName()).log(Level.SEVERE, null, retorno);
                FacesContext.getCurrentInstance().addMessage(
                        null, new FacesMessage(" Data invalida ou não preenchida !"));
                FacesContext.getCurrentInstance()
                        .getExternalContext()
                        .getFlash().setKeepMessages(true);

                FacesContext.getCurrentInstance()
                        .getExternalContext()
                        .getFlash().setKeepMessages(true);
            
            retorno = "RelatorioData";
             
        } else {
            retorno = "ListarVenda";
             
        }
            return retorno;
            
             
        }
        /* Lista as vendas realizadas no banco */
    public List<Venda> ExibirListarVendas() throws Exception {

        vendas = vendaDao.ListarVendas(dataInicial, dataFinal);

        return vendas;

    }

}
