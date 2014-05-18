/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.test.repository;

import com.ngcamango.rehabcetreweb.app.config.ConnectionConfig;
import com.ngcamango.rehabcetreweb.domain.Treatment;
import com.ngcamango.rehabcetreweb.repository.TreatmentRepository;
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
public class TreatmentRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private TreatmentRepository repo;
    
    public TreatmentRepositoryTest() {
    }

    @Test
    public void createTreatment() {
        
        repo = ctx.getBean(TreatmentRepository.class);
        Treatment t1 = new Treatment.Builder("Anti-biotics")
                .build();
        repo.save(t1);
        id = t1.getId();
        Assert.assertNotNull(id);
    }
    
    @Test(dependsOnMethods = "createTreatment")
    public void readTreatment() {
        repo = ctx.getBean(TreatmentRepository.class);
        Treatment tr = repo.findOne(id);
        Assert.assertEquals(tr.getTreatment(), "Anti-biotics");
    }
    
    @Test(dependsOnMethods = "readTreatment")
    public void updateTreatment() {
        repo = ctx.getBean(TreatmentRepository.class);
        Treatment tr;
        tr = repo.findOne(id);
        tr = new Treatment.Builder("Vitamins")
                .build();
        repo.save(tr);
        
        Treatment updateTreatment = repo.findOne(id);
        Assert.assertEquals(updateTreatment.getTreatment(), "Anti-biotics");
    }
    
    @Test(dependsOnMethods = "updateTreatment")
    public void deleteTreatment() {
        repo = ctx.getBean(TreatmentRepository.class);
        Treatment tr = repo.findOne(id);
        repo.delete(tr);
         
        Treatment deletedTreatment = repo.findOne(id);
         
        Assert.assertNull(deletedTreatment);
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
