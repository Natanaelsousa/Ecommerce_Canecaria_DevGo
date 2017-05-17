package ecommerce.Model.MetodosAcessores;

import java.sql.Timestamp;


/*  @author sibele */
public class Pedido {

    private Integer cod_pedido;
    private Integer cod_cliente;
    private Integer cod_pagamento;
    private Integer valor_a_pagar;
    private Timestamp data_pedido;
    private String cep;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private Integer cod_status;

    public Integer getCod_status() {
        return cod_status;
    }

    public void setCod_status(Integer cod_status) {
        this.cod_status = cod_status;
    }

    public Timestamp getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(Timestamp data_pedido) {
        this.data_pedido = data_pedido;
    }

    public Integer getCod_pedido() {
        return cod_pedido;
    }

    public void setCod_pedido(Integer cod_pedido) {
        this.cod_pedido = cod_pedido;
    }

    public Integer getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(Integer cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public Integer getCod_pagamento() {
        return cod_pagamento;
    }

    public void setCod_pagamento(Integer cod_pagamento) {
        this.cod_pagamento = cod_pagamento;
    }

    public Integer getValor_a_pagar() {
        return valor_a_pagar;
    }

    public void setValor_a_pagar(Integer valor_a_pagar) {
        this.valor_a_pagar = valor_a_pagar;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
