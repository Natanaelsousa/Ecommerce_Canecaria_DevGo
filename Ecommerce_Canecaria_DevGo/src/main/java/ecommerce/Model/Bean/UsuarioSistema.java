/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Model.Bean;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Natanael Santos
 */
public class UsuarioSistema {
    
 private static final Map<String, UsuarioSistema> USUARIOS_CADASTRADOS;

  static {
    USUARIOS_CADASTRADOS = new LinkedHashMap<>();
    USUARIOS_CADASTRADOS.put("madruga", new UsuarioSistema("madruga",
	    "Seu Madruga", "pagueoaluguel", new String[]{"BASICO"}));
    USUARIOS_CADASTRADOS.put("bozo", new UsuarioSistema("bozo",
	    "Palhaço Bozo", "abcd1234", new String[]{"BASICO", "ADMIN"}));
  }

  private String usuario;

  private String nomeCompleto;

  private String hashSenha;

  private String[] papeis; // ROLES

  public UsuarioSistema() {

  }

  public UsuarioSistema(String usuario, String nomeCompleto, String senha, String[] papeis) {
    this.usuario = usuario;
    this.nomeCompleto = nomeCompleto;
    setSenha(senha);
    this.papeis = papeis;
  }

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public String getNomeCompleto() {
    return nomeCompleto;
  }

  public void setNomeCompleto(String nomeCompleto) {
    this.nomeCompleto = nomeCompleto;
  }

  public String getHashSenha() {
    return hashSenha;
  }

  public final void setSenha(String senha) {
    this.hashSenha = BCrypt.hashpw(senha, BCrypt.gensalt());
  }

  public String[] getPapeis() {
    return papeis;
  }

  public void setPapeis(String[] papeis) {
    this.papeis = papeis;
  }
  
  public boolean temPapel(String papel) {
    List<String> papeisUsuario = Arrays.asList(papeis);
    return papeisUsuario.contains(papel);
  }
//  -benzóico.
//* Este método pode ser usado para verificar um hash calculado a partir de um texto simples (por exemplo, durante um login
//* Request) com o de um hash armazenado a partir de um banco de dados. O hash de senha do banco de dados
//* Deve ser passado como a segunda variável.
//* @param password_plaintext Senha de texto simples da conta, conforme fornecido durante uma solicitação de login
//* @param stored_hash O hash da senha armazenada da conta, recuperado do banco de dados de autorização
//* @return boolean - true se a senha coincide com a senha do hash armazenado, false caso contrário
//-benzóico.
public boolean validaSenha (String senhaGravada, String senhaLogin) {
		boolean senha_verificada = false;

		if(BCrypt.checkpw(senhaGravada, senhaLogin) == true){
                    senha_verificada = true;
                }
		

		return senha_verificada;
	}


  public static UsuarioSistema obterUsuario(String usuario, String senha) {
    UsuarioSistema usuarioEncontrado = USUARIOS_CADASTRADOS.get(usuario);
    if (usuarioEncontrado != null && BCrypt.checkpw(senha, usuarioEncontrado.getHashSenha())) {
      return usuarioEncontrado;
    }
    return null;
  }

}