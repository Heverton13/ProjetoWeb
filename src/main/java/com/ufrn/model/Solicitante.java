/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufrn.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import net.bytebuddy.implementation.bind.annotation.Super;

/**
 *
 * @author Dev
 */
@Entity
@PrimaryKeyJoinColumn(name="idPessoa")
public class Solicitante extends User implements Serializable {
    

    
    @Column(length = 55)
    private String nome_professor;
    
    @Column(length = 45)
    private String departamento;
    
    @Column(length = 11)
    private String telefone;
    
    @Column(length = 60)
    private String email_solicitante;

    public Solicitante() {
    }

    public Solicitante( String nome_professor, String departamento, String telefone, String email_solicitante) {
        this.nome_professor = nome_professor;
        this.departamento = departamento;
        this.telefone = telefone;
        this.email_solicitante = email_solicitante;
    }

    public String getNome_professor() {
        return nome_professor;
    }

    public void setNome_professor(String nome_professor) {
        this.nome_professor = nome_professor;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail_solicitante() {
        return email_solicitante;
    }

    public void setEmail_solicitante(String email_solicitante) {
        this.email_solicitante = email_solicitante;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nome_professor);
        hash = 97 * hash + Objects.hashCode(this.departamento);
        hash = 97 * hash + Objects.hashCode(this.telefone);
        hash = 97 * hash + Objects.hashCode(this.email_solicitante);
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
        final Solicitante other = (Solicitante) obj;
       
        if (!Objects.equals(this.nome_professor, other.nome_professor)) {
            return false;
        }
        if (!Objects.equals(this.departamento, other.departamento)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.email_solicitante, other.email_solicitante)) {
            return false;
        }
        return true;
    }
    
    
}
