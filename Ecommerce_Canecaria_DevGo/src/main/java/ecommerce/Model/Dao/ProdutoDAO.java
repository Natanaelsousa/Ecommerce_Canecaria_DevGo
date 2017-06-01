package ecommerce.Model.Dao;

import ecommerce.Model.MetodosAcessores.Produto;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.Part;


/*@author sibele.nsantos*/
public interface ProdutoDAO {

    public void CadastrarProduto(Produto produto, String caminhoImagem) throws SQLException;

    public Produto BuscarProdutoPorID(int id_produto) throws SQLException;

    public void ExclusaoDeCadastroProduto(Produto produto) throws SQLException;

    public void EditarCadastroProduto(Produto produto) throws SQLException;

    public Produto BuscarProdutoPorCategoria(String codigo_categoria) throws SQLException;

    public void InserirQuantidadeDeProdutoExistente(Produto produto) throws SQLException;

    public List<Produto> ListarProdutosPorIDeNome() throws SQLException;

    public List<Produto> ListarProdutosCategoria(String categoria) throws SQLException;
    
    public List<Produto> ListarProdutos() throws SQLException;
    
    public int quantidadeEstoque(int id_produto);
    
    public List<Produto> ListarProdutosPorCategoria(String codigo_categoria) throws SQLException;

}
