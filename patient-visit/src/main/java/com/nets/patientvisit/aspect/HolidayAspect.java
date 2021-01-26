/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nets.patientvisit.aspect;

import com.nets.patientvisit.service.HolidayService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author syahirghariff
 */
@Aspect
@Component
public class HolidayAspect {

    @Pointcut("execution (* com.nets.patientvisit.serviceimpl.*.save*(..))")
    public void pointCutHolidaySave() {
    }

    @Pointcut("execution (* com.nets.patientvisit.serviceimpl.*.update*(..))")
    public void pointCutHolidayUpdate() {
    }

    @Pointcut("execution (* com.nets.patientvisit.serviceimpl.*.delete*(..))")
    public void pointCutHolidayDelete() {
    }

    @Autowired
    private HolidayService holidaySvc;

    @Before("pointCutHolidaySave() || pointCutHolidayUpdate() || pointCutHolidayDelete() ")
    public void beforeCheckHoliday(JoinPoint joinPoint) {
        holidaySvc.checkForHoliday();
    }
}
