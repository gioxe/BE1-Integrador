package com.be1.integrador.service.impl;

import com.be1.integrador.DTO.OdontologoDTO;
import com.be1.integrador.model.Odontologo;
import com.be1.integrador.repository.IOdondologoRepository;
import com.be1.integrador.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class odontologoService implements IOdontologoService {

    @Autowired
    private IOdondologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    public void saveMethod(OdontologoDTO odontologoDTO){
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        odontologoRepository.save(odontologo);
    }

    @Override
    public Collection<OdontologoDTO> findAllOdontologo() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        Set<OdontologoDTO> odontologoDTO = new HashSet<>();

        for (Odontologo odontologo : odontologos) {
            odontologoDTO.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        return odontologoDTO;
    }
    @Override
    public OdontologoDTO findOdontologoById(Long id) {
        Odontologo odontologo = odontologoRepository.findById(id).orElseThrow();
        OdontologoDTO odontologoDTO = null;

        if (odontologo != null){
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
        }
        return odontologoDTO;
    }
    @Override
    public void saveOdontologo(OdontologoDTO newOdontologoDTO) {
        saveMethod(newOdontologoDTO);
    }
    @Override
    public void deleteOdontologo(Long id) {
        odontologoRepository.deleteById(id);
    }
    @Override
    public void updateOdontologo(OdontologoDTO newOdontologoDTO) {
        saveMethod(newOdontologoDTO);
    }
}