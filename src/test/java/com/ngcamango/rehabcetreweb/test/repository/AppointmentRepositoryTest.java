/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.test.repository;

import com.ngcamango.rehabcetreweb.app.config.ConnectionConfig;
import com.ngcamango.rehabcetreweb.domain.Appointment;
import com.ngcamango.rehabcetreweb.repository.AppointmentRepository;
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
public class AppointmentRepositoryTest {
    public static ApplicationContext ctx;
    
    private Long id;
    private AppointmentRepository repo;
    
    public AppointmentRepositoryTest() {
    }

    @Test
    public void createAppointment() {
        
        repo = ctx.getBean(AppointmentRepository.class);
        Appointment a1 = new Appointment.Builder(1)
                            .build();
        repo.save(a1);
        id = a1.getId();
        Assert.assertNotNull(id);
    }
    
    @Test(dependsOnMethods = "createAppointment")
    public void readAppointment() {
        repo = ctx.getBean(AppointmentRepository.class);
        Appointment appointment = repo.findOne(id);
        Assert.assertEquals(appointment.getHours(), 1);
    }
    
    @Test(dependsOnMethods = "readAppointment")
    public void updateAppointment() {
        repo = ctx.getBean(AppointmentRepository.class);
        Appointment appointment;
        appointment = repo.findOne(id);
        appointment = new Appointment.Builder(2)
                .build();
        repo.save(appointment);
        
        Appointment updateAppointment = repo.findOne(id);
        Assert.assertEquals(updateAppointment.getHours(), 1);
    }
    
    @Test(dependsOnMethods = "updateAppointment")
    public void deleteAppointment() {
        repo = ctx.getBean(AppointmentRepository.class);
        Appointment appointment = repo.findOne(id);
        repo.delete(appointment);
         
        Appointment deletedAppointment = repo.findOne(id);
         
        Assert.assertNull(deletedAppointment);
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
