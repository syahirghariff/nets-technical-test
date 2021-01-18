/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nets.patientvisit.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nets.patientvisit.enums.Constants;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author syahirghariff
 */
@Entity
@Table(name = "VISIT")
public class Visit implements Serializable{
    
    @Id
    @Column(name = "ID")
    private String id; 
    
    @Column(name = "VISIT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date visitDate;
    
    @Column(name = "PHYSICIAN_ID")
    private String physicianId; 
    
    @Column(name = "REASON")
    private String reason; 
    
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
    
    @ManyToOne
    @JoinColumn(name="PHYSICIAN_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    private Physician physician;

    public Visit() {
    }
    
    public Visit(Visit req) {
    
        this.id = req.getId(); 
        this.visitDate = req.getVisitDate();
        this.physicianId = req.getPhysicianId();
        this.reason = req.getReason(); 
        this.createdDate = req.getCreatedDate() != null ? req.getCreatedDate() : new Date();
        this.modifiedDate = new Date(); 
        this.createdBy = Constants.USERNAME; 
        this.modifiedBy = Constants.USERNAME; 
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public String getPhysicianId() {
        return physicianId;
    }

    public void setPhysicianId(String physicianId) {
        this.physicianId = physicianId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Physician getPhysician() {
        return physician;
    }

    public void setPhysician(Physician physician) {
        this.physician = physician;
    }

    @Override
    public String toString() {
        return "Visit{" + "id=" + id + ", visitDate=" + visitDate + ", physicianId=" + physicianId + ", reason=" + reason + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + '}';
    }
    
}
