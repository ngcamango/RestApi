/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.test.repository;

import com.ngcamango.rehabcetreweb.app.config.ConnectionConfig;
import com.ngcamango.rehabcetreweb.domain.Shift;
import com.ngcamango.rehabcetreweb.repository.ShiftRepository;
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
public class ShiftRepositoryTest {
    private static ApplicationContext ctx;
    private Long id;
    private ShiftRepository repo;
    
    public ShiftRepositoryTest() {
    }

    @Test
    public void createShift() {
        
        repo = ctx.getBean(ShiftRepository.class);
        Shift s1 = new Shift.Builder("Early Shift")
                .build();
        repo.save(s1);
        id = s1.getId();
        Assert.assertNotNull(id);
    }
    
    @Test(dependsOnMethods = "createShift")
    public void readShift() {
        repo = ctx.getBean(ShiftRepository.class);
        Shift shift = repo.findOne(id);
        Assert.assertEquals(shift.getShift(), "Early Shift");
    }
    
    @Test(dependsOnMethods = "readShift")
    public void updateShift() {
        repo = ctx.getBean(ShiftRepository.class);
        Shift shift;
        shift = repo.findOne(id);
        shift = new Shift.Builder("Night Shift")
                .build();
        repo.save(shift);
        
        Shift updateNurse = repo.findOne(id);
        Assert.assertEquals(updateNurse.getShift(), "Early Shift");
    }
    
    @Test(dependsOnMethods = "updateShift")
    public void deleteShift() {
        repo = ctx.getBean(ShiftRepository.class);
        Shift shift = repo.findOne(id);
        repo.delete(shift);
         
        Shift deletedShift = repo.findOne(id);
         
        Assert.assertNull(deletedShift);
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
