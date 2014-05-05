/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.domain;

import java.io.Serializable;
import java.util.List;
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
public class Ward implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String wardName;
    private String wardDescription;
    @OneToMany
    @JoinColumn(name="ward_id")
    private List<Room> rooms;
    
    private Ward(){
        
    }
    
    private Ward(Builder builder){
        wardName = builder.wardName;
        wardDescription = builder.wardDescription;
        rooms = builder.rooms;
    }
    
    public static class Builder{
        private String wardName;
        private String wardDescription;
        private List<Room> rooms;
        
        public Builder(String wardName){
            this.wardName = wardName;
        }
        
        public Builder wardDescription(String value){
            wardDescription = value;
            return this;
        }
        
        public Builder rooms(List<Room> value){
            rooms = value;
            return this;
        }
        
        public Builder ward(Ward value){
            wardName = value.getWardName();
            wardDescription = value.getWardDescription();
            rooms = value.getRooms();
            return this;
        }
        
        public Ward build(){
            return new Ward(this);
        }
                
    }
        
    public Long getId() {
        return id;
    }

    public String getWardName() {
        return wardName;
    }

    public String getWardDescription() {
        return wardDescription;
    }

    public List<Room> getRooms() {
        return rooms;
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
        if (!(object instanceof Ward)) {
            return false;
        }
        Ward other = (Ward) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ngcamango.rehabcetreweb.domain.Ward[ id=" + id + " ]";
    }
    
}
