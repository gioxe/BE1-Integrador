package com.be1.integrador.service;

import com.be1.integrador.DTO.OdontologoDTO;

import java.util.Collection;

public interface IOdontologoService {
    Collection<OdontologoDTO> findAllOdontologo();
    OdontologoDTO findOdontologoById(Long id);
    void saveOdontologo(OdontologoDTO newOdontologoDTO);
    void deleteOdontologo(Long id);
    void updateOdontologo(OdontologoDTO newOdontologoDTO);
}
