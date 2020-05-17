package com.prueba.proyectoempleados.service;

import com.prueba.proyectoempleados.dao.EmployeeRepository;
import com.prueba.proyectoempleados.dto.EmployeeDTO;
import com.prueba.proyectoempleados.exception.EmployeeNotFoundException;
import com.prueba.proyectoempleados.mapper.EmployeeMapper;
import com.prueba.proyectoempleados.model.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmployeeMapper employeeMapper;
    @MockBean
    EmployeeRepository employeeRepository;

    @BeforeEach
    public void setup() {
        Employee employeeMock = new Employee();
        employeeMock.setFirstName("Manuel");
        employeeMock.setLastName("Millan");
        Optional<Employee> optEmployee = Optional.of(employeeMock);
        Mockito.when(employeeRepository.findEmployeeByCompleteName("Manuel", "Millan")).thenReturn(optEmployee);
    }

    @Test
    void getEmployeeByNameTest() throws EmployeeNotFoundException {
        EmployeeDTO employeeDTO = employeeMapper.employeeToEmployeeDTO(
                employeeService.getEmployeeByCompleteName("Manuel", "Millan")
        );
        EmployeeDTO employeeEsperado = new EmployeeDTO();
        employeeEsperado.setName("Manuel");
        employeeEsperado.setLastName("Millan");
        Assertions.assertThat(employeeDTO).isEqualToComparingOnlyGivenFields(employeeEsperado, "name", "lastName");
    }

    @Test
    void getEmployeeNotFoundExceptionTest() {
        Assertions.assertThatExceptionOfType(EmployeeNotFoundException.class).isThrownBy(() -> employeeService.getEmployeeByCompleteName("", ""));
    }

}
