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
public class Address implements Serializable{
    private String address;
    
    private Address(){
        
    }
    
    private Address(Builder builder){
        address=builder.address;
    }
    
    public static class Builder
    {
        private String address;
        
        public Builder(String address) {
            this.address = address;
        }
        
        public Builder address(Address value){
            address=value.getAddress();
            return this;
        }
        
        public Address build()
        {
            return new Address(this);
        }
    }

    public String getAddress() {
        return address;
    }
}
