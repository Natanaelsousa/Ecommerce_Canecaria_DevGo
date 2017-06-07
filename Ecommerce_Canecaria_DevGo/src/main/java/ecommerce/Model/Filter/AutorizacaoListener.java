/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Model.Filter;


import ecommerce.Model.Bean.FuncionarioBean;
import ecommerce.Model.Bean.LoginBean;
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
    
    LoginBean usuarioBean = fc.getApplication()
	    .evaluateExpressionGet(fc, "#{LoginBean}", 
		    LoginBean.class);    
  
   LoginBean funcBean = fc.getApplication()
	    .evaluateExpressionGet(fc, "#{LoginBean}", 
		    LoginBean.class);  
        

    
    String paginaAtual = fc.getViewRoot().getViewId();
    NavigationHandler nh = fc.getApplication().getNavigationHandler();
    
    if (paginaAtual != null && paginaAtual.contains("/protegido")) {
      
      // Usuario não tem sessao ativa ou não se logou
      if ( usuarioBean.getCliente() == null) {
	nh.handleNavigation(fc, null, "MinhaConta.xhtml?faces-redirect=true");
	return;
      } else if (funcBean.getFuncionario() == null){
          nh.handleNavigation(fc, null, "LoginEmpresa.xhtml?faces-redirect=true");
	return;
      }
      
      // Validar se usuario tem permissao para acessar a página,
      // através do papel e da página
      if (!verificarAcesso(usuarioBean, paginaAtual)) {
         
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
    } else if ((paginaAcessada.lastIndexOf("HomePage.xhtml") > -1) 
            && usuario.getCliente() != null){
        usuario = new LoginBean ();
        return true;
    }else if (paginaAcessada.lastIndexOf("Checkout.xhtml") > -1
	    &&  usuario.getCliente() != null) {
      return true;
    }
    // Outras condições...
    return false;
  }
  
}