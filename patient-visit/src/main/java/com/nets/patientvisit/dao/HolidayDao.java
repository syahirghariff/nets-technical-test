/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nets.patientvisit.dao;

import com.nets.patientvisit.entity.Holiday;
import com.nets.patientvisit.serviceimpl.HolidayServiceImpl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class HolidayDao {

    @Autowired
    private EntityManager em;

    public Holiday findHoliday() {

        try {

            Session session = em.unwrap(Session.class);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date today = sdf.parse(sdf.format(new Date()));

            Query<Holiday> query = session.createQuery("from Holiday where holidayDate = :holidayDate", Holiday.class);
            query.setParameter("holidayDate", today);

            List<Holiday> result = query.getResultList();

            if (result.size() > 0) {
                return result.get(0);
            }

        } catch (ParseException ex) {
            Logger.getLogger(HolidayServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
