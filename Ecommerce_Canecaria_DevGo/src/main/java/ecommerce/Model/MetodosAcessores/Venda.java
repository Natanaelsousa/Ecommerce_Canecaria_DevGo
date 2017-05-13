package ecommerce.Model.MetodosAcessores;

import java.sql.Timestamp;

/**
 *
 * @author Erik
 */
public class Venda {
    
    private Integer codPedido;
    private String nome;
    private String cpf;
    private String formaPagamento;
    private double valorTotal;
    private Timestamp dataPedido;
    private String estadoCompra;

    /**
     * @return the codPedido
     */
    public Integer getCodPedido() {
        return codPedido;
    }

    /**
     * @param codPedido the codPedido to set
     */
    public void setCodPedido(Integer codPedido) {
        this.codPedido = codPedido;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the formaPagamento
     */
    public String getFormaPagamento() {
        return formaPagamento;
    }

    /**
     * @param formaPagamento the formaPagamento to set
     */
    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    /**
     * @return the valorTotal
     */
    public double getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * @return the dataPedido
     */
    public Timestamp getDataPedido() {
        return dataPedido;
    }

    /**
     * @param dataPedido the dataPedido to set
     */
    public void setDataPedido(Timestamp dataPedido) {
        this.dataPedido = dataPedido;
    }

    /**
     * @return the estadoCompra
     */
    public String getEstadoCompra() {
        return estadoCompra;
    }

    /**
     * @param estadoCompra the estadoCompra to set
     */
    public void setEstadoCompra(String estadoCompra) {
        this.estadoCompra = estadoCompra;
    }
    
    
       
    
    
    
}
