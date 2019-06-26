/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufrn.bean;

import com.ufrn.dao.implementations.AmostraDaoImpl;
import com.ufrn.dao.implementations.AnalisesDaoImpl;
import com.ufrn.dao.implementations.UserDaoImpl;
import com.ufrn.dao.interfaces.IAmostraDAO;
import com.ufrn.dao.interfaces.IAnalisesDAO;
import com.ufrn.dao.interfaces.IUserDAO;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.ufrn.model.*;
import com.ufrn.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Dev
 */

@ManagedBean(name = "amostra")
@ApplicationScoped
public class AmostraBean {
    
    Amostra amostra;
    Analises analise;
    String data = "1";
    
    ArrayList<Amostra> amostras = new ArrayList<Amostra>();
    
    ArrayList<Amostra> listaamostras = new ArrayList<Amostra>();
    List<Analises> listaanalises;

    public AmostraBean() {
        
        this.amostra = new Amostra();
        this.analise = new Analises();
        //this.usuario = new User();
        
        this.listaamostras = new ArrayList<Amostra>();
        this.listaanalises = new ArrayList<Analises>();
        
    }
    
    IAmostraDAO amostradao = new AmostraDaoImpl();
    IAnalisesDAO analisedao = new AnalisesDaoImpl();
    
    
    public void cadastroAmostra(){
        
        //HttpSession s = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        //Solicitante u = (Solicitante) s.getAttribute("usuario-logado");
        
        Session sessao = null;
	sessao = HibernateUtil.getSessionFactory().openSession();
        
        //amostra.setSol(u);
        
        amostradao.save(amostra);
        
        amostra = new Amostra();
       
        sessao.close();
        
        
    }
    
    
    public void cadastroAnalise(){
        
       
        Session sessao = null;
	sessao = HibernateUtil.getSessionFactory().openSession();
        
        analisedao.save(analise);
        
        
        amostra = new Amostra();
        analise = new Analises();
        
        sessao.close();
        
    }
        
    public void showMessage() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "","Cadastro Realizado com Sucesso");
         
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public Amostra getAmostra() {
        return amostra;
    }

    public void setAmostra(Amostra amostra) {
        this.amostra = amostra;
    }
    
    public Analises getAnalise() {
        return analise;
    }

    public void setAnalise(Analises analise) {
        this.analise = analise;
    }
    
    public void removerAmostra(Amostra a){
        
        
        Session sessao = null;
	sessao = HibernateUtil.getSessionFactory().openSession();

        amostradao.delete(a);

        sessao.close();
}

    public ArrayList<Amostra> listaamostras() {
        Session sessao = null;
	sessao = HibernateUtil.getSessionFactory().openSession();
        
        this.listaamostras = (ArrayList<Amostra>) amostradao.findAll();
        
        sessao.close();
        return listaamostras;
    }

    public void setListaamostras(ArrayList<Amostra> listaamostras) {
        this.listaamostras = listaamostras;
    }

    public List<Analises> getListaanalises() {
        return listaanalises;
    }

    public void setListaanalises(List<Analises> listaanalises) {
        this.listaanalises = listaanalises;
    }

    public IAmostraDAO getAmostradao() {
        return amostradao;
    }

    public void setAmostradao(IAmostraDAO amostradao) {
        this.amostradao = amostradao;
    }

    public IAnalisesDAO getAnalisedao() {
        return analisedao;
    }

    public void setAnalisedao(IAnalisesDAO analisedao) {
        this.analisedao = analisedao;
    }

    public ArrayList<Amostra> getAmostras() {
        return amostras;
    }

    public void setAmostras(ArrayList<Amostra> amostras) {
        this.amostras = amostras;
    }
    
    
    
}
