/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itiket.service;

import com.itiket.entity.Concierto;
import com.itiket.repository.ConciertoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author User
 */
@Service
public class ConciertoService implements IConciertoService {

    @Autowired
    private ConciertoRepository conciertoRepository;

    @Override
    public List<Concierto> getAllConcierto() {
        return (List<Concierto>) conciertoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Concierto> getConciertoId(Concierto concierto) {
        return (List<Concierto>) conciertoRepository.findAll();
    }

    @Override
    @Transactional
    public void saveConcierto(Concierto concierto) {
        conciertoRepository.save(concierto);
    }

    @Override
    @Transactional
    public void delete(Concierto concierto) {
        conciertoRepository.delete(concierto);
    }

    @Override
    @Transactional(readOnly = true)
    public Concierto getConcierto(Concierto concierto) {
        return conciertoRepository.findById(concierto.getId()).orElse(null);
    }
}
