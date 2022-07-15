package com.be1.integrador.controller;

import com.be1.integrador.DTO.PacienteDTO;
import com.be1.integrador.service.IPacienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/paciente")
@Tag(name = "Paciente", description = "Métodos disponibles para Paciente")
public class PacienteController {

    @Autowired
    IPacienteService iPacienteService;

    @Operation(summary = "Retorna una lista de todos los PACIENTES existentes")
    @GetMapping("/list")
    public Collection<PacienteDTO> getAllPaciente(){
        return iPacienteService.findAllPacientes();
    }

    @Operation(summary = "Retorna el PACIENTE que coincida con el ID ")
    @GetMapping("/{id}")
    public PacienteDTO getPaciente(@PathVariable Long id){
        return iPacienteService.findPacienteById(id);
    }

    @Operation(summary = "Método para agregar un nuevo PACIENTE")
    @PostMapping("/add")
    public ResponseEntity<?> savePaciente(@RequestBody PacienteDTO pacienteDTO){
        iPacienteService.savePaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Método para actualizar un PACIENTE existente")
    @PutMapping("/update")
    public ResponseEntity<?> updatePaciente(@RequestBody PacienteDTO pacienteDTO){
        iPacienteService.updatePaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Método para eliminar el PACIENTE que corresponda con el ID")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePaciente(@PathVariable Long id){
        iPacienteService.deletePaciente(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
