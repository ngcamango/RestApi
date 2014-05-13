/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.test.repository;

import com.ngcamango.rehabcetreweb.app.config.ConnectionConfig;
import com.ngcamango.rehabcetreweb.domain.Bed;
import com.ngcamango.rehabcetreweb.domain.Room;
import com.ngcamango.rehabcetreweb.repository.RoomRepository;
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
public class RoomRepositoryTest {
    public static ApplicationContext ctx;
    private static int roomNo;
    private static Bed beds;
    private Long id;
    private RoomRepository repo;
    
    public RoomRepositoryTest() {
    }

    @Test
    public void createRoom() {
        
        repo = ctx.getBean(RoomRepository.class);
        Room r1 = new Room.Builder(126)
                .beds(beds)
                .build();
        repo.save(r1);
        id = r1.getId();
        Assert.assertNotNull(id);
    }
    
    @Test(dependsOnMethods = "createRoom")
    public void readRoom() {
        repo = ctx.getBean(RoomRepository.class);
        Room room = repo.findOne(id);
        Assert.assertEquals(room.getRoomNo(), 126);
    }
    
    @Test(dependsOnMethods = "readRoom")
    public void updateRoom() {
        repo = ctx.getBean(RoomRepository.class);
        Room room;
        room = repo.findOne(id);
        room = new Room.Builder(154)
                .beds(beds)
                .build();
        repo.save(room);
        
        Room updateRoom = repo.findOne(id);
        Assert.assertEquals(updateRoom.getRoomNo(), 126);
    }
    
    @Test(dependsOnMethods = "updateRoom")
    public void deleteRoom() {
        repo = ctx.getBean(RoomRepository.class);
        Room room = repo.findOne(id);
        repo.delete(room);
         
        Room deletedRoom = repo.findOne(id);
         
        Assert.assertNull(deletedRoom);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
        beds = new Bed.Builder("Single").build();
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
