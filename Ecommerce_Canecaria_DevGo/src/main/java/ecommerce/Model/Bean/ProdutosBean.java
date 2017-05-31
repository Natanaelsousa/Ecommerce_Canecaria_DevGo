package ecommerce.Model.Bean;

import ecommerce.Model.Dao.ProdutoDAO;
import ecommerce.Model.DaoImplementation.ProdutoDAOImpl;
import ecommerce.Model.MetodosAcessores.Produto;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.Part;

/* @author sibele */
@ManagedBean(name = "ProdutosBean")
public class ProdutosBean {

    private Produto produto = new Produto();
    private int id_produto;
    private Part imagem;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public ProdutosBean() {
    }

    public Part getImagem() {
        return imagem;
    }

    public void setImagem(Part imagem) {
        this.imagem = imagem;
    }

    public void CadastrarProduto() throws Exception {

        ProdutoDAO produtos = new ProdutoDAOImpl();
        byte[] imgBytes = null;
        String nomeArquivo = null;
        try {
            try {
                if (imagem != null) {
                    String partHeader = imagem.getHeader("content-disposition");
                    System.out.println("***** partHeader: " + partHeader);
                    for (String content : partHeader.split(";")) {
                        if (content.trim().startsWith("filename")) {
                            System.out.println("***** content: " + content);
                            nomeArquivo = content.substring(content.indexOf('=') + 1);
                            System.out.println("***** nomeArquivo 1: " + nomeArquivo);
                            nomeArquivo = nomeArquivo.trim().replace("\"", "");
                            int lastFilePart = nomeArquivo.lastIndexOf("\\");
                            if (lastFilePart > 0) {
                                nomeArquivo = nomeArquivo.substring(lastFilePart, nomeArquivo.length());
                            }
                            String destino = "C:\\desenv\\imagens\\";
                            File arquivo = new File(destino + nomeArquivo);
                            System.out.println("***** arquivo: " + arquivo.getAbsolutePath());

                            try (InputStream inputStream = imagem.getInputStream();
                                    OutputStream outputStream
                                    = new FileOutputStream(arquivo)) {
                                int read = 0;
                                imgBytes = new byte[1024];
                                while ((read = inputStream.read(imgBytes)) != -1) {
                                    outputStream.write(imgBytes, 0, read);
                                }
                            }
                        }
                    }
                }
            } catch (IOException ex) {

            }
//            produto.setImagem(imgBytes);
            produtos.CadastrarProduto(produto, nomeArquivo);

        } catch (SQLException erro) {
            System.err.println("Este produto ja foi cadastrado.");
        }
        produto = new Produto();

    }

    /*Busca produto para em seguida edita-lo*/
    public String buscandoProduto() throws Exception {
        ProdutoDAO produtos = new ProdutoDAOImpl();
        String retorno = null;
        try {
            produto = produtos.BuscarProdutoPorID(id_produto);

        } catch (SQLException erro) {
            System.err.println("Não foi possivel localizar o produto");
        }

        // Verifica se algum produto foi escolhido
        if (produto.getCod_produto() != null) {
            retorno = "EditarCadastroProdutos";
        } else {
            retorno = "Produto nao selecionado";
        }
        return retorno;
    }

    /* Edita dados, no banco, do produto selecionado*/
    public String editarProduto() throws Exception {
        ProdutoDAO produtos = new ProdutoDAOImpl();
        produto.setCod_produto(id_produto);

        byte[] imgBytes = null;
        String nomeArquivo = null;
        try {
            try {
                if (imagem != null) {
                    String partHeader = imagem.getHeader("content-disposition");
                    System.out.println("***** partHeader: " + partHeader);
                    for (String content : partHeader.split(";")) {
                        if (content.trim().startsWith("filename")) {
                            System.out.println("***** content: " + content);
                            nomeArquivo = content.substring(content.indexOf('=') + 1);
                            System.out.println("***** nomeArquivo 1: " + nomeArquivo);
                            nomeArquivo = nomeArquivo.trim().replace("\"", "");
                            int lastFilePart = nomeArquivo.lastIndexOf("\\");
                            if (lastFilePart > 0) {
                                nomeArquivo = nomeArquivo.substring(lastFilePart, nomeArquivo.length());
                            }
                            String destino = "C:\\desenv\\imagens\\";
                            File arquivo = new File(destino + nomeArquivo);
                            System.out.println("***** arquivo: " + arquivo.getAbsolutePath());

                            try (InputStream inputStream = imagem.getInputStream();
                                    OutputStream outputStream
                                    = new FileOutputStream(arquivo)) {
                                int read = 0;
                                imgBytes = new byte[1024];
                                while ((read = inputStream.read(imgBytes)) != -1) {
                                    outputStream.write(imgBytes, 0, read);
                                }
                            }
                        }
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            if (imagem != null) {
                produto.setImagem_produto(nomeArquivo);
            }else{
                System.out.println(produto.getImagem_produto());
            }
            produtos.EditarCadastroProduto(produto);
        } catch (SQLException erro) {
            System.err.println("Não foi possivel alterar os dados deste produto.");
        }

        return "BuscarProdutoEditar";
    }


    /* Insere quantidade de produtos(Ja cadastrados) no banco */
    public void InserirProdutosNoEstoque() throws Exception {
        ProdutoDAO produtos = new ProdutoDAOImpl();
        try {
            produtos.InserirQuantidadeDeProdutoExistente(produto);
        } catch (SQLException erro) {
            System.err.println("Não foi possivel incluir produtos no estoque.");
        }
        produto = new Produto();
    }

    /* Excluir produtos do banco (DEFINITIVAMENTE)*/
    public void ExcluirProduto() throws Exception {
        ProdutoDAO produtos = new ProdutoDAOImpl();
        produtos.ExclusaoDeCadastroProduto(produto);
    }

    /* Lista os produtos cadastrados no banco */
    public List<Produto> ListarProdutosIdENome() throws Exception {
        ProdutoDAO produtosDao = new ProdutoDAOImpl();

        List<Produto> ListaProdutos = produtosDao.ListarProdutosPorIDeNome();

        return ListaProdutos;
    }

}
