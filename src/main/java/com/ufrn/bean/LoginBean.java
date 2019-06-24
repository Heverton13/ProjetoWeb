/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufrn.bean;

import com.ufrn.model.Login;
import com.ufrn.model.User;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dev
 */
@RequestScoped
@ManagedBean(name = "login")
public class LoginBean {
    
    @ManagedProperty(value = "#{usuario}")
	private ControllerUsuarios usuarios;
	private String login;
	private String senha;
	
	public String autentica(){
		
                //System.out.println(u.getUsername() + u.getSenha());
                System.out.println(login + senha);
		FacesContext context = FacesContext.getCurrentInstance();
		
		
		for (Login u : usuarios.getListalogins()) {
			System.out.println(u.getUsername() + u.getSenha());
			if (u.getUsername().equals(this.getLogin())){
                            System.out.println(u.getUsername() + u.getSenha());
                            System.out.println(login + senha);
				if(u.getSenha().equals(this.getSenha())){
					if(u.isAdmin() == true){
						ExternalContext ec = context.getExternalContext();
						HttpSession s = (HttpSession) ec.getSession(true);
						s.setAttribute("admin-logado", u);
						return "/admin/Bemvindoadmin?faces-redirect=true";
					}else{
						ExternalContext ec = context.getExternalContext();
						HttpSession s = (HttpSession) ec.getSession(true);
						s.setAttribute("usuario-logado", u);
						return "/user/Bemvindouser?faces-redirect=true";
					}

				}/*else{
					FacesMessage mensagem = new FacesMessage("Senha invï¿½lida!");
					mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
					context.addMessage(null, mensagem);
					return null;*/
				//}
			}/*else{
				FacesMessage mensagem = new FacesMessage("Usuï¿½rio/senha invï¿½lidos!");
				mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
				context.addMessage(null, mensagem);
				return null;
			}*/
			
		}
		FacesMessage mensagem = new FacesMessage("Usuario/senha invalidos!");
		mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
		context.addMessage(null, mensagem);
		return null;
		
	}
	
	public String sair(){
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext ec = context.getExternalContext();
			HttpSession s = (HttpSession) ec.getSession(true);
			s.invalidate();
			return "saiu";
	}

    public ControllerUsuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ControllerUsuarios usuarios) {
        this.usuarios = usuarios;
    }
        
        

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
    
}
