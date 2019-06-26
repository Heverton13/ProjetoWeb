/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufrn.util;

import com.ufrn.dao.implementations.AmostraDaoImpl;
import com.ufrn.dao.implementations.AnalisesDaoImpl;
import com.ufrn.dao.interfaces.IAmostraDAO;
import com.ufrn.dao.interfaces.IAnalisesDAO;
import com.ufrn.model.Amostra;
import com.ufrn.model.Analises;

/**
 *
 * @author Dev
 */
public class Exemplo {
    
    public static void main(String[] args) {
        
    IAmostraDAO amostradao = new AmostraDaoImpl();
    Analises a = new Analises();
    a.setNome_analise("Desmaturação");
    
    
    
    
    
    IAnalisesDAO analisedao = new AnalisesDaoImpl();
        
    }
    
}
