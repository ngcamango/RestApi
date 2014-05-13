/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.test.repository;

import com.ngcamango.rehabcetreweb.app.config.ConnectionConfig;
import com.ngcamango.rehabcetreweb.domain.Address;
import com.ngcamango.rehabcetreweb.domain.Appointment;
import com.ngcamango.rehabcetreweb.domain.Bill;
import com.ngcamango.rehabcetreweb.domain.NextOfKin;
import com.ngcamango.rehabcetreweb.repository.NextOfKinRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author ngcamango
 */
public class NextOfKinRepositoryTest {
    private static ApplicationContext ctx;
    private static Bill bill;
    private static Address address;
    private Long id;
    private NextOfKinRepository repo;
    
    public NextOfKinRepositoryTest() {
    }

    @Test
    public void createNextOfKin() {
        List<Appointment> appointmentList = new ArrayList();
        appointmentList.add(null);
        
         
        
        repo = ctx.getBean(NextOfKinRepository.class);
        NextOfKin n1 = new NextOfKin.Builder("Melissa")
                .surname("Hoolahaul")
                .age(36)
                .bill(bill)
                .address(address)
                .relationship("Girlfriend")
                .appointment(appointmentList)
                .build();
        repo.save(n1);
        id = n1.getId();
        Assert.assertNotNull(id);
    }
    
    @Test(dependsOnMethods = "createNextOfKin")
    public void readNextOfKin() {
        repo = ctx.getBean(NextOfKinRepository.class);
        NextOfKin nextOfKin = repo.findOne(id);
        Assert.assertEquals(nextOfKin.getName(), "Melissa");
    }
    
    @Test(dependsOnMethods = "readNextOfKin")
    public void updateNextOfKin() {
        repo = ctx.getBean(NextOfKinRepository.class);
        NextOfKin nextOfKin;
        nextOfKin = repo.findOne(id);
        nextOfKin = new NextOfKin.Builder("Olivia")
                .surname("Benjamin")
                .age(33)
                .bill(bill)
                .address(address)
                .relationship("Girlfriend")
                //.appointment(appointmentList)
                .build();
        repo.save(nextOfKin);
        
        NextOfKin updateNextOfKin = repo.findOne(id);
        Assert.assertEquals(updateNextOfKin.getName(), "Melissa");
    }
    
    @Test(dependsOnMethods = "updateNextOfKin")
    public void deleteNextOfKin() {
        repo = ctx.getBean(NextOfKinRepository.class);
        NextOfKin nextOfKin = repo.findOne(id);
        repo.delete(nextOfKin);
         
        NextOfKin deletedNextOfKin = repo.findOne(id);
         
        Assert.assertNull(deletedNextOfKin);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
        bill = new Bill.Builder(5000.00).build();
        address = new Address.Builder("21 Jump Street").build();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
