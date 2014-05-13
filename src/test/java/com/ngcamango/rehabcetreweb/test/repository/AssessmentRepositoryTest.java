/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.test.repository;

import com.ngcamango.rehabcetreweb.app.config.ConnectionConfig;
import com.ngcamango.rehabcetreweb.domain.Assessment;
import com.ngcamango.rehabcetreweb.domain.Progress;
import com.ngcamango.rehabcetreweb.domain.Time;
import com.ngcamango.rehabcetreweb.repository.AssessmentRepository;
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
public class AssessmentRepositoryTest {
    public static ApplicationContext ctx;
    public static Progress progress;
    public static Time timeElapsed;
    private Long id;
    private AssessmentRepository repo;
    
    public AssessmentRepositoryTest() {
    }
    
    @Test
    public void createAssessment() {
        
        repo = ctx.getBean(AssessmentRepository.class);
        Assessment a1 = new Assessment.Builder("Ngcamango")
                .surname("Mayekiso")
                .age(22)
                .diagnosis("Gamer")
                .progress(progress)
                .timeElapsed(timeElapsed)
                .build();
        repo.save(a1);
        id = a1.getId();
        Assert.assertNotNull(id);
    }
    
    @Test(dependsOnMethods = "createAssessment")
    public void readAssessment() {
        repo = ctx.getBean(AssessmentRepository.class);
        Assessment assessment = repo.findOne(id);
        Assert.assertEquals(assessment.getName(), "Ngcamango");
    }
    
    @Test(dependsOnMethods = "readAssessment")
    public void updateAssessment() {
        repo = ctx.getBean(AssessmentRepository.class);
        Assessment assessment;
        assessment = repo.findOne(id);
        assessment = new Assessment.Builder("N")
                .surname("Mayekiso")
                .age(22)
                .diagnosis("Gamer")
                .progress(progress)
                .timeElapsed(timeElapsed)
                .build();
        repo.save(assessment);
        
        Assessment updateAssessment = repo.findOne(id);
        Assert.assertEquals(updateAssessment.getName(), "Ngcamango");
    }
    
    @Test(dependsOnMethods = "updateAssessment")
    public void deleteAssessment() {
        repo = ctx.getBean(AssessmentRepository.class);
        Assessment assessment = repo.findOne(id);
        repo.delete(assessment);
         
        Assessment deletedAssessment = repo.findOne(id);
         
        Assert.assertNull(deletedAssessment);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
        progress = new Progress.Builder("Good").build();
        timeElapsed = new Time.Builder(01)
                              .build();
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
