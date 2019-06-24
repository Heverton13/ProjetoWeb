/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufrn.dao.implementations;

import com.ufrn.dao.interfaces.IAmostraDAO;
import com.ufrn.model.Amostra;

/**
 *
 * @author Dev
 */
public class AmostraDaoImpl extends GenericDaoImpl<Amostra, Integer> implements IAmostraDAO {

    public AmostraDaoImpl() {
        super(Amostra.class);
    }
    
}
