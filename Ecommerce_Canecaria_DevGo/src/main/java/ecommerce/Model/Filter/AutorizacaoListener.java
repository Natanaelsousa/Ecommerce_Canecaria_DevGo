/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Model.Filter;


import ecommerce.Model.Bean.ClienteBean;
import ecommerce.Model.Bean.LoginBean;
import ecommerce.Model.Bean.UsuarioSistema;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Natanael Santos
 */
public class AutorizacaoListener implements PhaseListener {

  @Override
  public void afterPhase(PhaseEvent event) {
    FacesContext fc = event.getFacesContext();
    
    LoginBean usuarioBean = fc.getApplication()
	    .evaluateExpressionGet(fc, "#{LoginBean}", 
		    LoginBean.class);
    
    String paginaAtual = fc.getViewRoot().getViewId();
    NavigationHandler nh = fc.getApplication().getNavigationHandler();
    
    if (paginaAtual != null && paginaAtual.contains("/protegido")) {
      
      // Usuario não tem sessao ativa ou não se logou
      if ( usuarioBean == null) {
	nh.handleNavigation(fc, null, "/MinhaConta.xhtml?faces-redirect=true");
	return;
      }
      
      // Validar se usuario tem permissao para acessar a página,
      // através do papel e da página
      if (!verificarAcesso(usuarioBean, paginaAtual)) {
           String mensagem = "Erro ao se tentar se logar!";
           RequestContext context = RequestContext.getCurrentInstance();
	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Usuário ou senha inválidos", "Usuário ou senha inválidos");
            FacesContext.getCurrentInstance().addMessage(null, message);
            context.addCallbackParam("loggedIn", mensagem);
      }
      
      // Se processamento chegar nese ponto, JSF prossegue com o 
      // processamento normal da requisição.
    }
    
  }

  @Override
  public void beforePhase(PhaseEvent event) {
    // Nao faz nada.
  }

  @Override
  public PhaseId getPhaseId() {
    return PhaseId.RESTORE_VIEW;
  }
  
  private static boolean verificarAcesso(LoginBean usuario,
	  String paginaAcessada) {
    if (paginaAcessada.lastIndexOf("AmbienteCliente.xhtml") > -1 
	    && usuario.getCliente() != null) {
      return true;
    } else if (paginaAcessada.lastIndexOf("EditarCadastroCliente.xhtml") > -1
	    &&  usuario.getCliente() != null) {
      return true;
    }
    // Outras condições...
    return false;
  }
  
}