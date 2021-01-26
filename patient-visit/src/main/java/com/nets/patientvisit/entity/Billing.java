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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author syahirghariff
 */
@Entity
@Table(name = "BILLING")
@Getter
@Setter
@NoArgsConstructor
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

    @Override
    public String toString() {
        return "Billing{" + "id=" + id + ", patientId=" + patientId + ", physicianId=" + physicianId + ", billedDate=" + billedDate + '}';
    }
}
