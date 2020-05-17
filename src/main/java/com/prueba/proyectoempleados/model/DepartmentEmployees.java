package com.prueba.proyectoempleados.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dept_emp")
@Getter
@Setter
@IdClass(DeptEmpPK.class)
public class DepartmentEmployees {

    @Id
    @ManyToOne
    private Employee empleadoId;
    @Id
    @ManyToOne
    private Department departmentId;

    @Column(name = "from_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fromDate;

    @Column(name = "to_date")
    @Temporal(TemporalType.DATE)
    private Date toDate;
}
