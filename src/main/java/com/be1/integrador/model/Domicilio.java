package com.be1.integrador.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString @Getter @Setter
@Entity @Table(name="domicilios")

@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;
}