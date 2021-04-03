///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package reg.frontend.viewmodel;
//
//import java.sql.Date;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//import reg.backend.dao.GeneralDao;
//import reg.backend.domain.Books;
//import reg.backend.domain.Gender;
//import reg.backend.domain.Customer;
//import reg.backend.helpers.HibernateUtil;
//
///**
// * @author duncan
// */
//public class RegistrationModelNGTest extends DbSetup{
//    GeneralDao<Customer> student = new GeneralDao<>(Customer.class);
//    GeneralDao<Books> course = new GeneralDao<>(Books.class);
//    public RegistrationModelNGTest() {
//    }
//
//    @BeforeMethod
//    public void  initialize()  {
//        try {
//            System.out.println("insert in database Customer");
//            prepare(CommonOperations.INSERT_COURSE);
//            System.out.println("insert in database Account");
//            prepare(CommonOperations.INSERT_STUDENT);
//            System.out.println("insert in database Dinish");
//            
//        } catch (Exception ex) {
//            Logger.getLogger(RegistrationModelNGTest.class.getName()).log(Level.SEVERE, null, ex);
//        }   
//    }
//    
//    @AfterMethod
//    public void cleanDatabase() {
//        try {
//            System.out.println("Clean Database");
//            DbSetup.prepare(CommonOperations.DELETE_REGISTRATION);
//            DbSetup.prepare(CommonOperations.DELETE_COURSE);
//            DbSetup.prepare(CommonOperations.DELETE_STUDENT);
//        } catch (Exception ex) {
//            Logger.getLogger(RegistrationModelNGTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    @Test
//    public void testSaveStudent(){
//        Customer st = new Customer("2323","duncan",Gender.MALE,new Date(1999, 6, 6));
//        Customer sa = student.save(st);
//        Assert.assertEquals(sa,st);
//    }
//    @Test
//    public void testUpdateStudent(){
//        Customer st = new Customer("101","duncan",Gender.MALE,new Date(1999, 6, 6));
//        Customer sa = student.update(st);
//        Assert.assertEquals(sa,st);
//    }
//    @Test
//    public void testDeleteStudent(){
//        Customer st = student.findById("101");
//        Customer sa = student.delete(st);
//        Assert.assertEquals(sa,st);
//    }
//      @Test
//    public void testFindAllStudent(){
//        Customer st = new Customer("101","duncan",Gender.MALE,new Date(1999, 6, 6));
//        List<Customer> sa = student.findAll();
//        Assert.assertEquals(sa.size(),2);
//    }
//     @Test
//    public void testSaveCourse(){
//        Books st = new Books("C05","HEALTHY",4,48000.0);
//        Books sa = course.save(st);
//        Assert.assertEquals(sa,st);
//    }
//     @Test
//    public void testDeleteCourse(){
//        Books st = new Books("C02","HEALTHY",4,48000.0);
//        Books sa = course.findById("C02");
//        sa = course.delete(sa);
//        Assert.assertEquals(sa,st);
//    }
//     public void testFindAllCourse(){
//        Books st = new Books("C02","HEALTHY",4,48000.0);
//        List<Books> sa = course.findAll();
//        Assert.assertEquals(sa.size(),0);
//    }
//     @Test
//    public void testUpdateCourse(){
//        Books st = new Books("C02","HEALTHY",4,48000.0);
//        Books sa = course.update(st);
//        Assert.assertEquals(sa,st);
//    }
//    @Test
//    public void testRegister(){
//        Customer st = new Customer("2323","duncan",Gender.MALE,new Date(1999, 6, 6));
//         Books co1 = course.findById("C01");
//         Books co2 = course.findById("C02");
//         st.registerCourse(co1);
//         st.registerCourse(co2);
//        Customer sa = student.save(st);
//        
//        Assert.assertEquals(sa.getTotalPayment(),st.getTotalPayment());   
//    }
//    @Test
//    public void removeCourseWhileRegister(){
//        Customer st = new Customer("2323","duncan",Gender.MALE,new Date(1999, 6, 6));
//        Books co1 = course.findById("C01");
//        Books co2 = course.findById("C02");
//        st.registerCourse(co1);
//        st.registerCourse(co2);
//        st.removeCourse(co2);
//        Customer sa = student.save(st);
//        Assert.assertEquals(sa.getTotalPayment(),st.getTotalPayment());
//    }
//  
//     @Test
//    public void testIsExistFalse(){
//        Customer st = new Customer("2323","duncan",Gender.MALE,new Date(1999, 6, 6));
//        Books co1 = course.findById("C01");
//        Books co2 = course.findById("C02");
//        boolean b = st.isExist("C03");
//        st.registerCourse(co1);
//        st.registerCourse(co2);
//        Customer sa = student.save(st);
//        Assert.assertEquals(b,false);
//    }
//    @Test
//    public void testNumberOfCourses(){
//        Customer st = new Customer("2323","duncan",Gender.MALE,new Date(1999, 6, 6));
//         Books co1 = course.findById("C01");
//         Books co2 = course.findById("C02");
//         st.registerCourse(co1);
//         st.registerCourse(co2);
//         st.removeCourse(co2);
//        Customer sa = student.save(st);
//        Assert.assertEquals(sa.getNumberOfCourses(),st.getNumberOfCourses());
//    }
//     @Test
//    public void testNumberOfCredits(){
//        Customer st = new Customer("2323","duncan",Gender.MALE,new Date(1999, 6, 6));
//         Books co1 = course.findById("C01");
//         Books co2 = course.findById("C02");
//         st.registerCourse(co1);
//         st.registerCourse(co2);
//         st.removeCourse(co2);
//        Customer sa = student.save(st);
//        Assert.assertEquals(sa.getNumberOfCredits(),st.getNumberOfCredits());
//    }
//    
//     @BeforeTest
//   public void init(){
//       System.err.println("Create Tables");
//       HibernateUtil.getSessionFactory();
//   }
//}
