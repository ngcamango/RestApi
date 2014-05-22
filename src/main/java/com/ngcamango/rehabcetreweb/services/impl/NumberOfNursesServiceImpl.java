/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.services.impl;

import com.ngcamango.rehabcetreweb.domain.Nurse;
import com.ngcamango.rehabcetreweb.repository.NurseRepository;
import com.ngcamango.rehabcetreweb.services.NumberOfNursesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ngcamango
 */
@Service
public class NumberOfNursesServiceImpl implements NumberOfNursesService{
    @Autowired
    private NurseRepository nurseRepository;

    @Override
    public List<Nurse> getTotalNurses() {
        return nurseRepository.findAll();
    }
    
}
