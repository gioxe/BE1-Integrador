package com.be1.integrador.service.impl;

import com.be1.integrador.DTO.DomicilioDTO;
import com.be1.integrador.service.IDomicilioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class domicilioServiceTest {

    @Autowired
    IDomicilioService domicilioService;

    @Test
    public void testAddDomicilio() {

        DomicilioDTO domicilioDTO = new DomicilioDTO();
        domicilioDTO.setCalle("calle");
        domicilioDTO.setLocalidad("localidad");
        domicilioDTO.setNumero("numero");
        domicilioDTO.setProvincia("provincia");
        domicilioService.saveDomicilio(domicilioDTO);

        DomicilioDTO domicilioTest = domicilioService.findDomicilioById(1L);

        assertNotNull(domicilioTest);
    }

}
