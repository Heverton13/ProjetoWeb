/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufrn.dao.bean;


import com.ufrn.dao.implementations.LoginDaoImpl;
import com.ufrn.dao.implementations.ResponsavelDaoImpl;
import com.ufrn.dao.implementations.SolicitanteDaoImpl;
import com.ufrn.dao.interfaces.ILoginDAO;
import com.ufrn.dao.interfaces.IResponsavelDAO;
import com.ufrn.dao.interfaces.ISolicitanteDAO;
import com.ufrn.model.*;
import com.ufrn.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import org.hibernate.Session;

/**
 *
 * @author Dev
 */
@ManagedBean(name = "usuario")
public class ControllerUsuarios {
 
    Responsavel responsavel;
    Solicitante solicitante;
    Login login;
    User user;
    
    List<User> listausuarios;
    List<Login> listalogins;

    public ControllerUsuarios() {
        
        this.responsavel = new Responsavel();
        this.solicitante = new Solicitante();
        this.user = new User();
        this.login = new Login();
        
        this.listausuarios = new ArrayList<User>();
        this.listalogins = new ArrayList<Login>();
        
    }
    
    ISolicitanteDAO solicitantedao = new SolicitanteDaoImpl();
    IResponsavelDAO responsavelDAO = new ResponsavelDaoImpl();
    ILoginDAO logindao = new LoginDaoImpl();
    
    
    public String cadastraResponsavel(){
        
        Session sessao = null;
	sessao = HibernateUtil.getSessionFactory().openSession();
        
        responsavelDAO.save(responsavel);
        logindao.save(login);

        sessao.close();
        
        return "/Login.xhtml?faces-redirect=true";
        
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getListausuarios() {
        return listausuarios;
    }

    public void setListausuarios(List<User> listausuarios) {
        this.listausuarios = listausuarios;
    }

    public List<Login> getListalogins() {
        return listalogins;
    }

    public void setListalogins(List<Login> listalogins) {
        this.listalogins = listalogins;
    }

    public ISolicitanteDAO getSolicitantedao() {
        return solicitantedao;
    }

    public void setSolicitantedao(ISolicitanteDAO solicitantedao) {
        this.solicitantedao = solicitantedao;
    }

    public IResponsavelDAO getResponsavelDAO() {
        return responsavelDAO;
    }

    public void setResponsavelDAO(IResponsavelDAO responsavelDAO) {
        this.responsavelDAO = responsavelDAO;
    }

    public ILoginDAO getLogindao() {
        return logindao;
    }

    public void setLogindao(ILoginDAO logindao) {
        this.logindao = logindao;
    }
    
    
}
