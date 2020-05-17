package com.prueba.proyectoempleados.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Embeddable
@Getter
@Setter
public class Contacto {

    @Column(length = 200)
    private String direccion;
    @Column(length = 100)
    private String poblacion;
    @Column(length = 50)
    private String cp;
    @Column(length = 50)
    private String provincia;

}
