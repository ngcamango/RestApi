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
public class Bed implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

    public Long getId() {
        return id;
    }

    public String getBedType() {
        return bedType;
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
        if (!(object instanceof Bed)) {
            return false;
        }
        Bed other = (Bed) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ngcamango.rehabcetreweb.domain.Bed[ id=" + id + " ]";
    }
    
}
