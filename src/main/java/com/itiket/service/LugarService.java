/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itiket.service;

import com.itiket.entity.Lugar;
import com.itiket.repository.LugarRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class LugarService implements ILugarService {
    
    @Autowired
    private LugarRepository lugarRepository;
    
    @Override
    public List<Lugar> listLugar() {
       return (List<Lugar>)lugarRepository.findAll();
    }
    
}
