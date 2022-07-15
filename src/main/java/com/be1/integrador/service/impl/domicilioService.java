package com.be1.integrador.service.impl;

import com.be1.integrador.DTO.DomicilioDTO;
import com.be1.integrador.model.Domicilio;
import com.be1.integrador.repository.IDomicilioRepository;
import com.be1.integrador.service.IDomicilioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class domicilioService implements IDomicilioService {

    @Autowired
    private IDomicilioRepository domicilioRepository;

    @Autowired
    ObjectMapper mapper;

    public void saveMethod(DomicilioDTO domicilioDTO) {
        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
        domicilioRepository.save(domicilio);
    }
    @Override
    public Collection<DomicilioDTO> findAllDomicilios() {
        List<Domicilio> domicilios = domicilioRepository.findAll();
        Set<DomicilioDTO> domicilioDTO = new HashSet<>();
        for (Domicilio domicilio : domicilios) {
            domicilioDTO.add(mapper.convertValue(domicilio, DomicilioDTO.class));
        }
        return domicilioDTO;
    }

    @Override
    public DomicilioDTO findDomicilioById(Long id) {
        Domicilio domicilio = domicilioRepository.findById(id).orElseThrow();
        DomicilioDTO domicilioDTO = null;
        if (domicilio.getId()!=null) {
            domicilioDTO = mapper.convertValue(domicilio, DomicilioDTO.class);
        }
        return domicilioDTO;
    }

    @Override
    public void saveDomicilio(DomicilioDTO nuevoDomicilioDTO) {
        saveMethod(nuevoDomicilioDTO);
    }

    @Override
    public void deleteDomicilio(Long id) {
        domicilioRepository.deleteById(id);
    }

    @Override
    public void updateDomicilio(DomicilioDTO nuevoDomicilioDTO) {
        saveMethod(nuevoDomicilioDTO);
    }
}
