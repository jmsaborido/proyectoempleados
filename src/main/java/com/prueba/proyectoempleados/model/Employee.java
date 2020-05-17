package com.prueba.proyectoempleados.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "employees", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"first_name","last_name"})
})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_no")
    private Integer idEmployee;
    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date", nullable = false)
    private Date birthDate;
    @Column(name = "first_name", nullable = false, length = 14)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 16)
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Temporal(TemporalType.DATE)
    @Column(name = "hire_date", nullable = false)
    private Date hireDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idempleado")
    private List<Salaries> salaries;

}
