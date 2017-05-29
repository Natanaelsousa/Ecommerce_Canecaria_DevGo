package ecommerce.Model.DaoImplementation;

import ecommerce.Model.MetodosAcessores.Produto;
import ecommerce.Model.Dao.ProdutoDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.Part;

/* @author sibele */
public class ProdutoDAOImpl extends GenericaDAOImpl implements ProdutoDAO {

    //Lista todos os produtos 
    @Override
    public List<Produto> ListarProdutosPorIDeNome() throws SQLException {
        List<Produto> produto = new ArrayList<Produto>();

        String query = "SELECT COD_PROD,NOME_PRODUTO FROM PRODUTO ORDER BY cod_prod";

        PreparedStatement stmt
                = getConnection().prepareStatement(query);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Produto produtos = new Produto();

            produtos.setCod_produto(rs.getInt("COD_PROD"));
            produtos.setNome_produto(rs.getString("NOME_PRODUTO"));

            produto.add(produtos);
        }

        rs.close();
        stmt.close();

        return produto;

    }

    //Insere os dados do produto no banco
    public void CadastrarProduto(Produto produto, String caminhoImagem) throws SQLException {
        String query = "INSERT INTO PRODUTO (NOME_PRODUTO, VALOR_PRODUTO, DESCRICAO_PRODUTO,QTDE_PRODUTO, COD_CATEGORIA,IMAGEM_PRODUTO) VALUES (?,?,?,?,?,?)";

        // Ao cadastrar um produto, a quantidade dele inicia por padrão como 0
        produto.setQtde_produto(0);
        produto.setImagem_produto(caminhoImagem);
        insert(query, produto.getNome_produto(), produto.getValor_produto(), produto.getDescricao_produto(), produto.getQtde_produto(), produto.getCod_categoria(), produto.getImagem_produto());
    }

    //Soma a quantidade de produtos ja existentem com a que sera inserida
    @Override
    public void InserirQuantidadeDeProdutoExistente(Produto produto) throws SQLException {
        String update = "update produto "
                + "set QTDE_PRODUTO = (QTDE_PRODUTO+?) "
                + "where COD_PROD = ?";

        update(update, produto.getCod_produto(), produto.getQtde_para_acrescentar());

        System.out.println(produto.getCod_produto());
        System.out.println(produto.getQtde_para_acrescentar());

    }

    // Exclui o produto
    @Override
    public void ExclusaoDeCadastroProduto(Produto produto) throws SQLException {
        String query = "DELETE FROM PRODUTO WHERE COD_PROD = ?";
        delete(query, produto.getCod_produto());
    }

    //Editar os dados do produto no banco
    @Override
    public void EditarCadastroProduto(Produto produto, int id_prod) throws SQLException {

        String query = "UPDATE produto "
                + "SET cod_nome_produto = ?,valor_produto = ?,descricao_produto = ?,categoria = ?, QTDE_PRODUTO = ? WHERE cod_prod = ?";
//        produto.setCod_produto(id_prod);
        update(query, produto.getCod_produto(), produto.getNome_produto(), produto.getValor_produto(), produto.getDescricao_produto(), produto.getCod_categoria(), produto.getQtde_produto(), produto.getCod_produto());

    }

    //Localiza todos os produtos de uma determinada categoria
    @Override
    public Produto BuscarProdutoPorCategoria(String codigo_categoria) throws SQLException {

        String sql = "SELECT COD_PRODUTO,COD_CATEGORIA,NOME_PRODUTO,VALOR_PRODUTO,DESCRICAO_PRODUTO,IMAGEM_PRODUTO FROM PRODUTO WHERE COD_CATEGORIA =" + codigo_categoria;

        Produto produto = new Produto();

        PreparedStatement stmt
                = getConnection().prepareStatement(sql);

        stmt.setString(1, codigo_categoria);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            produto.setCod_produto(rs.getInt("COD_PRODUTO"));
            produto.setCod_categoria(rs.getInt("COD_CATEGORIA"));
            produto.setNome_produto(rs.getString("NOME_PRODUTO"));
            produto.setValor_produto(rs.getFloat("VALOR_PRODUTO"));
            produto.setDescricao_produto(rs.getString("DESCRICAO_PRODUTO"));
            produto.setImagem_produto(rs.getString("imagem_produto"));

        }

        rs.close();
        stmt.close();
        return produto;
    }

    @Override
    public List<Produto> ListarProdutosCategoria(String categoria) throws SQLException {
        List<Produto> produto = new ArrayList<Produto>();

        String query = "SELECT COD_PROD,COD_CATEGORIA,NOME_PRODUTO,VALOR_PRODUTO,DESCRICAO_PRODUTO FROM PRODUTO WHERE COD_CATEGORIA ='" + categoria + "'";

        PreparedStatement stmt
                = getConnection().prepareStatement(query);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Produto produtos = new Produto();

            produtos.setCod_produto(rs.getInt("COD_PROD"));
            produtos.setCod_categoria(rs.getInt("COD_CATEGORIA"));
            produtos.setNome_produto(rs.getString("NOME_PRODUTO"));
            produtos.setValor_produto(rs.getFloat("VALOR_PRODUTO"));
            produtos.setDescricao_produto(rs.getString("DESCRICAO_PRODUTO"));

            produto.add(produtos);
        }

        rs.close();
        stmt.close();

        return produto;

    }

    //Localiza um produto especifico pelo ID
    @Override
    public Produto BuscarProdutoPorID(int id_produto) throws SQLException {

        Produto produto = new Produto();
        String query = "SELECT * FROM PRODUTO WHERE COD_PROD = " + id_produto + " ";

        PreparedStatement stmt
                = getConnection().prepareStatement(query);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            produto.setCod_produto(rs.getInt("COD_PROD"));
            produto.setCod_categoria(rs.getInt("COD_CATEGORIA"));
            produto.setNome_produto(rs.getString("NOME_PRODUTO"));
            produto.setValor_produto(rs.getFloat("VALOR_PRODUTO"));
            produto.setDescricao_produto(rs.getString("DESCRICAO_PRODUTO"));
            produto.setQtde_produto(rs.getInt("QTDE_PRODUTO"));
             produto.setImagem_produto(rs.getString("imagem_produto"));

        }

        rs.close();
        stmt.close();
        return produto;
    }

    @Override
    public List<Produto> ListarProdutos() throws SQLException {
     List<Produto> produtos = new ArrayList<Produto>();

        String query = "SELECT * FROM PRODUTO ";

        PreparedStatement stmt
                = getConnection().prepareStatement(query);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Produto produto = new Produto();

            produto.setCod_produto(rs.getInt("COD_PROD"));
            produto.setCod_categoria(rs.getInt("COD_CATEGORIA"));
            produto.setNome_produto(rs.getString("NOME_PRODUTO"));
            produto.setValor_produto(rs.getFloat("VALOR_PRODUTO"));
            produto.setDescricao_produto(rs.getString("DESCRICAO_PRODUTO"));
            produto.setImagem_produto(rs.getString("IMAGEM_PRODUTO"));

            produtos.add(produto);
        }

        rs.close();
        stmt.close();

        return produtos;
    }
    
    @Override
    public int quantidadeEstoque(int id_produto) {

        
        int quantidade = 0;
        
        try {
            
            
            String query = "SELECT QTDE_PRODUTO FROM produto WHERE COD_PROD =" + id_produto;
            
            PreparedStatement stmt
                    = getConnection().prepareStatement(query);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs != null && rs.next()) {
                
                quantidade = rs.getInt("QTDE_PRODUTO");
                
            }
            
            rs.close();
            stmt.close();
            
            
        } catch (SQLException ex) {
            
            System.err.println(ex);
        }
        
         return quantidade;
    }
    
}
