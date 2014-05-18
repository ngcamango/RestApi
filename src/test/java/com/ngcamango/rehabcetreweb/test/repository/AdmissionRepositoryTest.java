/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.test.repository;

import com.ngcamango.rehabcetreweb.app.config.ConnectionConfig;
import com.ngcamango.rehabcetreweb.domain.Admission;
import com.ngcamango.rehabcetreweb.repository.AdmissionRepository;
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
public class AdmissionRepositoryTest {
    public static ApplicationContext ctx;
    
    private Long id;
    private AdmissionRepository repo;
    
    public AdmissionRepositoryTest() {
    }

    @Test
    public void createAdmission() {
        
        repo = ctx.getBean(AdmissionRepository.class);
        Admission a1 = new Admission.Builder("22-01-2014")
                            .build();
        repo.save(a1);
        id = a1.getId();
        Assert.assertNotNull(id);
    }
    
    @Test(dependsOnMethods = "createAdmission")
    public void readAdmission() {
        repo = ctx.getBean(AdmissionRepository.class);
        Admission admission = repo.findOne(id);
        Assert.assertEquals(admission.getAdmission(), "22-01-2014");
    }
    
    @Test(dependsOnMethods = "readAdmission")
    public void updateAdmission() {
        repo = ctx.getBean(AdmissionRepository.class);
        Admission admission;
        admission = repo.findOne(id);
        admission = new Admission.Builder("27-01-2014")
                .build();
        repo.save(admission);
        
        Admission updateAdmission = repo.findOne(id);
        Assert.assertEquals(updateAdmission.getAdmission(), "22-01-2014");
    }
    
    @Test(dependsOnMethods = "updateAdmission")
    public void deleteAdmission() {
        repo = ctx.getBean(AdmissionRepository.class);
        Admission admission = repo.findOne(id);
        repo.delete(admission);
         
        Admission deletedAdmission = repo.findOne(id);
         
        Assert.assertNull(deletedAdmission);
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
