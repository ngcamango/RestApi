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
public class Time implements Serializable{
    private int hrs;

    private Time(){
        
    }
    
    private Time(Builder builder){
        hrs=builder.hrs;
    }
    
    public static class Builder
    {
        private int hrs;
        
        public Builder(int hrs) {
            this.hrs = hrs;
        }
        
        public Builder timeElapsed(Time value){
            hrs=value.getHrs();
            return this;
        }
        
        public Time build()
        {
            return new Time(this);
        }
    }
    
    public int getHrs() {
        return hrs;
    }  
    
}
