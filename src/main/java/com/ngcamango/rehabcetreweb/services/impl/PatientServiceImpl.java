/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.services.impl;

import com.ngcamango.rehabcetreweb.domain.Patient;
import com.ngcamango.rehabcetreweb.repository.PatientRepository;
import com.ngcamango.rehabcetreweb.services.PatientService;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author ngcamango
 */
@Service
public class PatientServiceImpl implements PatientService{
    @Autowired
    private PatientRepository patientRepository;
    
    @Override
    public Patient find(Long id) {
        return patientRepository.findOne(id);
    }
    
    @Override
    public Patient persist(Patient entity) {
        return patientRepository.save(entity);
    }
    
    @Override
    public Patient merge(Patient entity) {
        if (entity.getId()!=null) {
            return patientRepository.save(entity);
        }
        return null;
        }
    
    @Override
    public void remove(Patient entity) {
    
        patientRepository.delete(entity);
    }
    
    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }
}
