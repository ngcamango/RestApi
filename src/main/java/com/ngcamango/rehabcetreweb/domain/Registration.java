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
public class Registration implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

    public Long getId() {
        return id;
    }

    public double getRegistrationFee() {
        return registrationFee;
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
        if (!(object instanceof Registration)) {
            return false;
        }
        Registration other = (Registration) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ngcamango.rehabcetreweb.domain.Registration[ id=" + id + " ]";
    }
    
}
