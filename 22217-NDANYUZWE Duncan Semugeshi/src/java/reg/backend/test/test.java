/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reg.backend.test;

import reg.backend.dao.GeneralDao;
import reg.backend.domain.Course;

/**
 *
 
 */
public class test {

    public static void main(String[] args) {
        Course c1 = new Course("C01", "Advanced Software Modeling", 3, 45000.0);
        Course c2 = new Course("C02", "Web Technology", 4, 60000.0);
        Course c3 = new Course("C03", "Data Structure and Algorthm", 5, 75000.0);
        Course c4 = new Course("C04", "Software Testing Techniques", 3, 45000.0);
        Course c5 = new Course("C05", "Introduction to Bible", 2, 30000.0);
        Course c6 = new Course("C06", "Introduction to Accounting", 3, 45000.0);
        Course c7 = new Course("C07", "Mobile Computing", 4, 60000.0);
        Course c8 = new Course("C08", "Digital Computer and Fundamentals", 4, 60000.0);
        GeneralDao<Course> cdao = new GeneralDao<>(Course.class);
        cdao.save(c1);
        cdao.save(c2);
        cdao.save(c3);
        cdao.save(c4);
        cdao.save(c5);
        cdao.save(c6);
        cdao.save(c7);
        cdao.save(c8);
    }
}
