package com.prueba.proyectoempleados.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
//import javax.validation.constrains.Min;
import java.util.Date;

@Entity
@Table(name = "salaries")
@Getter
@Setter
public class Salaries {

    @Id
    private Integer idempleado;

    @Temporal(TemporalType.DATE)
    private Date fromDate;

//    @Min
    private Integer salary;

    @Temporal(TemporalType.DATE)
    @Column(name ="to_date", nullable = false)
    private Date toDate;

}
