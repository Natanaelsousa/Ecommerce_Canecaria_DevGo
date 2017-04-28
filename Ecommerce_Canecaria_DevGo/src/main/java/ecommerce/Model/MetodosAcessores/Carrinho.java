package ecommerce.Model.MetodosAcessores;


/*  @author sibele */
public class Carrinho {
    private Integer cod_carrinho; 
    private Integer cod_produto;
    private Integer qtde_produto;
    private float subtotal;

    public Integer getCod_carrinho() {
        return cod_carrinho;
    }

    public void setCod_carrinho(Integer cod_carrinho) {
        this.cod_carrinho = cod_carrinho;
    }

    public Integer getCod_produto() {
        return cod_produto;
    }

    public void setCod_produto(Integer cod_produto) {
        this.cod_produto = cod_produto;
    }

    public Integer getQtde_produto() {
        return qtde_produto;
    }

    public void setQtde_produto(Integer qtde_produto) {
        this.qtde_produto = qtde_produto;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }
    
    
    
}
