/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.presentation;

import com.ngcamango.rehabcetreweb.domain.Patient;
import com.ngcamango.rehabcetreweb.services.NumberOfPatientsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ngcamango
 */
@Controller
public class RehabController {
    @Autowired
    private NumberOfPatientsService numberOfPatientsService;
    @RequestMapping(value = "rehab",method = RequestMethod.GET)
    public String getHome(){
        
        List<Patient> patients = numberOfPatientsService.getTotalPeople();
        System.out.println(" The Rehab COntroller was hit" +patients.size());
        
        return "rehab";
    }
    @RequestMapping(value = "rehab/patients",method = RequestMethod.GET)
     public String getPatients(Model model){
        
        
        model.addAttribute("name1", "This is a Patient Name");
        
        return "patients";
    }
}
