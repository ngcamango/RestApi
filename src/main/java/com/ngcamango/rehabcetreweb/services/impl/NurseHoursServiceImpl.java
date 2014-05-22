/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.services.impl;

import com.ngcamango.rehabcetreweb.domain.Nurse;
import com.ngcamango.rehabcetreweb.repository.NurseRepository;
import com.ngcamango.rehabcetreweb.services.NurseHoursService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ngcamango
 */
@Service
public class NurseHoursServiceImpl implements NurseHoursService{

    @Autowired
    private NurseRepository nurseRepository;
    
    @Override
    public List<Nurse> getHours(double hrs) {
        List<Nurse> nurses = new ArrayList<>();
        List<Nurse> allNurses = nurseRepository.findAll();
        
        for(Nurse nurse: allNurses)
        {
            if(nurse.getHoursWorked() > hrs)
            {
                nurses.add(nurse);
            }
        }
        return nurses;
    }
    
}
