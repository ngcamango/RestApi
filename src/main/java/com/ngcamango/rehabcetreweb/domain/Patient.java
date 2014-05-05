/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Embedded;
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
public class Patient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private int age;
    @Embedded
    private Registration registrationFee;
    @Embedded
    private Admission admission;
    @Embedded
    private Discharge discharge;
    @Embedded
    private Treatment treatmnt;
    @Embedded
    private Diet diet;
    @OneToMany
    @JoinColumn(name="patient_id")
    private List<ActivityLog> activity;
    
    private Patient()
    {
        
    }
    
    private Patient(Builder builder)
    {
        id=builder.id;
        name=builder.name;
        surname= builder.surname;
        age=builder.age;
        registrationFee=builder.registrationFee;
        admission=builder.admission;
        discharge=builder.discharge;
        treatmnt=builder.treatmnt;
        diet=builder.diet;
        activity=builder.activity;
    }
    
    public static class Builder
    {
        private Long id;
        private String name;
        private String surname;
        private int age;
        private Registration registrationFee;
        private Admission admission;
        private Discharge discharge;
        private Treatment treatmnt;
        private Diet diet;
        private List<ActivityLog> activity;
        
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
        
        public Builder registrationFee(Registration value){
            registrationFee=value;
            return this;
        }
        
        public Builder admission(Admission value){
            admission=value;
            return this;
        }
        
        public Builder discharge(Discharge value){
            discharge=value;
            return this;
        }
        
        public Builder treatmnt(Treatment value){
            treatmnt=value;
            return this;
        }
        
        public Builder diet(Diet value){
            diet=value;
            return this;
        }
        
        public Builder activity(List<ActivityLog> value){
            activity=value;
            return this;
        }
        
        public Builder patient(Patient value){
            id=value.getId();
            name=value.getName();
            surname= value.getSurname();
            age=value.getAge();
            registrationFee=value.getRegistrationFee();
            admission=value.getAdmission();
            discharge=value.getDischarge();
            treatmnt=value.getTreatmnt();
            diet=value.getDiet();
            activity=value.getActivity();
            return this;
        }
        
        public Patient build()
        {
            return new Patient(this);
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

    public Registration getRegistrationFee() {
        return registrationFee;
    }

    public Admission getAdmission() {
        return admission;
    }

    public Discharge getDischarge() {
        return discharge;
    }

    public Treatment getTreatmnt() {
        return treatmnt;
    }
    
    public Diet getDiet() {
        return diet;
    }

    public List<ActivityLog> getActivity() {
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
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ngcamango.rehabcetreweb.domain.Patient[ id=" + id + " ]";
    }
    
}
