/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.presentation.rest;

import com.ngcamango.rehabcetreweb.domain.Diet;
import com.ngcamango.rehabcetreweb.domain.Patient;
import java.util.List;

/**
 *
 * @author ngcamango
 */
@Controller
@RequestMapping(value = "api/patient")
public class PatientRestController {
    
    @RequestMapping(value = "create")
    @ResponseBody
    public String create(@RequestBody Patient patient) {
        System.out.println(" Create the Called ");
        return "";
    }

    @RequestMapping(value = "update")
    @ResponseBody
    public String update(@RequestBody Patient patient) {
        System.out.println(" Update Called ");
        return "";
    }
    
    @RequestMapping(value = "diet/{id}")
    @ResponseBody
    public Patient getPatient(@PathVariable String id) {
        System.out.println(" ID called ");
        return null;
    }
    
    @RequestMapping(value = "diets")
    @ResponseBody
    public List<Patient> getPatients() {
        System.out.println("The DIETS");
        return null;
    }
    
    @RequestMapping(value = "diet/{name}")
    @ResponseBody
    public Patient getPatientByName(@PathVariable String id) {
        System.out.println("The Diet name");
        return null;
    }
}
