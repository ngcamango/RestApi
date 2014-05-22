/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.services.impl;

import com.ngcamango.rehabcetreweb.domain.NextOfKin;
import com.ngcamango.rehabcetreweb.repository.NextOfKinRepository;
import com.ngcamango.rehabcetreweb.services.NextOfKinService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ngcamango
 */
@Service
public class NextOfKinServiceImpl implements NextOfKinService{
    @Autowired
    private NextOfKinRepository nextOfKinRepository;

    @Override
    public List<NextOfKin> getTotal() {
        return nextOfKinRepository.findAll();
    }
    
}
