/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.domain;

import java.io.Serializable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author ngcamango
 */
@Entity
public class Assessment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private int age;
    private String diagnosis;
    @Embedded
    private Progress progress;
    @Embedded
    private Time timeElapsed;

    private Assessment(){
        
    }
    
    private Assessment(Builder builder){
        name=builder.name;
        surname=builder.surname;
        age=builder.age;
        diagnosis=builder.diagnosis;
        progress=builder.progress;
        timeElapsed=builder.timeElapsed;
    }
    
    public static class Builder
    {
        private String name;
        private String surname;
        private int age;
        private String diagnosis;
        private Progress progress;
        private Time timeElapsed;
        
        public Builder(String name) {
            this.name = name;
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
        
        public Builder progress(Progress value){
            progress=value;
            return this;
        }
        
        public Builder timeElapsed(Time value){
            timeElapsed=value;
            return this;
        }
        
        public Builder assessment(Assessment value){
            name=value.getName();
            surname= value.getSurname();
            age=value.getAge();
            diagnosis=value.getDiagnosis();
            progress=value.getProgress();
            timeElapsed=value.getTimeElapsed();
            return this;
        }
        
        public Assessment build()
        {
            return new Assessment(this);
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

    public Progress getProgress() {
        return progress;
    }

    public Time getTimeElapsed() {
        return timeElapsed;
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
        if (!(object instanceof Assessment)) {
            return false;
        }
        Assessment other = (Assessment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ngcamango.rehabcetreweb.domain.Assessment[ id=" + id + " ]";
    }
    
}
