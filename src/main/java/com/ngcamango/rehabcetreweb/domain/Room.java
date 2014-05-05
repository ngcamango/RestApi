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

/**
 *
 * @author ngcamango
 */
@Entity
public class Room implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private int roomNo;
    @Embedded
    private List<Bed> beds;
    
    private Room(){
        
    }
    
    private Room(Builder builder){
        roomNo = builder.roomNo;
        beds = builder.beds;
    }
    
    public static class Builder{
        private int roomNo;
        private List<Bed> beds;
        
        public Builder(int roomNo){
            this.roomNo = roomNo;
        }
        
        public Builder beds(List<Bed> beds){
            this.beds = beds;
            return this;
        }
        
        public Builder roomNo(Room value){
            roomNo = value.getRoomNo();
            beds = value.getBeds();
            return this;
        }
        
        public Room build(){
            return new Room(this);
        }
                
    }

    public Long getId() {
        return id;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public List<Bed> getBeds() {
        return beds;
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
        if (!(object instanceof Room)) {
            return false;
        }
        Room other = (Room) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ngcamango.rehabcetreweb.domain.Room[ id=" + id + " ]";
    }
    
}
