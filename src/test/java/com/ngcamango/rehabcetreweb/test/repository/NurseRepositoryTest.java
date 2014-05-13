/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.test.repository;

import com.ngcamango.rehabcetreweb.app.config.ConnectionConfig;
import com.ngcamango.rehabcetreweb.domain.Nurse;
import com.ngcamango.rehabcetreweb.domain.Shift;
import com.ngcamango.rehabcetreweb.repository.NurseRepository;
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
public class NurseRepositoryTest {
    private static ApplicationContext ctx;
    private static Shift shift;
    private Long id;
    private NurseRepository repo;
    
    public NurseRepositoryTest() {
    }

    @Test
    public void createNurse() {
        List<Nurse> nurseList = new ArrayList();
        nurseList.add(null);
        
        repo = ctx.getBean(NurseRepository.class);
        Nurse nu1 = new Nurse.Builder(45)
                .name("Dolly")
                .surname("Tshintana")
                .age(27)
                .salary(3800)
                .shift(shift)
                .build();
        repo.save(nu1);
        id = nu1.getId();
        Assert.assertNotNull(id);
    }
    
    @Test(dependsOnMethods = "createNurse")
    public void readNurse() {
        repo = ctx.getBean(NurseRepository.class);
        Nurse nurse = repo.findOne(id);
        Assert.assertEquals(nurse.getName(), "Dolly");
    }
    
    @Test(dependsOnMethods = "readNurse")
    public void updateNurse() {
        repo = ctx.getBean(NurseRepository.class);
        Nurse nurse;
        nurse = repo.findOne(id);
        nurse = new Nurse.Builder(48)
                .name("Miriam")
                .surname("Nyama")
                .age(29)
                .salary(4500)
                .shift(shift)
                .build();
        repo.save(nurse);
        
        Nurse updateNurse = repo.findOne(id);
        Assert.assertEquals(updateNurse.getName(), "Dolly");
    }
    
    @Test(dependsOnMethods = "updateNurse")
    public void deleteNurse() {
        repo = ctx.getBean(NurseRepository.class);
        Nurse nurse = repo.findOne(id);
        repo.delete(nurse);
         
        Nurse deletedNurse = repo.findOne(id);
         
        Assert.assertNull(deletedNurse);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
        shift = new Shift.Builder("Night").build();
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
