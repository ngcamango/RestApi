/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.services.impl;

import com.ngcamango.rehabcetreweb.services.PatientProgressService;
import com.ngcamango.rehabcetreweb.domain.Progress;
import com.ngcamango.rehabcetreweb.repository.ProgressRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ngcamango
 */
@Service
public class PatientProgressServiceImpl implements PatientProgressService{
    @Autowired
    private ProgressRepository progressRepository;

    @Override
    public List<Progress> getProgression() {
        return progressRepository.findAll();
    }
    
}
