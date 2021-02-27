/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reg.backend.domain;

import reg.backend.helpers.LocalDateConverter;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * 
 */
@Entity
public class Student implements Serializable {
    @Id
    private String studentId;
    private String name;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    //@Convert(converter = LocalDateConverter.class)
    private Date dob;
    
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "REGISTRATION",joinColumns = {@JoinColumn(name = "STUDENT_ID")}
            ,inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
    List<Course> courses = new ArrayList<>();

    public Student() {
    }
    
    public Student(String studentId) {
        this.studentId = studentId;
    }

    public Student(String studentId, String name, Gender gender, Date dob) {
        this.studentId = studentId;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
    }
    
    
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    
    public void registerCourse(Course course){
        courses.add(course);
    }
    public void removeCourse(Course course){
        courses.remove(course);
    }
    public boolean isExist(String code){
        boolean isexist=false;
        for (Course c : courses) {
            if(c.getCode().equals(code))
                isexist = true;
        }
        return isexist;
    }
    public int getNumberOfCourses(){
        return courses.size();
    }
    public int getNumberOfCredits(){
        int total=0;
        for (Course course : courses) {
            total+= course.getCredits();
        }
        return total;
    }
    public String getTotalPayment(){
        double fee=0.0;
        for (Course course : courses) {
            fee+= course.getCourseFee();
        }
        DecimalFormat formatter = new DecimalFormat("###,###,###.##Frw");
        return formatter.format(fee);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.studentId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.studentId, other.studentId)) {
            return false;
        }
        return true;
    }
}
