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
import reg.backend.domain.Course;
import reg.backend.domain.Student;

/**
 * 
 */
@ManagedBean(name = "registration")
@SessionScoped
public class RegistrationModel {
    private Student student = new Student();
    private List<Course> coursesList;
    private List<Course> registeredCourse = new ArrayList<>();

    public RegistrationModel() {
        GeneralDao<Course> courseDao = new GeneralDao<>(Course.class);
        coursesList = courseDao.findAll();
    }
    
    public void setCoursesList(){
        
    }
    public List<Course> getCoursesList() {
        return coursesList;
    }

    public Student getStudent() {
        return student;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }
    
    public String next(){
        return "chooseCourses";
    }
    
    public void add(Course selectedCourse){
        
        student.registerCourse(selectedCourse);
    }
    
    public void remove(Course selectedCourse){  
        student.removeCourse(selectedCourse);
        System.out.println("Remove action is fired");
    }
    
    public String completeRegistration(){
        return "registrationSummary";
    }
    
    public String viewDetails(){
        return "viewDetails";
    }
    
    public String login(){
        
      String navResult = "";
        System.out.println("Entered Username is= "+ student.getName() + ", password= "+ student.getPassword());
        if(student.getUsername().equals("me") && student.getPassword().equals("123")){
            navResult= "chooseCourses";
        }else{
            navResult = "index";
        }
        return navResult;
    }
    
    public String  registerNow(){
        try{
            GeneralDao<Student> studDao = new GeneralDao<>(Student.class);
            studDao.save(student);  
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage("Dear "+student.getName()+" thank you for registering."
                            + "You are requested to pay "+student.getTotalPayment()));
            return "registrationFeedback";
        }catch(Exception ex){
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage("Dear "+student.getName()+" your registration has failed."
                            + "Contract our help desk for support"));
            return "chooseCourses";
        }
    }  
}
