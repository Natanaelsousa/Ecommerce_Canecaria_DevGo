package ecommerce.Model.MetodosAcessores;

import java.sql.Timestamp;
import javax.servlet.http.Part;

/* @author sibele */
public class Produto {

    private Integer cod_produto;
    private Integer cod_categoria; //Atributo estrangeiro
    private String nome_produto;
    private Integer qtde_produto;
    private Integer qtde_para_acrescentar;
    private float valor_produto;
    private String descricao_produto;
    private Timestamp data_inclusao;
    private Part imagem;

    public Part getImagem() {
        return imagem;
    }

    public void setImagem(Part imagem) {
        this.imagem = imagem;
    }

    public Timestamp getData_inclusao() {
        return data_inclusao;
    }

    public void setData_inclusao(Timestamp data_inclusao) {
        this.data_inclusao = data_inclusao;
    }

    public Integer getCod_categoria() {
        return cod_categoria;
    }

    public void setCod_categoria(Integer cod_categoria) {
        this.cod_categoria = cod_categoria;
    }

    public Integer getCod_produto() {
        return cod_produto;
    }

    public void setCod_produto(Integer cod_produto) {
        this.cod_produto = cod_produto;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public Integer getQtde_produto() {
        return qtde_produto;
    }

    public void setQtde_produto(Integer qtde_produto) {
        this.qtde_produto = qtde_produto;
    }

    public Integer getQtde_para_acrescentar() {
        return qtde_para_acrescentar;
    }

    public void setQtde_para_acrescentar(Integer qtde_para_acrescentar) {
        this.qtde_para_acrescentar = qtde_para_acrescentar;
    }

    
    
    public float getValor_produto() {
        return valor_produto;
    }

    public void setValor_produto(float valor_produto) {
        this.valor_produto = valor_produto;
    }

    public String getDescricao_produto() {
        return descricao_produto;
    }

    public void setDescricao_produto(String descricao_produto) {
        this.descricao_produto = descricao_produto;
    }

}
