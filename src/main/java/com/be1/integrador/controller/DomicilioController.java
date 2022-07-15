package com.be1.integrador.controller;

import com.be1.integrador.DTO.DomicilioDTO;
import com.be1.integrador.service.IDomicilioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/domicilio")
@Tag(name = "Domicilios", description = "Métodos disponibles para Domicilios")
public class DomicilioController {

    @Autowired
    IDomicilioService iDomicilioService;

    @Operation(summary = "Retorna una lista de todos los DOMICILIOS existentes")
    @GetMapping("/list")
    public Collection<DomicilioDTO> getAllDomicilio(){
        return iDomicilioService.findAllDomicilios();
    }

    @Operation(summary = "Retorna el DOMICILIO que coincida con el ID ")
    @GetMapping("/{id}")
    public DomicilioDTO getDomicilio(@PathVariable Long id){
        return iDomicilioService.findDomicilioById(id);
    }

    @Operation(summary = "Método para agregar un nuevo DOMICILIO")
    @PostMapping("/add")
    public ResponseEntity<?> saveDomicilio(@RequestBody DomicilioDTO domicilioDTO){
        iDomicilioService.saveDomicilio(domicilioDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Método para actualizar un DOMICILIO existente")
    @PutMapping("/update")
    public ResponseEntity<?> updateDomicilio(@RequestBody DomicilioDTO domicilioDTO){
        iDomicilioService.updateDomicilio(domicilioDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Método para eliminar el DOMICILIO que corresponda con el ID")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDomicilio(@PathVariable Long id){
        iDomicilioService.deleteDomicilio(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
