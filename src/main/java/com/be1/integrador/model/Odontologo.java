package com.be1.integrador.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString @Getter @Setter
@Entity @Table(name="odontologos")
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class Odontologo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String matricula;
}
