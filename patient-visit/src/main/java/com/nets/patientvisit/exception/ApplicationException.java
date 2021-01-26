/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nets.patientvisit.exception;

import org.springframework.http.HttpStatus;

/**
 *
 * @author syahirghariff
 */
public class ApplicationException extends RuntimeException{
    
    private HttpStatus httpStatus; 
    
    public ApplicationException () {}
    
    public ApplicationException(String message) {
        super(message);
    }
    
    public ApplicationException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
    
    
}
