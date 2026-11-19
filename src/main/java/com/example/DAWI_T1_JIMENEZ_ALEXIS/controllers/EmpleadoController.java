package com.example.DAWI_T1_JIMENEZ_ALEXIS.controllers;

import com.example.DAWI_T1_JIMENEZ_ALEXIS.dtos.EmpleadoRequestDTO;
import com.example.DAWI_T1_JIMENEZ_ALEXIS.dtos.EmpleadoResponseDTO;
import com.example.DAWI_T1_JIMENEZ_ALEXIS.services.IEmpleadoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/empleados")
@RequiredArgsConstructor
public class EmpleadoController {

    private final IEmpleadoService empleadoService;

    @GetMapping
    public ResponseEntity<List<EmpleadoResponseDTO>> listarEmpleados() {
        return ResponseEntity.ok(empleadoService.listarEmpleados());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoResponseDTO> buscarEmpleado(@PathVariable Integer id) {
        return ResponseEntity.ok(empleadoService.buscarEmpleado(id));
    }

    @PostMapping
    public ResponseEntity<EmpleadoResponseDTO> registrarEmpleado(@Valid @RequestBody EmpleadoRequestDTO request) {
        EmpleadoResponseDTO created = empleadoService.registrarEmpleado(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoResponseDTO> actualizarEmpleado(
            @PathVariable Integer id,
            @Valid @RequestBody EmpleadoRequestDTO request) {
        return ResponseEntity.ok(empleadoService.actualizarEmpleado(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable Integer id) {
        empleadoService.eliminarEmpleado(id);
        return ResponseEntity.noContent().build();
    }
}