/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.services.impl;

import com.ngcamango.rehabcetreweb.domain.Patient;
import com.ngcamango.rehabcetreweb.repository.PatientRepository;
import com.ngcamango.rehabcetreweb.services.PatientAgeService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ngcamango
 */
@Service 
public class PatientAgeServiceImpl implements PatientAgeService{

    @Autowired
    private PatientRepository patientRepository;
    
    @Override
    public List<Patient> getAgeAbove(int i) {
        List<Patient> patients = new ArrayList<>();
        List<Patient> allPatients = patientRepository.findAll();
        
        for(Patient patient: allPatients)
        {
            if(patient.getAge() > i)
            {
                patients.add(patient);
            }
        }
        return patients;
    }
    
}
