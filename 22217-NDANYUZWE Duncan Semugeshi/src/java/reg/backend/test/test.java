/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reg.backend.test;

import reg.backend.dao.GeneralDao;
import reg.backend.domain.Books;

/**
 
 */
public class test {

    public static void main(String[] args) {
        Books c1 = new Books("1-923", "Design Pattern", "Jaden","2019",100, 45000.0);
        Books c2 = new Books("1-924", "Java","Smith","2020", 4, 60000.0);
        Books c3 = new Books("1-925", "Data Structure and Algorthm","Charles","2021", 524, 75000.0);
//        Books c4 = new Books("C04", "Software Testing Techniques", 3, 45000.0);
//        Books c5 = new Books("C05", "Introduction to Bible", 2, 30000.0);
//        Books c6 = new Books("C06", "Introduction to Accounting", 3, 45000.0);
//        Books c7 = new Books("C07", "Mobile Computing", 4, 60000.0);
//        Books c8 = new Books("C08", "Digital Computer and Fundamentals", 4, 60000.0);
        GeneralDao<Books> cdao = new GeneralDao<>(Books.class);
        cdao.save(c1);
        cdao.save(c2);
        cdao.save(c3);
//        cdao.save(c4);
//        cdao.save(c5);
//        cdao.save(c6);
//        cdao.save(c7);
//        cdao.save(c8);
    }
}
