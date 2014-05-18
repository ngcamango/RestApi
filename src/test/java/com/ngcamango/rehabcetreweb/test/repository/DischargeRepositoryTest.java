/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.test.repository;

import com.ngcamango.rehabcetreweb.app.config.ConnectionConfig;
import com.ngcamango.rehabcetreweb.domain.Discharge;
import com.ngcamango.rehabcetreweb.repository.DischargeRepository;
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
public class DischargeRepositoryTest {
    public static ApplicationContext ctx;
    
    private Long id;
    private DischargeRepository repo;
    
    public DischargeRepositoryTest() {
    }

    @Test
    public void createDischarge() {
        
        repo = ctx.getBean(DischargeRepository.class);
        Discharge d1 = new Discharge.Builder("22-02-2014")
                            .build();
        repo.save(d1);
        id = d1.getId();
        Assert.assertNotNull(id);
    }
    
    @Test(dependsOnMethods = "createDischarge")
    public void readDischarge() {
        repo = ctx.getBean(DischargeRepository.class);
        Discharge discharge = repo.findOne(id);
        Assert.assertEquals(discharge.getDischarge(), "22-02-2014");
    }
    
    @Test(dependsOnMethods = "readDischarge")
    public void updateDischarge() {
        repo = ctx.getBean(DischargeRepository.class);
        Discharge discharge;
        discharge = repo.findOne(id);
        discharge = new Discharge.Builder("27-02-2014")
                .build();
        repo.save(discharge);
        
        Discharge updateDischarge = repo.findOne(id);
        Assert.assertEquals(updateDischarge.getDischarge(), "22-02-2014");
    }
    
    @Test(dependsOnMethods = "updateDischarge")
    public void deleteDischarge() {
        repo = ctx.getBean(DischargeRepository.class);
        Discharge discharge = repo.findOne(id);
        repo.delete(discharge);
         
        Discharge deletedDischarge = repo.findOne(id);
         
        Assert.assertNull(deletedDischarge);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
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
