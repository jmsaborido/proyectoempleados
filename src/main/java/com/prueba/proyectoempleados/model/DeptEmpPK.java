package com.prueba.proyectoempleados.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@Getter
@Setter
public class DeptEmpPK implements Serializable {

    @ManyToOne()
    @JoinColumn(name = "emp_no")
    private Employee empleadoId;
    @ManyToOne()
    @JoinColumn(name = "dept_no")
    private Department departmentId;



}
