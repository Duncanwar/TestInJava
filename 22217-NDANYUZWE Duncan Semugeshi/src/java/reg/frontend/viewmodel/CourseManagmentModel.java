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
import reg.backend.domain.Books;

/**
 *
 * @author duncan
 */
@ManagedBean(name = "course")
@SessionScoped
public class CourseManagmentModel {
    private Books course = new Books();
    private GeneralDao<Books> courseDao = new GeneralDao<>(Books.class);
    private List<Books> coursesList;
    
    public CourseManagmentModel(){
        coursesList = courseDao.findAll();
    }

    public Books getCourse() {
        return course;
    }

    public void setCourse(Books course) {
        this.course = course;
    }
    
     public List<Books> findAll(){
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
