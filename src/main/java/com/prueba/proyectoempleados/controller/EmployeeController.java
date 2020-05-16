package com.prueba.proyectoempleados.controller;

import com.prueba.proyectoempleados.dto.EmployeeDTO;
import com.prueba.proyectoempleados.dto.EmployeePostDTO;
import com.prueba.proyectoempleados.exception.EmployeeNotFoundException;
import com.prueba.proyectoempleados.mapper.EmployeeMapper;
import com.prueba.proyectoempleados.model.Gender;
import com.prueba.proyectoempleados.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping
    public List<EmployeeDTO> getAll() {
        return employeeMapper.listEmployeeToListEmployeeDTO(employeeService.findAll());
    }

    @PostMapping
    public EmployeeDTO addEmployee(@RequestBody EmployeePostDTO employeePostDTO) {
        return employeeMapper.employeeToEmployeeDTO(employeeService.addEmployee(employeePostDTO));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateEmployee(@PathVariable("id") Integer idEmployee, @RequestBody EmployeePostDTO employeePostDTO) throws EmployeeNotFoundException {
        employeeService.updateEmployee(idEmployee, employeePostDTO);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmployee(@PathVariable("id") Integer idEmployee) throws EmployeeNotFoundException {
        employeeService.deleteEmployee(idEmployee);

    }

    @GetMapping("/gender/{gender}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<EmployeeDTO> getEmployeeByGender(@PathVariable("gender") Gender gender) {
        return employeeMapper.listEmployeeToListEmployeeDTO(employeeService.getEmployeeByGender(gender));
    }

    @GetMapping("/searchbirthdate")
    @ResponseStatus(HttpStatus.FOUND)
    public List<EmployeeDTO> getEmployeesByDateAndGender
            (
                    @RequestParam(name = "startdate") @DateTimeFormat(pattern = "dd.MM.yyyy") Date startDate,
                    @RequestParam(name = "enddate") @DateTimeFormat(pattern = "dd.MM.yyyy") Date endDate,
                    @RequestParam(name = "gender", required = false, defaultValue = "M") Gender gender
            ) {
        return employeeMapper.listEmployeeToListEmployeeDTO(employeeService.getEmployeesByBirthdDate(startDate,endDate,gender));
    }
    @GetMapping("/searchName")
    @ResponseStatus(HttpStatus.FOUND)
    public EmployeeDTO getEmployeesByCompleteName
            (
                    @RequestParam(name = "firstName") String firstName,
                    @RequestParam(name = "lastName")  String lastName
            ) throws EmployeeNotFoundException {
        return employeeMapper.employeeToEmployeeDTO(employeeService.getEmployeeByCompleteName(firstName,lastName));
    }
}
