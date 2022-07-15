package com.be1.integrador.service.impl;

import com.be1.integrador.DTO.TurnoDTO;
import com.be1.integrador.DTO.TurnoResponseDTO;
import com.be1.integrador.model.Domicilio;
import com.be1.integrador.model.Odontologo;
import com.be1.integrador.model.Paciente;
import com.be1.integrador.model.Turno;
import com.be1.integrador.repository.IDomicilioRepository;
import com.be1.integrador.repository.IOdondologoRepository;
import com.be1.integrador.repository.IPacienteRepository;
import com.be1.integrador.repository.ITurnoRepository;
import com.be1.integrador.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class turnoService implements ITurnoService {
    @Autowired
    private ITurnoRepository turnoRepository;
    @Autowired
    private IPacienteRepository pacienteRepository;
    @Autowired
    private IOdondologoRepository odontologoRepository;
    @Autowired
    private IDomicilioRepository domicilioRepository;

    @Autowired
    ObjectMapper mapper;

    public void saveMethod(TurnoDTO turnoDTO){
        Odontologo odontologo = odontologoRepository.findById(turnoDTO.getId_odontologo()).get();
        Paciente paciente = pacienteRepository.findById(turnoDTO.getId_paciente()).get();

        Turno turno = mapper.convertValue(turnoDTO, Turno.class);

        if (odontologo != null) {
            turno.setOdontologo(odontologo);
        }
        if (paciente != null) {
            turno.setPaciente(paciente);
        }
        turnoRepository.save(turno);
    }

    @Override
    public Collection<TurnoResponseDTO> findAllTurnos() {
        List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoResponseDTO> turnoResponseDTO = new HashSet<>();

        for (Turno turno : turnos) {
            //Long pacienteId = turno.getPaciente().getId();
            Paciente paciente = pacienteRepository.findById(turno.getPaciente().getId()).orElseThrow();
            Odontologo odontologo = odontologoRepository.findById(turno.getOdontologo().getId()).orElseThrow();
            Domicilio domicilio = domicilioRepository.findById(paciente.getId()).orElseThrow();

            if (paciente != null) {
                paciente.setDomicilio(domicilio);
                turno.setPaciente(paciente);
            }
            if (odontologo != null) {
                turno.setOdontologo(odontologo);
            }
            turnoResponseDTO.add(mapper.convertValue(turno, TurnoResponseDTO.class));
        }
        return turnoResponseDTO;
    }

    @Override
    public TurnoDTO findTurnoById(Long id) {
        Turno turn = turnoRepository.findById(id).orElseThrow();
        TurnoDTO turnDTO = null;
        turnDTO = mapper.convertValue(turn, TurnoDTO.class);
        return turnDTO;
    }

    @Override
    public void saveTurno(TurnoDTO newTurnoDTO) {
        saveMethod(newTurnoDTO);
    }

    @Override
    public void deleteTurno(Long id) {
        turnoRepository.deleteById(id);
    }

    @Override
    public void updateTurno(TurnoDTO newTurnoDTO) {
        saveMethod(newTurnoDTO);
    }
}
