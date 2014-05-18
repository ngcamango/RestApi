/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.test.repository;

import com.ngcamango.rehabcetreweb.app.config.ConnectionConfig;
import com.ngcamango.rehabcetreweb.domain.Diet;
import com.ngcamango.rehabcetreweb.repository.DietRepository;
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
public class DietRepositoryTest {
    public static ApplicationContext ctx;
    
    private Long id;
    
    private DietRepository repo;
    
    public DietRepositoryTest() {
    }

    @Test
    public void createDiet() {
        
        repo = ctx.getBean(DietRepository.class);
        Diet d1 = new Diet.Builder("Alcoholic")
                            .foodType("Whole wheat and nuts")
                            .build();
        repo.save(d1);
        id = d1.getId();
        Assert.assertNotNull(id);
    }
    
    @Test(dependsOnMethods = "createDiet")
    public void readDiet() {
        repo = ctx.getBean(DietRepository.class);
        Diet diet = repo.findOne(id);
        Assert.assertEquals(diet.getDiagnosis(), "Alcoholic");
    }
    
    @Test(dependsOnMethods = "readDiet")
    public void updateDiet() {
        repo = ctx.getBean(DietRepository.class);
        Diet diet;
        diet = repo.findOne(id);
        diet = new Diet.Builder("Drug addict")
                .foodType("Fruits & Veggies")
                .build();
        repo.save(diet);
        
        Diet updateDiet = repo.findOne(id);
        Assert.assertEquals(updateDiet.getDiagnosis(), "Alcoholic");
    }
    
    @Test(dependsOnMethods = "updateDiet")
    public void deleteDiet() {
        repo = ctx.getBean(DietRepository.class);
        Diet diet = repo.findOne(id);
        repo.delete(diet);
         
        Diet deletedDiet = repo.findOne(id);
         
        Assert.assertNull(deletedDiet);
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
