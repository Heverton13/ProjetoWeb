/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufrn.model;

/**
 *
 * @author Dev
 */

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author Dev
 */
@Entity
@Table(name = "ANALISES")
public class Analises implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_analise")
    private Integer id_analise;
    
    @Column(length = 50)
    private String nome_analise;
    
    public Integer getId_analise() {
        return id_analise;
    }

    public void setId_analise(Integer id_analise) {
        this.id_analise = id_analise;
    }

    public String getNome_analise() {
        return nome_analise;
    }

    public void setNome_analise(String nome_analise) {
        this.nome_analise = nome_analise;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.id_analise);
        hash = 11 * hash + Objects.hashCode(this.nome_analise);
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
        final Analises other = (Analises) obj;
        if (!Objects.equals(this.id_analise, other.id_analise)) {
            return false;
        }
        if (!Objects.equals(this.nome_analise, other.nome_analise)) {
            return false;
        }
        return true;
    }
    
    
    
}
