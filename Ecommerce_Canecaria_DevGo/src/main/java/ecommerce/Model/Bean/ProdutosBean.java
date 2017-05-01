package ecommerce.Model.Bean;

import ecommerce.Model.Dao.ProdutoDAO;
import ecommerce.Model.DaoImplementation.ProdutoDAOImpl;
import ecommerce.Model.MetodosAcessores.Categoria;
import ecommerce.Model.MetodosAcessores.Produto;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/*  @author sibele */
@ManagedBean(name = "ProdutosBean")
public class ProdutosBean {

    private Produto produto = new Produto();

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public ProdutosBean() {
    }

    /*Responsavel pelo cadastro do produto*/
    public String CadastrarProduto() throws Exception {
        ProdutoDAO produtos = new ProdutoDAOImpl();
        try {
            produtos.CadastrarProduto(produto);
        } catch (SQLException erro) {
            System.err.println("Este produto ja foi cadastrado.");
        }

        return "Cadastrado";
    }

    /* Edita dados do produtos no banco */
    public String EditarProduto() throws Exception {
        ProdutoDAO produtos = new ProdutoDAOImpl();
        produtos.EditarCadastroProduto(produto);
        return "Editado";
    }

    /* Insere quantidade de produtos(Ja cadastrados) no banco */
    public void InserirProdutosNoEstoque() throws Exception {
        ProdutoDAO produtos = new ProdutoDAOImpl();
        try {
            produtos.InserirQuantidadeDeProdutoExistente(produto);
        } catch (SQLException erro) {
            System.err.println("Não foi possivel incluir produtos no estoque.");
        }
        
    }

    public void ExcluirProduto() throws Exception {
        ProdutoDAO produtos = new ProdutoDAOImpl();
        produtos.ExclusaoDeCadastroProduto(produto);
    }

    public void BuscandoProduto() throws Exception {
        ProdutoDAO produtos = new ProdutoDAOImpl();
        produtos.BuscarUmProduto(produto);
    }

    /* Lista os produtos cadastrados no banco */
    public List<Produto> ListarProdutosIdENome() throws Exception {
        ProdutoDAO produtosDao = new ProdutoDAOImpl();

        List<Produto> ListaProdutos = produtosDao.ListarProdutosPorIDeNome();

        return ListaProdutos;
    }

//    public Produto getProduto() {
//        if (produto == null) {
//            FacesContext fc = FacesContext.getCurrentInstance();
//            Map<String, String> params = fc.getExternalContext()
//                    .getRequestParameterMap();
//            String id = params.get("id");
//            if (id != null) {
//                produto = service.obter(Long.parseLong(id));
//            } else {
//                produto = new Produto();
//            }
//        }
//        return produto;
//    }
}
