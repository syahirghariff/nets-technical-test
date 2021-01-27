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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author syahirghariff
 */
@Entity
@Table(name = "VISIT")
@Getter
@Setter
@NoArgsConstructor
public class Visit implements Serializable {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "VISIT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date visitDate;

    @Column(name = "PHYSICIAN_ID")
    private String physicianId;

    @Column(name = "REASON")
    private String reason;

    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date createdDate;

    @Column(name = "MODIFIED_DATE")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date modifiedDate;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "MODIFIED_BY")
    private String modifiedBy;

    @ManyToOne
    @JoinColumn(name = "PHYSICIAN_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    private Physician physician;

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

    @Override
    public String toString() {
        return "Visit{" + "id=" + id + ", visitDate=" + visitDate + ", physicianId=" + physicianId + ", reason=" + reason + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + '}';
    }

}
