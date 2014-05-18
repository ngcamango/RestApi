/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.test.repository;

import com.ngcamango.rehabcetreweb.app.config.ConnectionConfig;
import com.ngcamango.rehabcetreweb.domain.Bed;
import com.ngcamango.rehabcetreweb.repository.BedRepository;
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
public class BedRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private BedRepository repo;
    
    public BedRepositoryTest() {
    }

    @Test
    public void createBed() {
        
        repo = ctx.getBean(BedRepository.class);
        Bed b1 = new Bed.Builder("Single")
                            .build();
        repo.save(b1);
        id = b1.getId();
        Assert.assertNotNull(id);
    }
    
    @Test(dependsOnMethods = "createBed")
    public void readBed() {
        repo = ctx.getBean(BedRepository.class);
        Bed bed = repo.findOne(id);
        Assert.assertEquals(bed.getBedType(), "Single");
    }
    
    @Test(dependsOnMethods = "readBed")
    public void updateBed() {
        repo = ctx.getBean(BedRepository.class);
        Bed bed;
        bed = repo.findOne(id);
        bed = new Bed.Builder("Double")
                .build();
        repo.save(bed);
        
        Bed updateBed = repo.findOne(id);
        Assert.assertEquals(updateBed.getBedType(), "Single");
    }
    
    @Test(dependsOnMethods = "updateBed")
    public void deleteBed() {
        repo = ctx.getBean(BedRepository.class);
        Bed bed = repo.findOne(id);
        repo.delete(bed);
         
        Bed deletedBed = repo.findOne(id);
         
        Assert.assertNull(deletedBed);
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
