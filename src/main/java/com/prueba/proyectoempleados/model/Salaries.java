package com.prueba.proyectoempleados.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "salaries")
@Getter
@Setter
@IdClass(SalaryPK.class)
public class Salaries {

    @Id
    @ManyToOne
    private Employee idempleado;

    @Id
    private Date fromDate;

    @Min(0)
    @NotNull
    private Integer salary;

    @Temporal(TemporalType.DATE)
    @Column(name = "to_date", nullable = false)
    private Date toDate;


}