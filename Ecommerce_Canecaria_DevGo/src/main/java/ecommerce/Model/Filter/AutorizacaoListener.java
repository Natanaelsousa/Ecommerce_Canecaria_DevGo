/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Model.Filter;


import ecommerce.Model.Bean.ClienteBean;
import ecommerce.Model.Bean.UsuarioSistema;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 *
 * @author Natanael Santos
 */
public class AutorizacaoListener implements PhaseListener {

  @Override
  public void afterPhase(PhaseEvent event) {
    FacesContext fc = event.getFacesContext();
    
    ClienteBean usuarioBean = fc.getApplication()
	    .evaluateExpressionGet(fc, "#{usuarioBean}", 
		    ClienteBean.class);
    
    String paginaAtual = fc.getViewRoot().getViewId();
    NavigationHandler nh = fc.getApplication().getNavigationHandler();
    
    if (paginaAtual != null && paginaAtual.contains("/protegido")) {
      
      // Usuario não tem sessao ativa ou não se logou
      if (usuarioBean == null || usuarioBean.getCriptoUser() == null) {
	nh.handleNavigation(fc, null, "/login.xhtml?faces-redirect=true");
	return;
      }
      
      // Validar se usuario tem permissao para acessar a página,
      // através do papel e da página
      if (!verificarAcesso(usuarioBean.getCriptoUser(), paginaAtual)) {
	nh.handleNavigation(fc, null, "/erro-nao-autorizado.xhtml?faces-redirect=true");
	return;
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
  
  private static boolean verificarAcesso(UsuarioSistema usuario,
	  String paginaAcessada) {
    if (paginaAcessada.lastIndexOf("pagina-admin.xhtml") > -1 
	    && usuario.temPapel("BASICO")) {
      return true;
    } else if (paginaAcessada.lastIndexOf("formulario.xhtml") > -1
	    && usuario.temPapel("ADMIN")) {
      return true;
    }
    // Outras condições...
    return false;
  }
  
}