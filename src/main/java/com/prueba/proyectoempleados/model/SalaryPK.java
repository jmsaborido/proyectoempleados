package com.prueba.proyectoempleados.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalaryPK implements Serializable {

    @ManyToOne()
    @JoinColumn(name = "emp_no")
    private Employee idempleado;

    @Temporal(TemporalType.DATE)
    @Column(name = "from_date", nullable = false)
    private Date fromDate;

}