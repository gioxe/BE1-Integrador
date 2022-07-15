package com.be1.integrador.controller;

import com.be1.integrador.DTO.OdontologoDTO;
import com.be1.integrador.service.IOdontologoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/odontologo")
@Tag(name = "Odontólogos", description = "Métodos disponibles para Odontólogos")
public class OdontologoController {

    @Autowired
    IOdontologoService iOdontologoService;

    @Operation(summary = "Retorna una lista de todos los ODONTÓLOGOS existentes")
    @GetMapping("/list")
    public Collection<OdontologoDTO> getAllOdontologo(){
        return iOdontologoService.findAllOdontologo();
    }

    @Operation(summary = "Retorna el ODONTÓLOGO que coincida con el ID ")
    @GetMapping("/{id}")
    public OdontologoDTO getOdontologo(@PathVariable Long id){
        return iOdontologoService.findOdontologoById(id);
    }

    @Operation(summary = "Método para agregar un nuevo ODONTÓLOGO")
    @PostMapping("/add")
    public ResponseEntity<?> saveOdontologo(@RequestBody OdontologoDTO odontologoDTO){
        iOdontologoService.saveOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Método para actualizar un ODONTÓLOGO existente")
    @PutMapping("/update")
    public ResponseEntity<?> updateOdontologo(@RequestBody OdontologoDTO odontologoDTO){
        iOdontologoService.updateOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Método para eliminar el ODONTÓLOGO que corresponda con el ID")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOdontologo(@PathVariable Long id){
        iOdontologoService.deleteOdontologo(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
