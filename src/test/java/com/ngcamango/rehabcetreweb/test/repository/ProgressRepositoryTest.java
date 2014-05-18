/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.test.repository;

import com.ngcamango.rehabcetreweb.app.config.ConnectionConfig;
import com.ngcamango.rehabcetreweb.domain.Progress;
import com.ngcamango.rehabcetreweb.repository.ProgressRepository;
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
public class ProgressRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private ProgressRepository repo;
    
    public ProgressRepositoryTest() {
    }

    @Test
    public void createProgress() {
        //Progress progressList = new Progress();
        //progressList.add(null);
        
        repo = ctx.getBean(ProgressRepository.class);
        Progress p1 = new Progress.Builder("Good")
                .build();
        repo.save(p1);
        id = p1.getId();
        Assert.assertNotNull(id);
    }
    
    @Test(dependsOnMethods = "createProgress")
    public void readProgress() {
        repo = ctx.getBean(ProgressRepository.class);
        Progress progress = repo.findOne(id);
        Assert.assertEquals(progress.getProgress(), "Good");
    }
    
    @Test(dependsOnMethods = "readProgress")
    public void updateProgress() {
        repo = ctx.getBean(ProgressRepository.class);
        Progress progress;
        progress = repo.findOne(id);
        progress = new Progress.Builder("Excellent")
                //.beds(bedList)
                .build();
        repo.save(progress);
        
        Progress updateProgress = repo.findOne(id);
        Assert.assertEquals(updateProgress.getProgress(), "Good");
    }
    
    @Test(dependsOnMethods = "updateProgress")
    public void deleteProgress() {
        repo = ctx.getBean(ProgressRepository.class);
        Progress progress = repo.findOne(id);
        repo.delete(progress);
         
        Progress deletedProgress = repo.findOne(id);
         
        Assert.assertNull(deletedProgress);
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
