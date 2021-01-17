/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nets.patientvisit.dao;

import com.nets.patientvisit.entity.Patient;
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
public class PatientDao {

    @Autowired
    private EntityManager em;

    public List<Patient> findAll() {

        Session session = em.unwrap(Session.class);

        Query<Patient> query = session.createQuery("from Patient", Patient.class);

        return query.getResultList();
    }
    
    public Patient saveOrUpdate(Patient req) {
        
        Patient patient = new Patient(req);
        Session session = em.unwrap(Session.class);
        session.saveOrUpdate(patient);

        return patient;
    }
    
    public Patient findById(String id ){
        Session session = em.unwrap(Session.class);

        Query<Patient> query = session.createQuery("from Patient where id = :id", Patient.class);
        query.setParameter("id", id);

        List<Patient> result = query.getResultList();

        if (!result.isEmpty()) {
            return result.get(0);
        }

        return null;
    
    }
    
    public void deleteById(String id) {
        Session currentSession = em.unwrap(Session.class); 
        
        Query query = currentSession.createQuery("delete from Patient where id=:id"); 
        query.setParameter("id", id);
        
        query.executeUpdate();
    }

}
