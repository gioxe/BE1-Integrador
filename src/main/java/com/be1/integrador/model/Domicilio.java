package com.be1.integrador.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;

@Entity @Table(name="domicilios")
@Getter @Setter @ToString

@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;
}