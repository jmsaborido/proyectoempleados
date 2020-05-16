package com.prueba.proyectoempleados.mapper;

import com.prueba.proyectoempleados.dto.EmployeeDTO;
import com.prueba.proyectoempleados.dto.EmployeePostDTO;
import com.prueba.proyectoempleados.model.Employee;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    @Mapping(source = "idEmployee",target = "id")
    @Mapping(source = "firstName",target = "name")
    EmployeeDTO employeeToEmployeeDTO(Employee employee);

    @InheritInverseConfiguration
    Employee employeeDTOToEmployee(EmployeeDTO employeeDTO);


   List<EmployeeDTO> listEmployeeToListEmployeeDTO(List<Employee> employees);

   void updateEmployeeFromEmployeePostDTO(EmployeePostDTO employeePostDTO, @MappingTarget Employee employee);

    Employee employeePostDTOToEmployee(EmployeePostDTO employeePostDTO);
}
