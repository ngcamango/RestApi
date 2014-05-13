/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author ngcamango
 */
@Entity
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name; 
    private String description;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="department_id")
    private List<Ward> wards;
    @OneToMany
    @JoinColumn(name="department_id")
    private List<Nurse> nurses;
    
    private Department(){
        
    }
    
    private Department(Builder builder){
        name = builder.name;
        description = builder.description;
        wards = builder.wards;
        nurses = builder.nurses;
    }
    
    public static class Builder{
        private String name; 
        private String description;
        private List<Ward> wards; 
        private List<Nurse> nurses;
        
        public Builder(String name) {
            this.name = name;
        }

        public Builder name(String value){
            name=value;
            return this;
        }
        
        public Builder description(String value){
            description=value;
            return this;
        }
        
        public Builder wards(List<Ward> value){
            wards=value;
            return this;
        }
        public Builder nurses(List<Nurse> value){
            nurses=value;
            return this;
        }
        
        public Department build()
        {
            return new Department(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    
    public List<Ward> getWards() {
        return wards;
    }

    public List<Nurse> getNurses() {
        return nurses;
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
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ngcamango.rehabcetreweb.domain.Department[ id=" + id + " ]";
    }
    
}
