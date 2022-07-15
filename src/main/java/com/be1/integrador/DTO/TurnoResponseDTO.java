package com.be1.integrador.DTO;

import com.be1.integrador.model.Odontologo;
import com.be1.integrador.model.Paciente;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TurnoResponseDTO {
    private Long id;
    private Odontologo odontologo;
    private Paciente paciente;
    private String date;
}