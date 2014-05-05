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
public class Diet implements Serializable{
    private String diagnosis;
    private String foodType;
    
    private Diet(){
        
    }
    
    private Diet(Builder builder){
        diagnosis=builder.diagnosis;
        foodType=builder.foodType;
    }
    
    public static class Builder
    {
        private String diagnosis;
        private String foodType;
        
        public Builder(String diagnosis) {
            this.diagnosis = diagnosis;
        }
        
        public Builder foodType(String value){
            foodType=value;
            return this;
        }
        
        public Builder diet(Diet value){
            diagnosis=value.getDiagnosis();
            foodType=value.getFoodType();
            return this;
        }
        
        public Diet build()
        {
            return new Diet(this);
        }
    }
    
    public String getDiagnosis() {
        return diagnosis;
    }

    public String getFoodType() {
        return foodType;
    }
}
