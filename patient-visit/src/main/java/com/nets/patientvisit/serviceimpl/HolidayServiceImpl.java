/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nets.patientvisit.serviceimpl;

import com.nets.patientvisit.dao.HolidayDao;
import com.nets.patientvisit.entity.Holiday;
import com.nets.patientvisit.exception.HolidayException;
import com.nets.patientvisit.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author syahirghariff
 */
@Service
public class HolidayServiceImpl implements HolidayService {

    @Autowired
    private HolidayDao holidayDao;

    @Override
    public void checkForHoliday() {
        
        Holiday holiday = holidayDao.findHoliday();
        
        if (holiday!= null) {
            throw new HolidayException(holiday.getName());
        }
    }

}
