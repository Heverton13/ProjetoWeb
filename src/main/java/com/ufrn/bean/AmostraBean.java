/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufrn.bean;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
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
import javax.servlet.http.HttpServletRequest;
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
    
    ArrayList<Amostra> fechadas;

    public ArrayList<Amostra> getFechadas() {
        return fechadas;
    }

    public void setFechadas(ArrayList<Amostra> fechadas) {
        this.fechadas = fechadas;
    }
    
    List<Amostra> listaamostras = new ArrayList<>();
    List<Analises> listaanalises;
    
    IAmostraDAO amostradao = new AmostraDaoImpl();
    IAnalisesDAO analisedao = new AnalisesDaoImpl();
    
    public AmostraBean() {
        
        this.amostra = new Amostra();
        this.analise = new Analises();
        //this.usuario = new User();
        
        this.fechadas = new ArrayList<>();
        this.listaamostras = amostradao.listAll();
        this.listaanalises = new ArrayList<>();
        
    }
    
    public String cancelar(){
        
        amostra = new Amostra();
        analise = new Analises();     
        
        return "/faces/user/Bemvindouser.xhtml?faces-redirect=true";
    }
    
    public String cadastroAmostra(){
  
        Session sessao = null;
	sessao = HibernateUtil.getSessionFactory().openSession();
        	
        
        amostradao.save(amostra);
        
        analisedao.save(analise);
          
        amostra.addAnalise(analise);
        analisedao.save(analise);
        amostradao.save(amostra);
        
        
        sessao.close();
        
        showMessage();
        
        return "/faces/user/Bemvindouser.xhtml?faces-redirect=true";
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
        
        fechadas.add(a);
        Session sessao = null;
	sessao = HibernateUtil.getSessionFactory().openSession();
        
        
        amostradao.delete(a);

        sessao.close();
        System.out.println(fechadas);
 
}

    public List<Amostra> getListaamostras() {
        Session sessao = null;
	sessao = HibernateUtil.getSessionFactory().openSession();
        
        this.listaamostras = (ArrayList<Amostra>) amostradao.findAll();
        
        sessao.close();
        return (ArrayList<Amostra>) listaamostras;
    }

    public void setListaamostras(List<Amostra> listaamostras) {
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
        return fechadas ;
    }

    public void setAmostras(ArrayList<Amostra> amostras) {
        this.fechadas = amostras;
    }
    
    
    
}
