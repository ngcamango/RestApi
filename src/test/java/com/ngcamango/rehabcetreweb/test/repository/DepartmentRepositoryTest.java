/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ngcamango.rehabcetreweb.test.repository;

import com.ngcamango.rehabcetreweb.app.config.ConnectionConfig;
import com.ngcamango.rehabcetreweb.domain.Department;
import com.ngcamango.rehabcetreweb.domain.Nurse;
import com.ngcamango.rehabcetreweb.domain.Ward;
import com.ngcamango.rehabcetreweb.repository.DepartmentRepository;
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
public class DepartmentRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private DepartmentRepository repo;
    
    public DepartmentRepositoryTest() {
    }

    @Test
    public void createDepartment() {
        List<Ward> wardList = new ArrayList();
        wardList.add(null);
        
        List<Nurse> nurseList = new ArrayList();
        nurseList.add(null);
        
        repo = ctx.getBean(DepartmentRepository.class);
        Department d1 = new Department.Builder("D.O.G")
                .description("Department of Gamers")
                .wards(wardList)
                .nurses(nurseList)
                .build();
        repo.save(d1);
        id = d1.getId();
        Assert.assertNotNull(id);
    }
    
    @Test(dependsOnMethods = "createDepartment")
    public void readDepartment() {
        repo = ctx.getBean(DepartmentRepository.class);
        Department department = repo.findOne(id);
        Assert.assertEquals(department.getName(), "D.O.G");
    }
    
    @Test(dependsOnMethods = "readDepartment")
    public void updateDepartment() {
        repo = ctx.getBean(DepartmentRepository.class);
        Department department;
        department = repo.findOne(id);
        department = new Department.Builder("D.O.D")
                .description("Department of Gamers")
                //.wards(wardList)
                //.nurses(nurseList)
                .build();
        repo.save(department);
        
        Department updateDepartment = repo.findOne(id);
        Assert.assertEquals(updateDepartment.getName(), "D.O.G");
    }
    
    @Test(dependsOnMethods = "updateDepartment")
    public void deleteDepartment() {
        repo = ctx.getBean(DepartmentRepository.class);
        Department department = repo.findOne(id);
        repo.delete(department);
         
        Department deletedDepartment = repo.findOne(id);
         
        Assert.assertNull(deletedDepartment);
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
