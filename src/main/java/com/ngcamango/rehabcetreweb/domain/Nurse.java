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
public class Nurse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private int age;
    private double hoursWorked;
    private double salary;
    @OneToMany
    @JoinColumn(name="nurse_id")
    private List<Shift> shift;
    @OneToMany
    @JoinColumn(name="nurse_id")
    private List<Patient> patients;
    
    private Nurse()
    {
        
    }
    
    private Nurse(Builder builder)
    {
        id=builder.id;
        name=builder.name;
        surname= builder.surname;
        age=builder.age;
        hoursWorked=builder.hoursWorked;
        salary=builder.salary;
        shift=builder.shift;
        patients=builder.patients;
    }
    
    public static class Builder
    {
        private Long id;
        private String name;
        private String surname;
        private int age;
        private double hoursWorked;
        private double salary;
        private List<Shift> shift;
        private List<Patient> patients;
        
        public Builder(double hoursWorked) {
            this.hoursWorked = hoursWorked;
        }
        
        public Builder id(Long value) {
            id=value;
            return this;
         }
        
        public Builder name(String value) {
            name=value;
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
        
        public Builder salary(double value){
            salary=value;
            return this;
        }
        
        public Builder shift(List<Shift> value){
            shift=value;
            return this;
        }
        
        public Builder patients(Patient value) {
            patients=(List<Patient>) value;
            return this;
         }
        
        public Builder nurse(Nurse value){
            id = value.getId();
            name = value.getName();
            surname = value.getSurname();
            age = value.getAge();
            hoursWorked = value.getHoursWorked();
            salary = value.getSalary();
            shift = value.getShift();
            patients = value.getPatients();
            return this;
        }
        
        public Nurse build()
        {
            return new Nurse(this);
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

    public double getHoursWorked() {
        return hoursWorked;
    }

    public double getSalary() {
        return salary;
    }
    
    public List<Shift> getShift() {
        return shift;
    }

    public List<Patient> getPatients() {
        return patients;
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
        if (!(object instanceof Nurse)) {
            return false;
        }
        Nurse other = (Nurse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ngcamango.rehabcetreweb.domain.Nurse[ id=" + id + " ]";
    }
    
}
