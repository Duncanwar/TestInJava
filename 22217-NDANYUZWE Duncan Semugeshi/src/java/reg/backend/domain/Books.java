/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reg.backend.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 */
@Entity
public class Books implements Serializable {
    @Id
    private String code;
    private String title;
    private int pages;
    private String authors;
    private String publicationYear;
    private double bookFee;
    
    @ManyToMany(mappedBy = "books",cascade = CascadeType.ALL)
    private List<Customer> students = new ArrayList<>();

    public Books() {
    }

    public Books(String code, String title, String authors, String publicationYear,int pages, double bookFee) {
        this.code = code;
        this.title = title;
        this.authors = authors;
        this.publicationYear = publicationYear;
        this.pages = pages;
        this.bookFee = bookFee;
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getBookFee() {
        return bookFee;
    }
public void setBookFee(double bookFee) {
        this.bookFee= bookFee;
    }
    public void setCourseFee(double bookFee) {
        this.bookFee = bookFee;
    }
    
    public List<Customer> getStudents() {
        return students;
    }

    public void setStudents(List<Customer> students) {
        this.students = students;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.code);
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
        final Books other = (Books) obj;
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        return true;
    }
    
}
