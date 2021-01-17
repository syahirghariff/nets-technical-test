/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nets.patientvisit.dao;

import com.nets.patientvisit.entity.Physician;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author syahirghariff
 */
@Repository
public class PhysicianDao {
    
    @Autowired
    private EntityManager em;

    public List<Physician> findAll() {

        Session session = em.unwrap(Session.class);

        Query<Physician> query = session.createQuery("from Physician", Physician.class);

        return query.getResultList();
    }
    
    public Physician saveOrUpdate(Physician req) {
        
        Physician physician = new Physician(req);
        Session session = em.unwrap(Session.class);
        session.saveOrUpdate(physician);

        return physician;
    }
    
    public Physician findById(String id ){
        Session session = em.unwrap(Session.class);

        Query<Physician> query = session.createQuery("from Physician where id = :id", Physician.class);
        query.setParameter("id", id);

        List<Physician> result = query.getResultList();

        if (!result.isEmpty()) {
            return result.get(0);
        }

        return null;
    
    }
    
    public void deleteById(String id) {
        Session currentSession = em.unwrap(Session.class); 
        
        Query query = currentSession.createQuery("delete from Physician where id=:id"); 
        query.setParameter("id", id);
        
        query.executeUpdate();
    }
    
}
