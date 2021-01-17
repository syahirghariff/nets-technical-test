/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nets.patientvisit.dao;

import com.nets.patientvisit.entity.Physician;
import com.nets.patientvisit.entity.Visit;
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
public class VisitDao {
    
    @Autowired
    private EntityManager em;
    
    
    public List<Visit> findAll() {

        Session session = em.unwrap(Session.class);

        Query<Visit> query = session.createQuery("from Visit", Visit.class);

        return query.getResultList();
    }
    
    public Visit saveOrUpdate(Visit req) {
        
        Visit visit = new Visit(req);
        Session session = em.unwrap(Session.class);
        session.saveOrUpdate(visit);

        return visit;
    }
    
    public Visit findById(String id ){
        Session session = em.unwrap(Session.class);

        Query<Visit> query = session.createQuery("from Visit where id = :id", Visit.class);
        query.setParameter("id", id);

        List<Visit> result = query.getResultList();

        if (!result.isEmpty()) {
            return result.get(0);
        }

        return null;
    
    }
    
    public void deleteById(String id) {
        Session currentSession = em.unwrap(Session.class); 
        
        Query query = currentSession.createQuery("delete from Visit where id=:id"); 
        query.setParameter("id", id);
        
        query.executeUpdate();
    }
    
}
