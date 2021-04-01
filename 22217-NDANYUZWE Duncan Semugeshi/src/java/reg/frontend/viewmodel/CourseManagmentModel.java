/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reg.frontend.viewmodel;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import reg.backend.dao.GeneralDao;
import reg.backend.domain.Course;

/**
 *
 * @author duncan
 */
@ManagedBean(name = "course")
@SessionScoped
public class CourseManagmentModel {
    private Course course = new Course();
    private GeneralDao<Course> courseDao = new GeneralDao<>(Course.class);
    private List<Course> coursesList;
    
    public CourseManagmentModel(){
        coursesList = courseDao.findAll();
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    
     public List<Course> findAll(){
        coursesList = courseDao.findAll();
        return coursesList;
    }
    
    public void RegisterCourse(){
        try {
            courseDao.save(course);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
   
    
}
