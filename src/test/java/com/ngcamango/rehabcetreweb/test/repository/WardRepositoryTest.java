/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.test.repository;

import com.ngcamango.rehabcetreweb.app.config.ConnectionConfig;
import com.ngcamango.rehabcetreweb.domain.Room;
import com.ngcamango.rehabcetreweb.domain.Ward;
import com.ngcamango.rehabcetreweb.repository.WardRepository;
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
public class WardRepositoryTest {
    public static ApplicationContext ctx;
    public static String wardName;
    public static String wardDescription;
    private Long id;
    private WardRepository repo;
    
    public WardRepositoryTest() {
    }

    @Test
    public void createWard() {
        List<Room> roomsList = new ArrayList();
        roomsList.add(null);
        
        repo = ctx.getBean(WardRepository.class);
        Ward w1 = new Ward.Builder("D.O.G Ward")
                .wardDescription("Ward for Gamers")
                .rooms(roomsList)
                .build();
        repo.save(w1);
        id = w1.getId();
        Assert.assertNotNull(id);
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
