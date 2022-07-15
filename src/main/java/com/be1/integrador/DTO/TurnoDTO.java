package com.be1.integrador.DTO;

import com.be1.integrador.model.Odontologo;
import com.be1.integrador.model.Paciente;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TurnoDTO{
    private Long id;
    private Long id_odontologo;
    private Long id_paciente;
    private String date;
}


