/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufrn.dao.interfaces;

import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.Order;

/**
 *
 * @author Dev
 */
public interface IGenericDao<T, ID extends Serializable>  {
    
    void save(T object); 
    void delete(T object); 
    T findById(ID id);
    List<T> listAll(); 
    List<T> findAll(); 
    List<T> findAll(Order order); 
    List<T> findAllBy(String property, List<?> values, Order order);
    List<T> findAllBy(String property, List<?> values);
    
    
}
