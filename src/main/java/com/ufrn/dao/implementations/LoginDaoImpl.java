/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufrn.dao.implementations;

import com.ufrn.dao.interfaces.ILoginDAO;
import com.ufrn.model.Login;

/**
 *
 * @author Dev
 */
public class LoginDaoImpl extends GenericDaoImpl<Login, Integer> implements ILoginDAO {

    public LoginDaoImpl() {
        super(Login.class);
    }
    
}
