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
public class Admission {
    private String admission;
    
    private Admission(){
        
    }
    
    private Admission(Builder builder){
        admission=builder.admission;
    }
    
    public static class Builder
    {
        private String admission;
        
        public Builder(String admission) {
            this.admission = admission;
        }
        
        public Builder admission(Admission value){
            admission=value.getAdmission();
            return this;
        }
        
        public Admission build()
        {
            return new Admission(this);
        }
    }

    public String getAdmission() {
        return admission;
    }
    
    
}
