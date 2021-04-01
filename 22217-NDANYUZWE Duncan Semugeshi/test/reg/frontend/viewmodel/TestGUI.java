///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package reg.frontend.viewmodel;
//
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//import reg.backend.dao.GeneralDao;
//import reg.backend.domain.Course;
//import reg.backend.helpers.HibernateUtil;
//
///**
// *
// * @author duncan
// */
//public class TestGUI {
//    private WebDriver driver;
//    @BeforeMethod
//    public void insertCourseData(){
//        Course c1 = new Course("C01", "Advanced Software Modeling", 3, 45000.0);
//        Course c2 = new Course("C02", "Web Technology", 4, 60000.0);
//        Course c3 = new Course("C03", "Data Structure and Algorthm", 5, 75000.0);
//        Course c4 = new Course("C04", "Software Testing Techniques", 3, 45000.0);
//        Course c5 = new Course("C05", "Introduction to Bible", 2, 30000.0);
//        Course c6 = new Course("C06", "Introduction to Accounting", 3, 45000.0);
//        Course c7 = new Course("C07", "Mobile Computing", 4, 60000.0);
//        Course c8 = new Course("C08", "Digital Computer and Fundamentals", 4, 60000.0);
//        GeneralDao<Course> cdao = new GeneralDao<>(Course.class);
//        cdao.save(c1);
//        cdao.save(c2);
//        cdao.save(c3);
//        cdao.save(c4);
//        cdao.save(c5);
//        cdao.save(c6);
//        cdao.save(c7);
//        cdao.save(c8);
//    }
//    
//    @Test 
//   public void testGUI(){
//        System.setProperty("webdriver.chrome.driver", "/home/duncan/Downloads/22217-NDANYUZWE Duncan Semugeshi/src/java/chromedriver");
//        driver = new ChromeDriver(); 
//        driver.get("http://localhost:8080/22217-NDANYUZWE%20Duncan%20Semugeshi/studentInfo.xhtml");
//        driver.findElement(By.name("id")).sendKeys("12321");
//        driver.findElement(By.name("names")).sendKeys("Semugeshi");
//        driver.findElement(By.name("dob")).sendKeys("12/03/2019");
//        driver.findElement(By.name("gender")).sendKeys("MALE");
//        
//        driver.findElement(By.name("Next")).click();
//        Assert.assertEquals(driver.getTitle(),"Choose Course");
//        driver.findElement(By.id("j_idt6:0:Add")).click();
//        String payment =driver.findElement(By.id("totalpayment")).getText();
//        Assert.assertEquals(payment, "45,000Frw");
//        driver.findElement(By.name("RegisterNow")).click();
//        Assert.assertEquals(driver.getTitle(), "Feedback");
//    } 
//    @AfterMethod
//    public void cleanDatabase() {
//        try {
//            System.out.println("Clean Database");
//            DbSetup.prepare(CommonOperations.DELETE_REGISTRATION);
//            DbSetup.prepare(CommonOperations.DELETE_STUDENT);
//            DbSetup.prepare(CommonOperations.DELETE_COURSE);
//            
//        } catch (Exception ex) {
//            Logger.getLogger(RegistrationModelNGTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//      @BeforeTest
//   public void init(){
//       System.err.println("Create Tables");
//       HibernateUtil.getSessionFactory();
//   }
//}
