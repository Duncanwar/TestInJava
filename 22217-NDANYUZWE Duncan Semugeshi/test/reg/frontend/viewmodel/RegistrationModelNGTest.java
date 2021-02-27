/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reg.frontend.viewmodel;

import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import reg.backend.dao.GeneralDao;
import reg.backend.domain.Course;
import reg.backend.domain.Gender;
import reg.backend.domain.Student;
import reg.backend.helpers.HibernateUtil;

/**
 * @author duncan
 */
public class RegistrationModelNGTest extends DbSetup{
    GeneralDao<Student> student = new GeneralDao<>(Student.class);
    GeneralDao<Course> course = new GeneralDao<>(Course.class);
    public RegistrationModelNGTest() {
    }

    @BeforeMethod
    public void  initialize()  {
        try {
            System.out.println("insert in database Customer");
            prepare(CommonOperations.INSERT_COURSE);
            System.out.println("insert in database Account");
            prepare(CommonOperations.INSERT_STUDENT);
            System.out.println("insert in database Dinish");
            
        } catch (Exception ex) {
            Logger.getLogger(RegistrationModelNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    @AfterMethod
    public void cleanDatabase() {
        try {
            System.out.println("Clean Database");
            DbSetup.prepare(CommonOperations.DELETE_REGISTRATION);
            DbSetup.prepare(CommonOperations.DELETE_COURSE);
            DbSetup.prepare(CommonOperations.DELETE_STUDENT);
        } catch (Exception ex) {
            Logger.getLogger(RegistrationModelNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Test
    public void testSaveStudent(){
        Student st = new Student("2323","duncan",Gender.MALE,new Date(1999, 6, 6));
        Student sa = student.save(st);
        Assert.assertEquals(sa,st);
    }
    @Test
    public void testUpdateStudent(){
        Student st = new Student("101","duncan",Gender.MALE,new Date(1999, 6, 6));
        Student sa = student.update(st);
        Assert.assertEquals(sa,st);
    }
    @Test
    public void testDeleteStudent(){
        Student st = student.findById("101");
        Student sa = student.delete(st);
        Assert.assertEquals(sa,st);
    }
      @Test
    public void testFindAllStudent(){
        Student st = new Student("101","duncan",Gender.MALE,new Date(1999, 6, 6));
        List<Student> sa = student.findAll();
        Assert.assertEquals(sa.size(),2);
    }
     @Test
    public void testSaveCourse(){
        Course st = new Course("C05","HEALTHY",4,48000.0);
        Course sa = course.save(st);
        Assert.assertEquals(sa,st);
    }
     @Test
    public void testDeleteCourse(){
        Course st = new Course("C02","HEALTHY",4,48000.0);
        Course sa = course.findById("C02");
        sa = course.delete(sa);
        Assert.assertEquals(sa,st);
    }
     public void testFindAllCourse(){
        Course st = new Course("C02","HEALTHY",4,48000.0);
        List<Course> sa = course.findAll();
        Assert.assertEquals(sa.size(),0);
    }
     @Test
    public void testUpdateCourse(){
        Course st = new Course("C02","HEALTHY",4,48000.0);
        Course sa = course.update(st);
        Assert.assertEquals(sa,st);
    }
    @Test
    public void testRegister(){
        Student st = new Student("2323","duncan",Gender.MALE,new Date(1999, 6, 6));
         Course co1 = course.findById("C01");
         Course co2 = course.findById("C02");
         st.registerCourse(co1);
         st.registerCourse(co2);
        Student sa = student.save(st);
        
        Assert.assertEquals(sa.getTotalPayment(),st.getTotalPayment());   
    }
    @Test
    public void removeCourseWhileRegister(){
        Student st = new Student("2323","duncan",Gender.MALE,new Date(1999, 6, 6));
        Course co1 = course.findById("C01");
        Course co2 = course.findById("C02");
        st.registerCourse(co1);
        st.registerCourse(co2);
        st.removeCourse(co2);
        Student sa = student.save(st);
        Assert.assertEquals(sa.getTotalPayment(),st.getTotalPayment());
    }
  
     @Test
    public void testIsExistFalse(){
        Student st = new Student("2323","duncan",Gender.MALE,new Date(1999, 6, 6));
        Course co1 = course.findById("C01");
        Course co2 = course.findById("C02");
        boolean b = st.isExist("C03");
        st.registerCourse(co1);
        st.registerCourse(co2);
        Student sa = student.save(st);
        Assert.assertEquals(b,false);
    }
    @Test
    public void testNumberOfCourses(){
        Student st = new Student("2323","duncan",Gender.MALE,new Date(1999, 6, 6));
         Course co1 = course.findById("C01");
         Course co2 = course.findById("C02");
         st.registerCourse(co1);
         st.registerCourse(co2);
         st.removeCourse(co2);
        Student sa = student.save(st);
        Assert.assertEquals(sa.getNumberOfCourses(),st.getNumberOfCourses());
    }
     @Test
    public void testNumberOfCredits(){
        Student st = new Student("2323","duncan",Gender.MALE,new Date(1999, 6, 6));
         Course co1 = course.findById("C01");
         Course co2 = course.findById("C02");
         st.registerCourse(co1);
         st.registerCourse(co2);
         st.removeCourse(co2);
        Student sa = student.save(st);
        Assert.assertEquals(sa.getNumberOfCredits(),st.getNumberOfCredits());
    }
    
     @BeforeTest
   public void init(){
       System.err.println("Create Tables");
       HibernateUtil.getSessionFactory();
   }
}
