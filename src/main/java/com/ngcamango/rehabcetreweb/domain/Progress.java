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
public class Progress implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String progress;
    
    private Progress(){
        
    }
    
    private Progress(Builder builder){
        progress=builder.progress;
    }
    
    public static class Builder
    {
        private String progress;
        
        public Builder(String progress) {
            this.progress = progress;
        }
        
        public Builder progress(Progress value){
            progress=value.getProgress();
            return this;
        }
        
        public Progress build()
        {
            return new Progress(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getProgress() {
        return progress;
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
        if (!(object instanceof Progress)) {
            return false;
        }
        Progress other = (Progress) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ngcamango.rehabcetreweb.domain.Progress[ id=" + id + " ]";
    }
    
}
