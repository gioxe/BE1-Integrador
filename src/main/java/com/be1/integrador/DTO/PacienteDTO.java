package com.be1.integrador.DTO;

import com.be1.integrador.model.Domicilio;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String fechaAlta;
    private Domicilio domicilio;
}
