/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.services.impl;

import com.ngcamango.rehabcetreweb.domain.NextOfKin;
import com.ngcamango.rehabcetreweb.repository.NextOfKinRepository;
import com.ngcamango.rehabcetreweb.services.AppointmentService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ngcamango
 */
@Service 
public class AppointmentServiceImpl implements AppointmentService{
    
    @Autowired
    private NextOfKinRepository nextOfKinRepository;

    @Override
    public List<NextOfKin> getAppointment(String n) {
        List<NextOfKin> nextOfKin = new ArrayList<>();
        List<NextOfKin> allNextOfKin = nextOfKinRepository.findAll();
        
        for(NextOfKin nok: allNextOfKin)
        {
            if(nok.getName().equalsIgnoreCase(n))
            {
                nextOfKin.add(nok);
            }
        }
        return nextOfKin;
    
    }
}
    
