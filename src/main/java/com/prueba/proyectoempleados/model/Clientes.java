package com.prueba.proyectoempleados.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
@Getter
@Setter
public class Clientes extends IdUuid{

    @Column(name = "nombre_cliente", nullable = false, length = 200)
    private String nombreCliente;

    @Embedded
    private Contacto contacto;

}
