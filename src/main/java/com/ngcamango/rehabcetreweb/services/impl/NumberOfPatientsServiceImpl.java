/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.services.impl;

import com.ngcamango.rehabcetreweb.domain.Patient;
import com.ngcamango.rehabcetreweb.repository.PatientRepository;
import com.ngcamango.rehabcetreweb.services.NumberOfPatientsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ngcamango
 */
@Service
public class NumberOfPatientsServiceImpl implements NumberOfPatientsService{
    
    @Autowired
    private PatientRepository patientRepository;
    
    @Override
    public List<Patient> getTotalPeople() {
        return patientRepository.findAll();
    }
    
}
