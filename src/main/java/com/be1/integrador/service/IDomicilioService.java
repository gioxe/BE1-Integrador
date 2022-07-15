package com.be1.integrador.service;

import com.be1.integrador.DTO.DomicilioDTO;

import java.util.Collection;

public interface IDomicilioService {
    Collection<DomicilioDTO> findAllDomicilios();
    DomicilioDTO findDomicilioById(Long id);
    void saveDomicilio(DomicilioDTO nuevoDomicilioDTO);
    void deleteDomicilio(Long id);
    void updateDomicilio(DomicilioDTO nuevoDomicilioDTO);
}
