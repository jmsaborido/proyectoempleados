package com.prueba.proyectoempleados.service.impl;

import com.prueba.proyectoempleados.dao.EmployeeRepository;
import com.prueba.proyectoempleados.dto.EmployeePostDTO;
import com.prueba.proyectoempleados.exception.EmployeeNotFoundException;
import com.prueba.proyectoempleados.mapper.EmployeeMapper;
import com.prueba.proyectoempleados.model.Employee;
import com.prueba.proyectoempleados.model.Gender;
import com.prueba.proyectoempleados.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();

    }

    @Override
    @Transactional
    public Employee addEmployee(EmployeePostDTO employeePostDTO) {
        Employee employee = new Employee();
        employeeMapper.updateEmployeeFromEmployeePostDTO(employeePostDTO, employee);
        return employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(int idEmployee, EmployeePostDTO employeePostDTO) throws EmployeeNotFoundException {
        Employee employee = employeeRepository.findById(idEmployee).orElseThrow(
                () -> new EmployeeNotFoundException(String.format("Employee not found id %d ", idEmployee))
        );
        employeeMapper.updateEmployeeFromEmployeePostDTO(employeePostDTO, employee);
        employeeRepository.save(employee);


    }

    @Override
    public void deleteEmployee(Integer idEmployee) throws EmployeeNotFoundException {
        employeeRepository.delete(
                employeeRepository.findById(idEmployee)
                        .orElseThrow(
                                () -> new EmployeeNotFoundException(String.format("Employee not found id %d ", idEmployee))
                        )
        );
    }

    @Override
    public List<Employee> getEmployeeByGender(Gender gender) {
        return employeeRepository.findAllByGender(gender);
    }

    @Override
    public List<Employee> getEmployeesByBirthdDate(Date startDate, Date endDate, Gender gender) {

        return employeeRepository.findAllByBirthDateBetweenAndGenderOrderByBirthDateAsc(startDate, endDate, gender);


    }

    @Override
    public Employee getEmployeeByCompleteName(String firstName, String lastName) throws EmployeeNotFoundException {
        return employeeRepository.findEmployeeByCompleteName(firstName, lastName)
                .orElseThrow(
                        () -> new EmployeeNotFoundException(String.format("Employee not found with name %s %s", firstName, lastName)
                        )
                );
    }
}
