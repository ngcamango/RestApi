/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.test.repository;

import com.ngcamango.rehabcetreweb.app.config.ConnectionConfig;
import com.ngcamango.rehabcetreweb.domain.Registration;
import com.ngcamango.rehabcetreweb.repository.RegistrationRepository;
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
public class RegistrationRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private RegistrationRepository repo;
    
    public RegistrationRepositoryTest() {
    }

    @Test
    public void createRegistration() {
        //Progress progressList = new Progress();
        //progressList.add(null);
        
        repo = ctx.getBean(RegistrationRepository.class);
        Registration r1 = new Registration.Builder(2000.00)
                .build();
        repo.save(r1);
        id = r1.getId();
        Assert.assertNotNull(id);
    }
    
    @Test(dependsOnMethods = "createRegistration")
    public void readRegistration() {
        repo = ctx.getBean(RegistrationRepository.class);
        Registration reg = repo.findOne(id);
        Assert.assertEquals(reg.getRegistrationFee(), 2000.00);
    }
    
    @Test(dependsOnMethods = "readRegistration")
    public void updateRegistration() {
        repo = ctx.getBean(RegistrationRepository.class);
        Registration reg;
        reg = repo.findOne(id);
        reg = new Registration.Builder(1000.00)
                //.beds(bedList)
                .build();
        repo.save(reg);
        
        Registration updateRegistration = repo.findOne(id);
        Assert.assertEquals(updateRegistration.getRegistrationFee(), 2000.00);
    }
    
    @Test(dependsOnMethods = "updateRegistration")
    public void deleteRegistration() {
        repo = ctx.getBean(RegistrationRepository.class);
        Registration reg = repo.findOne(id);
        repo.delete(reg);
         
        Registration deletedRegistration = repo.findOne(id);
         
        Assert.assertNull(deletedRegistration);
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
