package com.prueba.proyectoempleados.dao;

import com.prueba.proyectoempleados.model.Employee;
import com.prueba.proyectoempleados.model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findAllByGender(Gender gender);

    List<Employee> findAll();

    List<Employee> findAllByBirthDateBetweenAndGenderOrderByBirthDateAsc(Date dateInit, Date dateEnd, Gender gender);

    @Query("select e from Employee e where e.firstName=:firstName and e.lastName=:lastName")
    Optional<Employee> findEmployeeByCompleteName(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
