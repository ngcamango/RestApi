/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.test.services;

import com.ngcamango.rehabcetreweb.app.config.ConnectionConfig;
import com.ngcamango.rehabcetreweb.domain.ActivityLog;
import com.ngcamango.rehabcetreweb.domain.Admission;
import com.ngcamango.rehabcetreweb.domain.Diet;
import com.ngcamango.rehabcetreweb.domain.Discharge;
import com.ngcamango.rehabcetreweb.domain.Patient;
import com.ngcamango.rehabcetreweb.domain.Registration;
import com.ngcamango.rehabcetreweb.domain.Treatment;
import com.ngcamango.rehabcetreweb.repository.PatientRepository;
import com.ngcamango.rehabcetreweb.services.PatientAgeService;
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
public class PatientAgeServiceTest {
    public static ApplicationContext ctx;
    private PatientAgeService patientAgeService;
    private PatientRepository patientRepository;
    private static Registration reg;
    private static Treatment treatment;
    
    public PatientAgeServiceTest() {
    }
    
    @Test
    public void getPatientAge() {
        patientRepository = ctx.getBean(PatientRepository.class);
        patientAgeService = ctx.getBean(PatientAgeService.class);
        
        List<ActivityLog> activityList = new ArrayList();
        activityList.add(null);
        
        List<Admission> admissionList = new ArrayList();
        admissionList.add(null);
        
        List<Discharge> dischargeList = new ArrayList();
        dischargeList.add(null);
        
        List<Diet> dietList = new ArrayList();
        dietList.add(null);
        
        Patient pat1 = new Patient.Builder("Ngcamango")
                       .surname("Mayekiso")
                       .age(22)
                       .activity(activityList)
                       .admission(admissionList)
                       .diet(dietList)
                       .discharge(dischargeList)
                       .treatmnt(treatment)
                       .registrationFee(reg)
                       .build();
        /*Patient pat2 = new Patient.Builder("mango")
                       .surname("Mayekiso")
                       .age(20)
                       .activity(activityList)
                       .admission(admissionList)
                       .diet(dietList)
                       .discharge(dischargeList)
                       .treatmnt(treatment)
                       .registrationFee(reg)
                       .build();
        Patient pat3 = new Patient.Builder("may")
                       .surname("Mayekiso")
                       .age(16)
                       .activity(activityList)
                       .admission(admissionList)
                       .diet(dietList)
                       .discharge(dischargeList)
                       .treatmnt(treatment)
                       .registrationFee(reg)
                       .build();*/
        
        patientRepository.save(pat1);
        /*patientRepository.save(pat2);
        patientRepository.save(pat3);*/
        
        List<Patient> patients = patientAgeService.getAgeAbove(18);
        
        Assert.assertEquals(patients.size(), 1);
        
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
        reg = new Registration.Builder(2000.00).build();
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
