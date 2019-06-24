/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufrn.dao.implementations;

import com.ufrn.dao.interfaces.ISolicitanteDAO;
import com.ufrn.model.Solicitante;

/**
 *
 * @author Dev
 */
public class SolicitanteDaoImpl extends GenericDaoImpl<Solicitante, Integer> implements ISolicitanteDAO{

    public SolicitanteDaoImpl() {
        super(Solicitante.class);
    }
    
}
