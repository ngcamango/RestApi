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
public class ActivityLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private int age;
    private String diagnosis;
    private String activity;
    
    private ActivityLog(){
        
    }
    
    private ActivityLog(Builder builder){
        id=builder.id;
        name=builder.name;
        surname=builder.surname;
        age=builder.age;
        diagnosis=builder.diagnosis;
        activity=builder.activity;
    }
    
    public static class Builder
    {
        private Long id;
        private int age;
        private String name;
        private String surname;
        private String diagnosis;
        private String activity;
        
        public Builder(String name) {
            this.name = name;
        }
        
        public Builder id(Long value){
            id=value;
            return this;
        }

        public Builder surname(String value){
            surname=value;
            return this;
        }

        public Builder age(int value){
            age=value;
            return this;
        }
        
        public Builder diagnosis(String value){
            diagnosis=value;
            return this;
        }
        
        public Builder activity(String value){
            activity=value;
            return this;
        }
        
        public Builder activityLog(ActivityLog value){
            id=value.getId();
            name=value.getName();
            surname= value.getSurname();
            age=value.getAge();
            diagnosis=value.getDiagnosis();
            activity=value.getActivity();
            return this;
        }
        
        public ActivityLog build()
        {
            return new ActivityLog(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getActivity() {
        return activity;
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
        if (!(object instanceof ActivityLog)) {
            return false;
        }
        ActivityLog other = (ActivityLog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ngcamango.rehabcetreweb.domain.ActivityLog[ id=" + id + " ]";
    }
    
}
