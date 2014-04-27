/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.repository;

import com.ngcamango.rehabcetreweb.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ngcamango
 */
public interface PatientRepository extends JpaRepository<Patient, Long>{
    
}
