package com.prueba.proyectoempleados.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "proveedores")
@Getter
@Setter
public class Proveedores extends IdUuid{

    @Column(name = "nombre_proveedor", nullable = false, length = 200)
    private String nombreProveedor;

    @Embedded
    private Contacto contacto;
    
}
