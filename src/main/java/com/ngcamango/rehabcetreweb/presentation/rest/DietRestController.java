/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.presentation.rest;

import com.ngcamango.rehabcetreweb.domain.Diet;
import java.util.List;

/**
 *
 * @author ngcamango
 */
@Controller
@RequestMapping(value = "api/diet")
public class DietRestController {
    
    @RequestMapping(value = "create")
    @ResponseBody
    public String create(@RequestBody Diet diet) {
        System.out.println(" Create the Called ");
        return "";
    }
    
    @RequestMapping(value = "update")
    @ResponseBody
    public String update(@RequestBody Diet diet) {
        System.out.println(" Update Called ");
        return "";
    }
    
    @RequestMapping(value = "diet/{id}")
    @ResponseBody
    public Diet getDiet(@PathVariable String id) {
        System.out.println(" ID called ");
        return null;
    }
    
    @RequestMapping(value = "diets")
    @ResponseBody
    public List<Diet> getDiets() {
        System.out.println("The DIETS");
        return null;
    }
    
    @RequestMapping(value = "diet/{name}")
    @ResponseBody
    public Diet getDietByName(@PathVariable String diagnosis) {
        System.out.println("The Diet name");
        return null;
    }
}
