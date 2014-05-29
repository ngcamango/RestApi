/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.test.repository;

import com.ngcamango.rehabcetreweb.test.ConnectionConfigTest;
import com.ngcamango.rehabcetreweb.domain.ActivityLog;
import com.ngcamango.rehabcetreweb.domain.Admission;
import com.ngcamango.rehabcetreweb.domain.Diet;
import com.ngcamango.rehabcetreweb.domain.Discharge;
import com.ngcamango.rehabcetreweb.domain.Patient;
import com.ngcamango.rehabcetreweb.domain.Registration;
import com.ngcamango.rehabcetreweb.domain.Treatment;
import com.ngcamango.rehabcetreweb.repository.PatientRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author ngcamango
 */
public class PatientRepositoryTest {
    public static ApplicationContext ctx;
    private static Treatment treatment;
    private static Registration registrationFee;
    private Long id;
    
    private PatientRepository repo;
    
    public PatientRepositoryTest() {
    }

    @Test (enabled = true)
    public void createPatient() {
        List<ActivityLog> activityList = new ArrayList();
        activityList.add(null);
        
        List<Admission> admissionList = new ArrayList();
        admissionList.add(null);
        
        List<Discharge> dischargeList = new ArrayList();
        dischargeList.add(null);
        
        List<Diet> dietList = new ArrayList();
        dietList.add(null);
        
        repo = ctx.getBean(PatientRepository.class);
        Patient p1 = new Patient.Builder("Ngcamango")
                .surname("Mayekiso")
                .age(22)
                .activity(activityList)
                .admission(admissionList)
                .diet(dietList)
                .discharge(dischargeList)
                .treatmnt(treatment)
                .registrationFee(registrationFee)
                .build();
        repo.save(p1);
        id = p1.getId();
        Assert.assertNotNull(id);
    }
    
    @Test(dependsOnMethods = "createPerson", enabled = true)
    public void readPatient() {
        repo = ctx.getBean(PatientRepository.class);
        Patient patient = repo.findOne(id);
        Assert.assertEquals(patient.getName(), "Ngcamango");
    }
    
    @Test(dependsOnMethods = "readPerson", enabled = true)
    public void updatePatient() {
        repo = ctx.getBean(PatientRepository.class);
        Patient patient;
        patient = repo.findOne(id);
        patient = new Patient.Builder("N")
                .surname("Mayekiso")
                .age(22)
                //.activity(activityList)
                //.admission(admission)
                //.diet(dietList)
                //.discharge(dischargeList)
                .treatmnt(treatment)
                .registrationFee(registrationFee)
                .build();
        repo.save(patient);
        
        Patient updatePatient = repo.findOne(id);
        Assert.assertEquals(updatePatient.getName(), "Ngcamango");
    }
    
    @Test(dependsOnMethods = "updatePerson",enabled = true)
    public void deletePatient() {
        repo = ctx.getBean(PatientRepository.class);
        Patient patient = repo.findOne(id);
        repo.delete(patient);
         
        Patient deletedPatient = repo.findOne(id);
         
        Assert.assertNull(deletedPatient);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfigTest.class);
        treatment = new Treatment.Builder("Vitamins").build();
        registrationFee = new Registration.Builder(2000.00).build();
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
