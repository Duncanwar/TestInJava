/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reg.frontend.viewmodel;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import reg.backend.dao.GeneralDao;
import reg.backend.domain.Books;
import reg.backend.helpers.HibernateUtil;

/**
 * @author duncan
 */
public class TestGUI {
    private WebDriver driver;
    @BeforeMethod
    public void insertCourseData(){
       Books c1 = new Books("1-923", "Design Pattern", "Jaden","2019",100, 45000.0);
        Books c2 = new Books("1-924", "Java","Smith","2020", 230, 60000.0);
        Books c3 = new Books("1-925", "Data Structure and Algorthm","Charles","2021",200,50000.0);
        GeneralDao<Books> cdao = new GeneralDao<>(Books.class);
        cdao.save(c1);
        cdao.save(c2);
        cdao.save(c3);
    }
    
    @Test 
   public void testGUI(){
        System.setProperty("webdriver.chrome.driver", "/home/duncan/Desktop/Semester6/Testing/22217-NDANYUZWE Duncan Semugeshi/src/java/chromedriver");
        driver = new ChromeDriver(); 
        driver.get("http://localhost:8080/22217-NDANYUZWE_Duncan_Semugeshi/studentInfo.xhtml");
        driver.findElement(By.name("name")).sendKeys("Semugeshi");
        driver.findElement(By.name("gender")).sendKeys("MALE");
        driver.findElement(By.name("Next")).click();
        Assert.assertEquals(driver.getTitle(), "Choose Course");
        driver.findElement(By.id("j_idt6:0:Add")).click();
        String payment =driver.findElement(By.id("totalpayment")).getText();
        Assert.assertEquals(payment, "45,000Frw");
        driver.findElement(By.name("RegisterNow")).click();
        Assert.assertEquals(driver.getTitle(), "Feedback");
    } 
   //@Test 
   public void IndextoRegPage(){
        System.setProperty("webdriver.chrome.driver", "/home/duncan/Desktop/Semester6/Testing/22217-NDANYUZWE Duncan Semugeshi/src/java/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/22217-NDANYUZWE_Duncan_Semugeshi/index.xhtml");
        driver.findElement(By.linkText("Student")).click();
        Assert.assertEquals(driver.getTitle(),"Student Page");
        
   }
    @AfterMethod
    public void cleanDatabase() {
        try {
            System.out.println("Clean Database");
            DbSetup.prepare(CommonOperations.DELETE_REGISTRATION);
            DbSetup.prepare(CommonOperations.DELETE_STUDENT);
            DbSetup.prepare(CommonOperations.DELETE_COURSE);
            
        } catch (Exception ex) {
            System.err.println("failed");
            Logger.getLogger(RegistrationModelNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      @BeforeTest
   public void init(){
       System.err.println("Create Tables");
       HibernateUtil.getSessionFactory();
   }
}
