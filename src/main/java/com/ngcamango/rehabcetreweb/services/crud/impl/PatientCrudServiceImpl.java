/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.services.crud.impl;

import com.ngcamango.rehabcetreweb.domain.Patient;
import com.ngcamango.rehabcetreweb.services.crud.PatientCrudService;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ngcamango
 */
public class PatientCrudServiceImpl implements PatientCrudService{
    
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Patient find(String s) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Patient persist(Patient entity) {

        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Patient merge(Patient entity) {
        return null;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Patient remove(Patient entity) {
        return  null;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<Patient> findAll() {
        return null;
    }
}
