/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Model.Bean;



import ecommerce.Model.MetodosAcessores.Produto;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
/**
 *
 * @author natanael.ssousa
 */

@Named
@SessionScoped
public class CarrinhoBean implements Serializable {
  
  List<Produto> Produtos = new ArrayList<>();

  public CarrinhoBean() {
  }
  
  public String adicionar(Produto produto) {
    this.Produtos.add(produto);
    Flash flash = FacesContext.getCurrentInstance()
	    .getExternalContext().getFlash();
    flash.put("mensagem", "Produto " + produto.getNome_produto()
	    + " adicionado com sucesso.");
    return "Produtos";
  }

    public List<Produto> getProdutos() {
        return Produtos;
    }

    public void setProdutos(List<Produto> Produtos) {
        this.Produtos = Produtos;
    }
  
  public int getQuantidade() {
    return Produtos.size();
  }
  
 
  
}
