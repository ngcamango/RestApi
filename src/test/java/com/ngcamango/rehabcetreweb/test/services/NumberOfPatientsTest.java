/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.test.services;

import com.ngcamango.rehabcetreweb.domain.Admission;
import com.ngcamango.rehabcetreweb.domain.Diet;
import com.ngcamango.rehabcetreweb.domain.Patient;
import com.ngcamango.rehabcetreweb.repository.DietRepository;
import com.ngcamango.rehabcetreweb.repository.PatientRepository;
import com.ngcamango.rehabcetreweb.services.NumberOfPatientsService;
import com.ngcamango.rehabcetreweb.test.ConnectionConfigTest;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
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
public class NumberOfPatientsTest {
    
    public static ApplicationContext ctx;
    
    private NumberOfPatientsService service;
    private PatientRepository patientRepository;
    private DietRepository dietRepository;
    private Long id;
    
    public NumberOfPatientsTest() {
    }

    /*@Test
     public void total() {
         service = ctx.getBean(NumberOfPatientsService.class);
         List<Patient> patients = service.getTotalPeople();
         
         Assert.assertEquals(patients.size(), 13, " 13 Patients");
     
     }*/
    
    @Test(enabled = false)
    public void testDiet() {
        dietRepository = ctx.getBean(DietRepository.class);
        Diet diet1 = new Diet.Builder("Alcoholic").foodType("Type A").build();
        Diet diet2 = new Diet.Builder("Drug").foodType("Type D").build();

        dietRepository.save(diet1);
        dietRepository.save(diet2);

    }
    
    @Test(dependsOnMethods = "testDiet", enabled = false)
    private void createPatient() {
        dietRepository = ctx.getBean(DietRepository.class);
        patientRepository = ctx.getBean(PatientRepository.class);

        List<Admission> admissions = new ArrayList<>();

        Admission ac1 = new Admission.Builder("1st Admission").build();
        Admission ac2 = new Admission.Builder("2nd Admission").build();
        Admission ac3 = new Admission.Builder("3rd Admission").build();
        admissions.add(ac1);
        admissions.add(ac2);
        admissions.add(ac3);

        List<Diet> diets = dietRepository.findAll();

        Patient patient = new Patient.Builder("Ngcamango")
                .surname("Mayekiso")
                .age(22)
                .admission(admissions)
                .diet(diets)
                .build();

        patientRepository.save(patient);
        id = patient.getId();

        Assert.assertNotNull(patient);
    }
    
    @Test(dependsOnMethods = "createPatient", enabled = false)
    private void readAdmissions() {
        patientRepository = ctx.getBean(PatientRepository.class);
         Patient patient = patientRepository.findOne(id);
      
        List<Admission> admissions = patient.getAdmission();

        for (Admission admission : admissions) {
            System.out.println(" The Admission times are " + admission.getAdmission());

        }
    }
    
    @Test(dependsOnMethods = "readAdmissions", enabled = false)
    private void readDiet() {
        patientRepository = ctx.getBean(PatientRepository.class);
        Patient patient = patientRepository.findOne(id);
        List<Diet> diets = patient.getDiet();
        for (Diet diet : diets) {
            System.out.println("The Diet type is " + diet.getFoodType());

        }

    }
    
    @Test(enabled = false)
    public void total() {
        service = ctx.getBean(NumberOfPatientsService.class);
        List<Patient> people = service.getTotalPeople();

        Assert.assertEquals(people.size(), 13, " 13 People");

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfigTest.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        //patientRepository = ctx.getBean(PatientRepository.class);
        //patientRepository.deleteAll();
    }
}
