/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufrn.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author Dev
 */
@Entity
@Table(name = "AMOSTRA")
public class Amostra implements Serializable {
    
    //private int id;
    
    @Id
    @Column(name = "id_amostra")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_amostra;
    
    @Column
    private String codigo;
    
    @Column
    private String descricao;
    
    @Column
    private int frascos;
    
    @Column
    private String observacoes;
    
    @Column(name = "data_entrada", updatable = false)
    private Date data_entrada;
    
    @Column(name = "data_recebido", updatable = false)
    private Date data_recebido;

    
    //Caso 3
    @ManyToOne
    @JoinColumn(name = "login_id")
    private Login sol;
    
    public Amostra(String codigo, String descricao, int frascos, String observacoes, Date data_entrada) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.frascos = frascos;
        this.observacoes = observacoes;
        this.data_entrada = data_entrada;
    }

    public Amostra(String codigo, String descricao, int frascos, String observacoes, Date data_entrada, Date data_recebido) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.frascos = frascos;
        this.observacoes = observacoes;
        this.data_entrada = data_entrada;
        this.data_recebido = data_recebido;
    }

    public Amostra() {
    }   
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "amostra_analise", joinColumns = { @JoinColumn(name = "amostra_id", 
    referencedColumnName = "id_amostra") }, inverseJoinColumns = { @JoinColumn(name = "id_analise") })
    private List<Analises> listanalises = new ArrayList<Analises>();
    /*
    public Amostra(String codigo, String descricao, int frascos, String observacoes, Date data_entrada, Solicitante sol, Responsavel responsavel) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.frascos = frascos;
        this.observacoes = observacoes;
        this.data_entrada = data_entrada;
        this.sol = sol;
        this.responsavel = responsavel;
    }
    */

    public List<Analises> getAnalises() {
        return listanalises;
    }

    public void setAnalises(List<Analises> analises) {
        this.listanalises = analises;
    }
    
    public Integer getId_amostra() {
        return id_amostra;
    }
    
    public void addAnalise(Analises nAnalises){
        listanalises.add(nAnalises);
        // GET 
    }
    
    public void removeAnalise(Analises nAnalises){
        listanalises.remove(nAnalises);
        // GET 
    }
    
    public void setId_amostra(Integer id_amostra) {
        this.id_amostra = id_amostra;
    }
    
    public Date getData_recebido() {
        return data_recebido;
    }

    public void setData_recebido(Date data_recebido) {
        this.data_recebido = data_recebido;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getFrascos() {
        return frascos;
    }

    public void setFrascos(int frascos) {
        this.frascos = frascos;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Date getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }

    public Login getSol() {
        return sol;
    }

    public void setSol(Login sol) {
        this.sol = sol;
    }

    public List<Analises> getListanalises() {
        return listanalises;
    }

    public void setListanalises(List<Analises> listanalises) {
        this.listanalises = listanalises;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id_amostra);
        hash = 59 * hash + Objects.hashCode(this.codigo);
        hash = 59 * hash + Objects.hashCode(this.descricao);
        hash = 59 * hash + this.frascos;
        hash = 59 * hash + Objects.hashCode(this.observacoes);
        hash = 59 * hash + Objects.hashCode(this.data_entrada);
        hash = 59 * hash + Objects.hashCode(this.sol);
        
        hash = 59 * hash + Objects.hashCode(this.listanalises);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Amostra other = (Amostra) obj;
        if (!Objects.equals(this.id_amostra, other.id_amostra)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (this.frascos != other.frascos) {
            return false;
        }
        if (!Objects.equals(this.observacoes, other.observacoes)) {
            return false;
        }
        if (!Objects.equals(this.data_entrada, other.data_entrada)) {
            return false;
        }
        if (!Objects.equals(this.sol, other.sol)) {
            return false;
        }
        
        if (!Objects.equals(this.listanalises, other.listanalises)) {
            return false;
        }
        return true;
    }
     
}
