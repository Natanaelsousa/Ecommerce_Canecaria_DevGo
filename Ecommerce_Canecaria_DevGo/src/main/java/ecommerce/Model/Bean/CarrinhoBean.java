/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Model.Bean;



import ecommerce.Model.MetodosAcessores.Produto;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
/**
 *
 * @author natanael.ssousa
 */
@ManagedBean
@SessionScoped
public class CarrinhoBean implements Serializable {
  
  List<Long> idProdutos = new ArrayList<>();

  public CarrinhoBean() {
  }
  
  public String adicionar(long idProdutoP) {
    this.idProdutos.add(idProdutoP);
    
    return "Produtos";
  }

    public List<Long> getProdutos() {
        return idProdutos;
    }

    public void setProdutos(List<Long> idProdutosP) {
        this.idProdutos = idProdutosP;
    }
  
  public int getQuantidade() {
    return idProdutos.size();
  }
  
 
  
}
