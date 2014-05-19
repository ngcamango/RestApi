/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.test.services;

import com.ngcamango.rehabcetreweb.app.config.ConnectionConfig;
import com.ngcamango.rehabcetreweb.domain.Address;
import com.ngcamango.rehabcetreweb.domain.Appointment;
import com.ngcamango.rehabcetreweb.domain.Bill;
import com.ngcamango.rehabcetreweb.domain.NextOfKin;
import com.ngcamango.rehabcetreweb.repository.NextOfKinRepository;
import com.ngcamango.rehabcetreweb.services.AppointmentService;
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
public class AppointmentServiceTest {
    public static ApplicationContext ctx;
    private AppointmentService appointmentService;
    private NextOfKinRepository nextOfKinRepository;
    private static Bill bill;
    private static Address address;
    
    public AppointmentServiceTest() {
    }

    @Test
    public void getAppointments() {
        nextOfKinRepository = ctx.getBean(NextOfKinRepository.class);
        appointmentService = ctx.getBean(AppointmentService.class);
        
        List<Appointment> appointmentList = new ArrayList<>();
        appointmentList.add(null);
        
        NextOfKin n1 = new NextOfKin.Builder("Mel")
                .surname("Hoolahaul")
                .age(36)
                .bill(bill)
                .address(address)
                .relationship("Girlfriend")
                .appointment(appointmentList)
                .build();
        
        nextOfKinRepository.save(n1);
        /*patientRepository.save(pat2);
        patientRepository.save(pat3);*/
        
        List<NextOfKin> nextOfKin = appointmentService.getAppointment("Mel");
        
        Assert.assertEquals(nextOfKin.size(), 1);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
        bill = new Bill.Builder(6500).build();
        address = new Address.Builder("21 Falmouth Rd").build();
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
