/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufrn.dao.implementations;

import com.ufrn.dao.interfaces.IAnalisesDAO;
import com.ufrn.model.Analises;

/**
 *
 * @author Dev
 */
public class AnalisesDaoImpl extends GenericDaoImpl<Analises, Integer> implements IAnalisesDAO {

    public AnalisesDaoImpl() {
        super(Analises.class);
    }
    
}
