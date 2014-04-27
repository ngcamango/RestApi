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
public class Shift implements Serializable{
    
    private String shift;
    
    private Shift(){
        
    }
    
    private Shift(Builder builder){
        shift=builder.shift;
    }
    
    public static class Builder
    {
        private String shift;
        
        public Builder(String shift) {
            this.shift = shift;
        }
        
        public Builder shift(String value){
            shift=value;
            return this;
        }
        
        public Builder shift(Shift value){
            shift=value.getShift();
            return this;
        }
        
        public Shift build()
        {
            return new Shift(this);
        }
    }

    public String getShift() {
        return shift;
    }
}
