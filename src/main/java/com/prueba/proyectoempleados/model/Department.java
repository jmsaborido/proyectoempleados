package com.prueba.proyectoempleados.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
@Getter
@Setter
public class Department {

    @Id
    @Column(name = "dept_no", length = 4)
    private String idDepartment;
    @Column(name = "dept_name", length = 40, unique = true, nullable = false)
    private String name;
    @OneToMany(mappedBy = "departmentId")
    private List<DepartmentEmployees> departmentEmployeesList = new ArrayList<>();
}
