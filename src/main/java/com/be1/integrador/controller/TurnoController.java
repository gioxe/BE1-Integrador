package com.be1.integrador.controller;

import com.be1.integrador.DTO.TurnoDTO;
import com.be1.integrador.DTO.TurnoResponseDTO;
import com.be1.integrador.service.ITurnoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/turno")
@RestController
@Tag(name = "Turno", description = "Métodos disponibles para Turno")
public class TurnoController {
    @Autowired
    ITurnoService iTurnoService;

    @Operation(summary = "Retorna una lista de todos los TURNOS existentes")
    @GetMapping("/list")
    public Collection<TurnoResponseDTO> getAllTurnos() {
        return iTurnoService.findAllTurnos();
    }

    @Operation(summary = "Retorna el TURNO que coincida con el ID ")
    @GetMapping("/{id}")
    public TurnoDTO getTurno(@PathVariable Long id) {
        return iTurnoService.findTurnoById(id);
    }

    @Operation(summary = "Método para agregar un nuevo TURNO")
    @PostMapping("/add")
    public ResponseEntity<?> saveTurno(@RequestBody TurnoDTO turnoDTO) {
        iTurnoService.saveTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Método para actualizar un TURNO existente")
    @PutMapping("/update")
    public ResponseEntity<?> updateTurno(@RequestBody TurnoDTO turnoDTO) {
        iTurnoService.updateTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Método para eliminar el TURNO que corresponda con el ID")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTurno(@PathVariable Long id) {
        iTurnoService.deleteTurno(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}