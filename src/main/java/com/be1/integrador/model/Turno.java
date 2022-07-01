package com.be1.integrador.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString @NonNull @Setter @Getter
@Entity @Table(name = "turnos")

@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    @JoinColumn(name = "id_odontologo",referencedColumnName = "id")
    private Odontologo odontologo;

    @ManyToOne(fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    @JoinColumn(name = "id_paciente", referencedColumnName = "id")
    private Paciente paciente;

    private String date;
}