/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufrn.dao.implementations;

import com.ufrn.dao.interfaces.IResponsavelDAO;
import com.ufrn.model.Responsavel;

/**
 *
 * @author Dev
 */
public class ResponsavelDaoImpl extends GenericDaoImpl<Responsavel, Integer> implements IResponsavelDAO {

    public ResponsavelDaoImpl() {
        super(Responsavel.class);
    }
    
}
