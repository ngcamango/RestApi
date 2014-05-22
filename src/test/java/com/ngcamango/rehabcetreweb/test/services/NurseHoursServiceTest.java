/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.test.services;

import com.ngcamango.rehabcetreweb.app.config.ConnectionConfig;
import com.ngcamango.rehabcetreweb.domain.Nurse;
import com.ngcamango.rehabcetreweb.repository.NurseRepository;
import com.ngcamango.rehabcetreweb.services.AppointmentService;
import com.ngcamango.rehabcetreweb.services.NurseHoursService;
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
public class NurseHoursServiceTest {
    public static ApplicationContext ctx;
    private NurseHoursService nurseService;
    private NurseRepository nurseRepository;
    
    public NurseHoursServiceTest() {
    }
    
    @Test(enabled=false)
    public void getHour() {
        nurseRepository = ctx.getBean(NurseRepository.class);
        
        List<Nurse> nurse = nurseService.getHours(0);
        Assert.assertEquals(nurse.size(), 3);
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
