/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reg.frontend.viewmodel;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import reg.backend.dao.GeneralDao;
import reg.backend.domain.Books;
import reg.backend.domain.Customer;

/**
 * 
 */
@ManagedBean(name = "registration")
@SessionScoped
public class RegistrationModel {
    private Customer customer = new Customer();
    private Books book = new Books();
    private List<Books> coursesList;
    private List<Books> registeredCourse = new ArrayList<>();
    private GeneralDao<Customer> studDao = new GeneralDao<>(Customer.class);
    public RegistrationModel() {
        GeneralDao<Books> courseDao = new GeneralDao<>(Books.class);
        coursesList = courseDao.findAll();
    }
    
    public void setCoursesList(){
        
    }
    public List<Books> getCoursesList() {
        return coursesList;
    }

    public Customer getStudent() {
        return customer;
    }
    
    public void setStudent(Customer customer) {
        this.customer = customer;
    }
    
    public String next(){  
        return "chooseCourses";
    }
    
    public void add(Books selectedCourse){
        
        customer.registerCourse(selectedCourse);
    }
    
    public void remove(Books selectedCourse){  
        customer.removeCourse(selectedCourse);
        System.out.println("Remove action is fired");
    }
    
    public String completeRegistration(){
        return "registrationSummary";
    }
    
    public String viewDetails(){
        return "viewDetails";
    }
//    
//    public String login(){
//      String navResult = "";
//        Customer s = studDao.findByName(student.getUsername());
//        System.err.println(student.getUsername());
//        if(s.getPassword().equals("123")){
//            navResult= "chooseCourses";
//        }else{
//            navResult = "index";
//        }
//        return navResult;
//    }
    
    public String  registerNow(){
        try{
           
            studDao.save(customer);  
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage("Dear "+customer.getName()+" thank you for registering."
                            + "You are requested to pay "+customer.getTotalPayment()));
            return "registrationFeedback";
        }catch(Exception ex){
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage("Dear "+customer.getName()+" your registration has failed."
                            + "Contract our help desk for support"));
            return "chooseCourses";
        }
    }  
}
