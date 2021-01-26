/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nets.patientvisit.serviceimpl;

import com.nets.patientvisit.entity.Holiday;
import com.nets.patientvisit.exception.ApplicationException;
import com.nets.patientvisit.repository.HolidayRepository;
import com.nets.patientvisit.service.HolidayService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 *
 * @author syahirghariff
 */
@Service
public class HolidayServiceImpl implements HolidayService {

    @Autowired
    private HolidayRepository holidayRepo;

    @Override
    public void checkForHoliday() throws ApplicationException {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date today = sdf.parse(sdf.format(new Date()));

            Holiday holiday = holidayRepo.findByHolidayDate(today);

            if (holiday != null) {
                throw new ApplicationException("Today is a holiday season of ".concat(holiday.getName()), HttpStatus.SERVICE_UNAVAILABLE);
            }

        } catch (ParseException ex) {
            Logger.getLogger(HolidayServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
