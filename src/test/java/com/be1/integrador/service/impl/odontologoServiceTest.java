package com.be1.integrador.service.impl;

import com.be1.integrador.DTO.OdontologoDTO;
import com.be1.integrador.service.IOdontologoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class odontologoServiceTest {

    @Autowired
    IOdontologoService odontologoService;

    @Test
    public void testAddOdontologo() {

        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("NombreTest");
        odontologoDTO.setApellido("ApellidoTest");
        odontologoDTO.setMatricula("MatriculaTest");
        odontologoService.saveOdontologo(odontologoDTO);

        OdontologoDTO odontologoTest = odontologoService.findOdontologoById(1L);

        assertNotNull(odontologoTest);
    }

}