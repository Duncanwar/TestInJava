/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reg.backend.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import reg.backend.helpers.HibernateUtil;

/**
 *
 * 
 */
public class GeneralDao<K> {
    Session session =null;
    private final Class<K> type;

    public GeneralDao(Class<K> type) {
        this.type = type;
    }
    
    public Session createSession(){
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        return session;
    }
    public void closeSession(){
        session.getTransaction().commit();
        session.close();
    }
    
    
    public K save(K obj){
        createSession().saveOrUpdate(obj);
        closeSession();
        return obj;
    }
    
    public K update(K obj){
        createSession().update(obj);
        closeSession();
        return obj;
    }
    public K delete(K obj){
        createSession().delete(obj);
        closeSession();
        return obj;
    }
    public K  findById(Serializable id){
        K obj = (K) createSession().get(type, id);
        closeSession();
        return obj;
    }
    public List<K>  findAll(){
        List<K> obj = createSession().createCriteria(type.getName()).list();
        closeSession();
        return obj;
    }
    public K findByName(String name){
        K item = (K) createSession().get(type.getName(), name);
     return item;
    }
}
