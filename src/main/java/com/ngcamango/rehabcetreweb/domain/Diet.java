/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author ngcamango
 */
@Entity
public class Diet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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

    public Long getId() {
        return id;
    }
    
    
    
    public String getDiagnosis() {
        return diagnosis;
    }

    public String getFoodType() {
        return foodType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diet)) {
            return false;
        }
        Diet other = (Diet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ngcamango.rehabcetreweb.domain.Diet[ id=" + id + " ]";
    }
    
}
