package com.prueba.proyectoempleados.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.prueba.proyectoempleados.model.Gender;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeePostDTO {
    private Date birthDate;
    private String firstName;
    private String lastName;
    private Gender gender;
    private Date hireDate;

}
