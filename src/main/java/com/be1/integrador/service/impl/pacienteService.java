package com.be1.integrador.service.impl;

import com.be1.integrador.model.Domicilio;
import com.be1.integrador.DTO.PacienteDTO;
import com.be1.integrador.model.Paciente;
import com.be1.integrador.repository.IDomicilioRepository;
import com.be1.integrador.repository.IPacienteRepository;
import com.be1.integrador.service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class pacienteService implements IPacienteService {

    @Autowired
    private IPacienteRepository pacienteRepository;
    @Autowired
    private IDomicilioRepository domicilioRepository;

    @Autowired
    ObjectMapper mapper;

    public void saveMethod(PacienteDTO pacienteDTO) {
        Domicilio domicilioDTO = pacienteDTO.getDomicilio();
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
        domicilio.setId(paciente.getId());
        if (paciente.getDomicilio() == null) {
            paciente.setDomicilio(domicilio);
        }
        pacienteRepository.save(paciente);
    }

    @Override
    public Collection<PacienteDTO> findAllPacientes() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        Set<PacienteDTO> pacienteDTO = new HashSet<>();

        for (Paciente paciente : pacientes) {
            Domicilio domicilio = domicilioRepository.findById(paciente.getId()).orElseThrow();
            if(domicilio!=null){
                paciente.setDomicilio(domicilio);
            }
            pacienteDTO.add(mapper.convertValue(paciente, PacienteDTO.class));
        }
        return pacienteDTO;
    }

    @Override
    public PacienteDTO findPacienteById(Long id) {
        Paciente paciente = pacienteRepository.findById(id).orElseThrow();
        PacienteDTO pacienteDTO = null;
        if (paciente.getId()!=null) {
            pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
        }
        return pacienteDTO;
    }

    @Override
    public void savePaciente(PacienteDTO nuevoPacienteDTO) {
        saveMethod(nuevoPacienteDTO);
    }

    @Override
    public void deletePaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public void updatePaciente(PacienteDTO nuevoPacienteDTO) {
        saveMethod(nuevoPacienteDTO);
    }
}
