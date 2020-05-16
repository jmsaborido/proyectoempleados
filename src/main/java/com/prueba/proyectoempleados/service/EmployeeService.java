package com.prueba.proyectoempleados.service;

import com.prueba.proyectoempleados.dto.EmployeePostDTO;
import com.prueba.proyectoempleados.exception.EmployeeNotFoundException;
import com.prueba.proyectoempleados.model.Employee;
import com.prueba.proyectoempleados.model.Gender;

import java.util.Date;
import java.util.List;

public interface EmployeeService {
        List<Employee> findAll();
        Employee addEmployee(EmployeePostDTO employeePostDTO);

        void updateEmployee(int idEmployee, EmployeePostDTO employeePostDTO) throws EmployeeNotFoundException;

        void deleteEmployee(Integer idEmployee) throws EmployeeNotFoundException;

        List<Employee> getEmployeeByGender(Gender gender);

        List<Employee> getEmployeesByBirthdDate(Date startDate, Date endDate, Gender gender);

        Employee getEmployeeByCompleteName(String firstName, String lastName) throws EmployeeNotFoundException;
}
