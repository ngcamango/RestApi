/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.services.impl;

import com.ngcamango.rehabcetreweb.domain.Shift;
import com.ngcamango.rehabcetreweb.repository.ShiftRepository;
import com.ngcamango.rehabcetreweb.services.ShiftService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ngcamango
 */
@Service
public class ShiftServiceImpl implements ShiftService{
    @Autowired
    private ShiftRepository shiftRepository;

    @Override
    public List<Shift> getShiftss(String s) {
         List<Shift> shifts = new ArrayList<>();
        List<Shift> allShifts = shiftRepository.findAll();
        
        for(Shift shift: allShifts)
        {
            if(shift.getShift().equals(s))
            {
                shifts.add(shift);
            }
        }
        return shifts;
    }
    
}
