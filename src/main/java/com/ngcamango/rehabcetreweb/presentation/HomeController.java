/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.presentation;

import com.ngcamango.rehabcetreweb.domain.Patient;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ngcamango
 */
@Controller
public class HomeController {
    
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getIndex(){
        return "index";
    }
    
    @RequestMapping(value = "/rest",method = RequestMethod.GET)
    @ResponseBody
    public List<Patient> getRndex(){
        List<Patient> patients = new ArrayList<>();
        Patient p1 = new Patient.Builder("Ngcamango")
                .age(5).build();
        Patient p2 = new Patient.Builder("Ngca")
                .age(12).build();
        Patient p3 = new Patient.Builder("Mango")
                .age(16).build();
        patients.add(p3);
        patients.add(p1);
        patients.add(p2);
        
        return patients;
    }
}
