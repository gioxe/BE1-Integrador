package com.be1.integrador.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;

@ToString @Getter @Setter
@Entity @Table(name = "pacientes")
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class Paciente{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellido;
    private String dni;
    private String fechaAlta;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="id_domicilio", referencedColumnName = "id")
    private Domicilio domicilio;
}
