package com.prueba.proyectoempleados.controller;

import com.prueba.proyectoempleados.dto.ErrorDTO;
import com.prueba.proyectoempleados.exception.EmployeeNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorDTO> getEmployeeNotFoundException(Exception e){
        return new ResponseEntity<>(new ErrorDTO("100",e.getMessage()), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorDTO> getDataIntegrityViolationException(Exception e){
        return new ResponseEntity<>(new ErrorDTO("101",e.getMessage()), HttpStatus.NOT_ACCEPTABLE);
    }


}

