package ecommerce.Model.MetodosAcessores;

/* @author sibele */
public class Contato {

    private Integer cod_solicitacao;
    private Integer cod_tipo_solicitacao;
    private String nome_completo;
    private String email_contato;
    private String descricao_contato;
    private Integer status_solicitacao;

    public Integer getStatus_solicitacao() {
        return status_solicitacao;
    }

    public void setStatus_solicitacao(Integer status_solicitacao) {
        this.status_solicitacao = status_solicitacao;
    }

    public Integer getCod_solicitacao() {
        return cod_solicitacao;
    }

    public void setCod_solicitacao(Integer cod_solicitacao) {
        this.cod_solicitacao = cod_solicitacao;
    }

    public Integer getCod_tipo_solicitacao() {
        return cod_tipo_solicitacao;
    }

    public void setCod_tipo_solicitacao(Integer cod_tipo_solicitacao) {
        this.cod_tipo_solicitacao = cod_tipo_solicitacao;
    }

    public String getNome_completo() {
        return nome_completo;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public String getEmail_contato() {
        return email_contato;
    }

    public void setEmail_contato(String email_contato) {
        this.email_contato = email_contato;
    }

    public String getDescricao_contato() {
        return descricao_contato;
    }

    public void setDescricao_contato(String descricao_contato) {
        this.descricao_contato = descricao_contato;
    }

}
