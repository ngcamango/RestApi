/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.domain;

import java.util.Date;
import javax.persistence.Embeddable;

/**
 *
 * @author ngcamango
 */
@Embeddable
public class Discharge {
    private String discharge;
    
    private Discharge(){
        
    }
    
    private Discharge(Builder builder){
        discharge=builder.discharge;
    }
    
    public static class Builder
    {
        private String discharge;
        
        public Builder(String discharge) {
            this.discharge = discharge;
        }
        
        public Builder discharge(Discharge value){
            discharge=value.getDischarge();
            return this;
        }
        
        public Discharge build()
        {
            return new Discharge(this);
        }
    }

    public String getDischarge() {
        return discharge;
    }
    
    
}
