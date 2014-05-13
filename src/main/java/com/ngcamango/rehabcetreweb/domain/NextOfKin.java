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
public class NextOfKin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private int age;
    @Embedded
    private Bill bill;
    @Embedded
    private Address address;
    private String relationship;
    @OneToMany
    @JoinColumn(name="nextofkin_id")
    private List<Appointment> appointment;

    private NextOfKin(){
        
    }
    
    private NextOfKin(Builder builder){
        name = builder.name;
        surname = builder.surname;
        age =  builder.age;
        bill =  builder.bill;
        address =  builder.address;
        relationship = builder.relationship;
        appointment = builder.appointment;
    } 
    
    public static class Builder{
        private String name;
        private String surname;
        private int age;
        private Bill bill;
        private Address address;
        private String relationship;
        private List<Appointment> appointment;
        
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
        
        public Builder bill(Bill value){
            bill=value;
            return this;
        }
        
        public Builder address(Address value){
            address=value;
            return this;
        }
        
        public Builder relationship(String value){
            relationship=value;
            return this;
        }
        
        public Builder appointment(List<Appointment> value){
            appointment=value;
            return this;
        }
        
        public Builder nextOfKin(NextOfKin value){
            name=value.getName();
            surname= value.getSurname();
            age=value.getAge();
            bill=value.getBill();
            address=value.getAddress();
            relationship=value.getRelationship();
            appointment=value.getAppointment();
            return this;
        }
        
        public NextOfKin build()
        {
            return new NextOfKin(this);
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

    public Bill getBill() {
        return bill;
    }
    
    public Address getAddress() {
        return address;
    }

    public String getRelationship() {
        return relationship;
    }

    public List<Appointment> getAppointment() {
        return appointment;
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
        if (!(object instanceof NextOfKin)) {
            return false;
        }
        NextOfKin other = (NextOfKin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ngcamango.rehabcetreweb.domain.NextOfKin[ id=" + id + " ]";
    }
    
}
