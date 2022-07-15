package com.be1.integrador.service;

import com.be1.integrador.DTO.PacienteDTO;

import java.util.Collection;

public interface IPacienteService {
    Collection<PacienteDTO> findAllPacientes();
    PacienteDTO findPacienteById(Long id);
    void savePaciente(PacienteDTO newPacienteDTO);
    void deletePaciente(Long id);
    void updatePaciente(PacienteDTO newPacienteDTO);
}
