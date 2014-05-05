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
    private int hr;
    private int min;
    private int sec;

    private Time(){
        
    }
    
    private Time(Builder builder){
        hr=builder.hr;
        min=builder.min;
        sec=builder.sec;
    }
    
    public static class Builder
    {
        private int hr;
        private int min;
        private int sec;
        
        public Builder(int hr) {
            this.hr = hr;
        }
        
        public Builder min(int value){
            min=value;
            return this;
        }
        
        public Builder sec(int value){
            sec=value;
            return this;
        }
        
        public Builder timeElapsed(Time value){
            hr=value.getHr();
            min=value.getMin();
            sec=value.getSec();
            return this;
        }
        
        public Time build()
        {
            return new Time(this);
        }
    }
    
    public int getHr() {
        return hr;
    }

    public int getMin() {
        return min;
    }

    public int getSec() {
        return sec;
    }
    
    
}
