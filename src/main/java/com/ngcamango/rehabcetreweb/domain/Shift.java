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
public class Shift implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String shift;
    
    private Shift()
    {
        
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

    public Long getId() {
        return id;
    }

    public String getShift() {
        return shift;
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
        if (!(object instanceof Shift)) {
            return false;
        }
        Shift other = (Shift) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ngcamango.rehabcetreweb.domain.Shifts[ id=" + id + " ]";
    }
    
}
