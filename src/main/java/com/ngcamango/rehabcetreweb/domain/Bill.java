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
public class Bill implements Serializable{
    private double amount;
    
    private Bill(){
        
    }
    
    private Bill(Builder builder){
        amount=builder.amount;
    }
    
    public static class Builder
    {
        private double amount;
        
        public Builder(double amount) {
            this.amount = amount;
        }
        
        public Builder bill(Bill value){
            amount=value.getAmount();
            return this;
        }
        
        public Bill build()
        {
            return new Bill(this);
        }
    }

    public double getAmount() {
        return amount;
    }
    
    
}
