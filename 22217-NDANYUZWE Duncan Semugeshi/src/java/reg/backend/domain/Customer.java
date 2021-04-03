/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reg.backend.domain;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * 
 */
@Entity
public class Customer implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "REGISTRATION",joinColumns = {@JoinColumn(name = "STUDENT_ID")}
            ,inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
    List<Books> books = new ArrayList<>();
    
    private LoginStatus loginStatus;
    
    public Customer() {
    }

    public Customer( String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }
    
    
    public int getId() {
        return Id;
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

    public List<Books> getCourses() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }
    
    public void registerCourse(Books course){
        books.add(course);
    }
    public void removeCourse(Books course){
        books.remove(course);
    }

    public LoginStatus getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(LoginStatus loginStatus) {
        this.loginStatus = loginStatus;
    }

 
    public boolean isExist(String code){
        boolean isexist=false;
        for (Books c : books) {
            if(c.getCode().equals(code))
                isexist = true;
        }
        return isexist;
    }
    public int getNumberOfCourses(){
        return books.size();
    }
    public int getNumberOfPages(){
        int total=0;
        for (Books book : books) {
            total+= book.getPages();
        }
        return total;
    }
    public String getTotalPayment(){
        double fee=0.0;
        for (Books course : books) {
            fee+= course.getBookFee();
        }
        DecimalFormat formatter = new DecimalFormat("###,###,###.##Frw");
        return formatter.format(fee);
    }
    
//    @Override
//    public int hashCode() {
//        int hash = 5;
//        hash = 31 * hash + Objects.hashCode(this.studentId);
//        return hash;
//    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Customer other = (Customer) obj;
//        if (!Objects.equals(this.studentId, other.studentId)) {
//            return false;
//        }
//        return true;
//    }
}
