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
@Table(name = "BILLING")
public class Billing implements Serializable {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "PATIENT_ID")
    private String patientId;

    @Column(name = "PHYSICIAN_ID")
    private String physicianId;

    @Column(name = "BILLED_DATE")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date billedDate;

    public Billing() {
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPhysicianId() {
        return physicianId;
    }

    public void setPhysicianId(String physicianId) {
        this.physicianId = physicianId;
    }

    public Date getBilledDate() {
        return billedDate;
    }

    public void setBilledDate(Date billedDate) {
        this.billedDate = billedDate;
    }

    @Override
    public String toString() {
        return "Billing{" + "id=" + id + ", patientId=" + patientId + ", physicianId=" + physicianId + ", billedDate=" + billedDate + '}';
    }
}
