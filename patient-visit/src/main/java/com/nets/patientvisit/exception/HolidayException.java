/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nets.patientvisit.exception;

/**
 *
 * @author syahirghariff
 */
public class HolidayException extends RuntimeException{
    
    public static String HOLIDAY_MESSAGE = "Today is a Public Holiday of ";
    
    public HolidayException(){};
    
    public HolidayException(String message) {
        super(HOLIDAY_MESSAGE.concat(message));
    }
    
}
