/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nets.patientvisit.repository;

import com.nets.patientvisit.entity.Holiday;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author syahirghariff
 */
public interface HolidayRepository extends JpaRepository<Holiday, String> {
    
    public Holiday findByHolidayDate(Date date);
    
}
