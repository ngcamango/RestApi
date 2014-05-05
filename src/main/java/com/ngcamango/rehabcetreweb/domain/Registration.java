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
public class Registration implements Serializable{
    private double registrationFee;
    
    private Registration(){
        
    }
    
    private Registration(Builder builder){
        registrationFee=builder.registrationFee;
    }
    
    public static class Builder
    {
        private double registrationFee;
        
        public Builder(double registrationFee) {
            this.registrationFee = registrationFee;
        }
        
        public Builder registrationFee(Registration value){
            registrationFee=value.getRegistrationFee();
            return this;
        }
        
        public Registration build()
        {
            return new Registration(this);
        }
    }

    public double getRegistrationFee() {
        return registrationFee;
    }
}
