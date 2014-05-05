/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.test.repository;

import com.ngcamango.rehabcetreweb.app.config.ConnectionConfig;
import com.ngcamango.rehabcetreweb.domain.ActivityLog;
import com.ngcamango.rehabcetreweb.domain.Admission;
import com.ngcamango.rehabcetreweb.domain.Diet;
import com.ngcamango.rehabcetreweb.domain.Discharge;
import com.ngcamango.rehabcetreweb.domain.Patient;
import com.ngcamango.rehabcetreweb.domain.Registration;
import com.ngcamango.rehabcetreweb.domain.Treatment;
import com.ngcamango.rehabcetreweb.repository.PatientRepository;
import com.ngcamango.rehabcetreweb.services.crud.PatientCrudService;
import java.util.ArrayList;
import java.util.List;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
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
public class PatientRepositoryTest {
    public static ApplicationContext ctx;
    private static Admission admission;
    private static Diet diet;
    private static Discharge discharge;
    private static Treatment treatment;
    private static Registration registrationFee;
    private Long id;
    
    private PatientRepository repo;
    
    public PatientRepositoryTest() {
    }
    
    //@Mock
    //PatientCrudService crudService;

    @Test
    public void createPatient() {
        List<ActivityLog> activityList = new ArrayList<ActivityLog> ();
        activityList.add(null);
        
         
        
        repo = ctx.getBean(PatientRepository.class);
        Patient p1 = new Patient.Builder("Ngcamango")
                .surname("Mayekiso")
                .age(22)
                .activity(activityList)
                .admission(admission)
                .diet(diet)
                .discharge(discharge)
                .treatmnt(treatment)
                .registrationFee(registrationFee)
                .build();
        //Patient returnPatient = crudService.persist(p1);
        //when(crudService.persist(p1)).thenReturn(returnPatient);
        //Mockito.verify(crudService).persist(p1);
        repo.save(p1);
        id = p1.getId();
        Assert.assertNotNull(p1);
    }
    
    @Test(dependsOnMethods = "createPatient")
    public void readPatient() {
        repo = ctx.getBean(PatientRepository.class);
        //Patient p1 = new Patient.Builder("Ngcamango").surname("Mayekiso").build();
        //Patient returnPatient = crudService.find(p1.getSurname());
        //when(crudService.find(p1.getSurname())).thenReturn(returnPatient);
        //Mockito.verify(crudService).find(p1.getSurname());
        Patient patient = repo.findOne(id);
        Assert.assertEquals(patient.getName(), "Ngcamango");
    }
    
    @Test(dependsOnMethods = "readPatient")
    public void updatePatient() {
        repo = ctx.getBean(PatientRepository.class);
        Patient patient;
        patient = repo.findOne(id);
        patient = new Patient.Builder("N").build();
        repo.save(patient);
        
        Patient updatePatient = repo.findOne(id);
        Assert.assertEquals(updatePatient.getName(), "N");
    }
    
    @Test(dependsOnMethods = "updatePatient")
    public void deletePatient() {
        repo = ctx.getBean(PatientRepository.class);
        Patient patient = repo.findOne(id);
        repo.delete(patient);
         
        Patient deletedPatient = repo.findOne(id);
         
        Assert.assertNull(deletedPatient);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
        admission = new Admission.Builder("20-12-2014").build();
        diet = new Diet.Builder("Monday").build();
        discharge = new Discharge.Builder("Friday").build();
        treatment = new Treatment.Builder("Vitamins").build();
        registrationFee = new Registration.Builder(2000.00).build();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        //MockitoAnnotations.initMocks(this);
        //crudService = Mockito.mock(PatientCrudService.class);
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
