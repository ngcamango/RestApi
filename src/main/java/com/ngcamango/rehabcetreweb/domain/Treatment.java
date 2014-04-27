/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author ngcamango
 */
@Embeddable
public class Treatment implements Serializable{
    private String diagnosis;
    private String treatment;
    
    private Treatment(){
        
    }
    
    private Treatment(Builder builder){
        diagnosis=builder.diagnosis;
        treatment=builder.treatment;
    }
    
    public static class Builder
    {
        private String diagnosis;
        private String treatment;
        
        public Builder(String diagnosis) {
            this.diagnosis = diagnosis;
        }
        
        public Builder treatment(String value){
            treatment=value;
            return this;
        }
        
        public Builder treatment(Treatment value){
            diagnosis=value.getDiagnosis();
            treatment=value.getTreatment();
            return this;
        }
        
        public Treatment build()
        {
            return new Treatment(this);
        }
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }
    
    
}
