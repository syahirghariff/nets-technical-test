/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nets.patientvisit.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author syahirghariff
 */
@Entity
@Table(name="HOLIDAY")
public class Holiday implements Serializable {
    
    @Id
    @Column(name = "name")
    private String name; 
    
    @Column(name = "HOLIDAY_DATE")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date holidayDate; 
    
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date createdDate;
    
    @Column(name = "MODIFIED_DATE")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date modifiedDate;
    
    @Column(name = "CREATED_BY")
    private String createdBy; 
    
    @Column(name = "MODIFIED_BY")
    private String modifiedBy; 

    public Holiday() {
    }

    public String getName() {
        return name;
    }

    public Date getHolidayDate() {
        return holidayDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }
    
    @Override
    public String toString() {
        return "Holiday{" + "name=" + name + ", holidayDate=" + holidayDate + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + '}';
    }
    
    
    
    
}
