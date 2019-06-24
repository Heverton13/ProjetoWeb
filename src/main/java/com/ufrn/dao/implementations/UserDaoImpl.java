/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufrn.dao.implementations;

import com.ufrn.dao.interfaces.IUserDAO;
import com.ufrn.model.User;

/**
 *
 * @author Dev
 */
public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements IUserDAO {
    
    public UserDaoImpl() {
        super(User.class);
    }
}
