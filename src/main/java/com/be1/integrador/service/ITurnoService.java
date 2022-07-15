package com.be1.integrador.service;

import com.be1.integrador.DTO.TurnoDTO;
import com.be1.integrador.DTO.TurnoResponseDTO;

import java.util.Collection;

public interface ITurnoService {
    Collection<TurnoResponseDTO> findAllTurnos();
    TurnoDTO findTurnoById(Long id);
    void saveTurno(TurnoDTO newTurnoDTO);
    void deleteTurno(Long id);
    void updateTurno(TurnoDTO newTurnoDTO);
}
