/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author ngcamango
 */
@Embeddable
public class Progress implements Serializable{
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

    public String getProgress() {
        return progress;
    }
    
    
}
