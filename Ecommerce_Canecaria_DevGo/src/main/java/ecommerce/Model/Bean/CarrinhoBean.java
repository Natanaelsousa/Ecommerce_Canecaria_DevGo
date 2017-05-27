/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Model.Bean;



import ecommerce.Model.Dao.ProdutoDAO;
import ecommerce.Model.DaoImplementation.ProdutoDAOImpl;
import ecommerce.Model.MetodosAcessores.Produto;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
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
  
  private List<Integer> idProdutos = new ArrayList<>();
  private List<Produto> produtos = new ArrayList<>();
   ProdutoDAO produtosDao = new ProdutoDAOImpl();

  public CarrinhoBean() throws SQLException {
      
      apresentaProdutos();
  }
  
  public String adicionar(int produto) {
     this.idProdutos.add(produto);
     
  
    return "Produtos";
  }

    public List<Integer> getProdutos() {
        return idProdutos;
    }
    public List<Produto> apresentaProdutos() throws SQLException{
      for (int idProduto : idProdutos) {
          produtos.add(produtosDao.BuscarProdutoPorID(idProduto));
      }
      return produtos;
    }

    public void setProdutos(List<Integer> Produtos) {
        this.idProdutos = Produtos;
    }
  
  public int getQuantidade() {
    return idProdutos.size();
  }
  
 
  
}
