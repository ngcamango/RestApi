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
public class Bed implements Serializable{
    private String bedType;
    
    private Bed(){
        
    }
    
    private Bed(Builder builder){
        bedType=builder.bedType;
    }
    
    public static class Builder
    {
        private String bedType;
        
        public Builder(String bedType) {
            this.bedType = bedType;
        }
        
        public Builder bedType(Bed value){
            bedType=value.getBedType();
            return this;
        }
        
        public Bed build()
        {
            return new Bed(this);
        }
    }

    public String getBedType() {
        return bedType;
    }
}
