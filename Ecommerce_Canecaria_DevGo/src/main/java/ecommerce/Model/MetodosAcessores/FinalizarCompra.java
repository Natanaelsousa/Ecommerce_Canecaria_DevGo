package ecommerce.Model.MetodosAcessores;

import java.sql.Timestamp;

/**
 *
 * @author Erik
 */
public class FinalizarCompra {
    
    
    private Integer codPedido;
    private Integer codPagamento; //Atributo estrangeiro
    private Integer codCliente; //Atributo estrangeiro
    private Integer codStatus; //Atributo estrangeiro   
    private String cep;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String codFinalizacaoCompra;
    private double valorTotalCompra;
    private Timestamp dataPedido;

    
    public FinalizarCompra(){
        
    }
    
    
    
      public FinalizarCompra(
              
              Integer codPagamento,
              Integer codCliente,Integer codStatus, String cep, 
              String rua, String numero, String bairro, 
              String cidade,String estado, 
              String codFinalizacaoCompra, float valorTotalCompra){
          
              this.codPagamento =codPagamento;
              this.codCliente = codCliente;
              this.codStatus = codStatus;
              this.cep = cep;
              this.rua = rua;
              this.numero = numero;
              this.bairro = bairro;
              this.cidade = cidade;
              this.estado = estado;
              this.codFinalizacaoCompra = codFinalizacaoCompra;
              this.valorTotalCompra = valorTotalCompra;
    }
    
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
     * @return the codPagamento
     */
    public Integer getCodPagamento() {
        return codPagamento;
    }

    /**
     * @param codPagamento the codPagamento to set
     */
    public void setCodPagamento(Integer codPagamento) {
        this.codPagamento = codPagamento;
    }

    /**
     * @return the codCliente
     */
    public Integer getCodCliente() {
        return codCliente;
    }

    /**
     * @param codCliente the codCliente to set
     */
    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    /**
     * @return the codStatus
     */
    public Integer getCodStatus() {
        return codStatus;
    }

    /**
     * @param codStatus the codStatus to set
     */
    public void setCodStatus(Integer codStatus) {
        this.codStatus = codStatus;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the rua
     */
    public String getRua() {
        return rua;
    }

    /**
     * @param rua the rua to set
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the codFinalizacaoCompra
     */
    public String getCodFinalizacaoCompra() {
        return codFinalizacaoCompra;
    }

    /**
     * @param codFinalizacaoCompra the codFinalizacaoCompra to set
     */
    public void setCodFinalizacaoCompra(String codFinalizacaoCompra) {
        this.codFinalizacaoCompra = codFinalizacaoCompra;
    }

    /**
     * @return the valorTotalCompra
     */
    public double getValorTotalCompra() {
        return valorTotalCompra;
    }

    /**
     * @param valorTotalCompra the valorTotalCompra to set
     */
    public void setValorTotalCompra(double valorTotalCompra) {
        this.valorTotalCompra = valorTotalCompra;
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

    
}
