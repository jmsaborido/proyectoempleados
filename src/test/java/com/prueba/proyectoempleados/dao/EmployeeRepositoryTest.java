package com.prueba.proyectoempleados.dao;

import com.prueba.proyectoempleados.model.Employee;
import com.prueba.proyectoempleados.model.Gender;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@DataJpaTest
public class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void getAllEmployeeTest() {
        List<Employee> employees = employeeRepository.findAll();
        Assertions.assertThat(employees.size()).isEqualTo(3);
    }

    @Test
    public void getAllByGender() {
        List<Employee> employees = employeeRepository.findAllByGender(Gender.M);
        Assertions.assertThat(employees).allMatch(employee -> employee.getGender().equals(Gender.M));
    }

    @Test
    public void findAllByBirthDateBetweenAndGenderOrderByBirthDateAscTest() throws ParseException {
        Date dateReferenceIni = new SimpleDateFormat("yyyy-MM-dd").parse("01-01-1976");
        Date dateReferenceEnd = new SimpleDateFormat("yyyy-MM-dd").parse("01-01-1991");
        List<Employee> employees = employeeRepository.findAllByBirthDateBetweenAndGenderOrderByBirthDateAsc
                (dateReferenceIni, dateReferenceEnd, Gender.M);
        Assertions.assertThat(employees).allMatch(
                employee ->
                        employee.getBirthDate().compareTo(dateReferenceIni) >= 0 &&
                                employee.getBirthDate().compareTo(dateReferenceIni) <= 0 &&
                                employee.getGender().equals(Gender.M));
    }

    @Test
    public void findEmployeeByCompleteNameTest(){
        String firstName="Manuel";
        String lastName="Millan";
        Optional<Employee> optEmployee= employeeRepository.findEmployeeByCompleteName(firstName,lastName);
        Assertions.assertThat(optEmployee.isPresent()).isTrue();
        Assertions.assertThat(optEmployee.get().getFirstName()).isEqualTo(firstName);
        Assertions.assertThat(optEmployee.get().getLastName()).isEqualTo(lastName);

    }
}
