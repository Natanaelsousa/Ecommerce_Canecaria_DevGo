package ecommerce.Model.MetodosAcessores;


public class Carrinho {
    
    private Integer cod_carrinho; 
    private Integer cod_pedido;
    private Integer cod_cliente;
    private Integer cod_produto;
    private Integer qtde_produto;
    private double subtotal;

    /**
     * @return the cod_carrinho
     */
    public Integer getCod_carrinho() {
        return cod_carrinho;
    }

    /**
     * @param cod_carrinho the cod_carrinho to set
     */
    public void setCod_carrinho(Integer cod_carrinho) {
        this.cod_carrinho = cod_carrinho;
    }

    /**
     * @return the cod_pedido
     */
    public Integer getCod_pedido() {
        return cod_pedido;
    }

    /**
     * @param cod_pedido the cod_pedido to set
     */
    public void setCod_pedido(Integer cod_pedido) {
        this.cod_pedido = cod_pedido;
    }

    /**
     * @return the cod_cliente
     */
    public Integer getCod_cliente() {
        return cod_cliente;
    }

    /**
     * @param cod_cliente the cod_cliente to set
     */
    public void setCod_cliente(Integer cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    /**
     * @return the cod_produto
     */
    public Integer getCod_produto() {
        return cod_produto;
    }

    /**
     * @param cod_produto the cod_produto to set
     */
    public void setCod_produto(Integer cod_produto) {
        this.cod_produto = cod_produto;
    }

    /**
     * @return the qtde_produto
     */
    public Integer getQtde_produto() {
        return qtde_produto;
    }

    /**
     * @param qtde_produto the qtde_produto to set
     */
    public void setQtde_produto(Integer qtde_produto) {
        this.qtde_produto = qtde_produto;
    }

    /**
     * @return the subtotal
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    
    
}
