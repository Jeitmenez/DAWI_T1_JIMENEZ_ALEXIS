package com.example.DAWI_T1_JIMENEZ_ALEXIS.services;

import com.example.DAWI_T1_JIMENEZ_ALEXIS.dtos.EmpleadoRequestDTO;
import com.example.DAWI_T1_JIMENEZ_ALEXIS.dtos.EmpleadoResponseDTO;
import com.example.DAWI_T1_JIMENEZ_ALEXIS.entity.EmpleadoEntity;
import com.example.DAWI_T1_JIMENEZ_ALEXIS.exceptions.ResourceNotFoundException;
import com.example.DAWI_T1_JIMENEZ_ALEXIS.repositories.IEmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements IEmpleadoService {

    private final IEmpleadoRepository empleadoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<EmpleadoResponseDTO> listarEmpleados() {
        return empleadoRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public EmpleadoResponseDTO buscarEmpleado(Integer id) {
        EmpleadoEntity entity = findEntityOrThrow(id);
        return toResponseDTO(entity);
    }

    @Override
    @Transactional
    public EmpleadoResponseDTO registrarEmpleado(EmpleadoRequestDTO request) {
        EmpleadoEntity entity = EmpleadoEntity.builder()
                .nombre(request.getNombre().trim())
                .apellido(request.getApellido().trim())
                .email(request.getEmail().trim())
                .especialidad(normalizeOptional(request.getEspecialidad()))
                .build();

        EmpleadoEntity saved = empleadoRepository.save(entity);
        return toResponseDTO(saved);
    }

    @Override
    @Transactional
    public EmpleadoResponseDTO actualizarEmpleado(Integer id, EmpleadoRequestDTO request) {
        EmpleadoEntity entity = findEntityOrThrow(id);

        entity.setNombre(request.getNombre().trim());
        entity.setApellido(request.getApellido().trim());
        entity.setEmail(request.getEmail().trim());
        entity.setEspecialidad(normalizeOptional(request.getEspecialidad()));

        EmpleadoEntity updated = empleadoRepository.save(entity);
        return toResponseDTO(updated);
    }

    @Override
    @Transactional
    public void eliminarEmpleado(Integer id) {
        EmpleadoEntity entity = findEntityOrThrow(id);
        empleadoRepository.delete(entity);
    }

    private EmpleadoEntity findEntityOrThrow(Integer id) {
        return empleadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado no encontrado con ID: " + id));
    }

    private String normalizeOptional(String especialidad) {
        if (especialidad == null || especialidad.isBlank()) {
            return null;
        }
        return especialidad.trim();
    }

    private EmpleadoResponseDTO toResponseDTO(EmpleadoEntity entity) {
        return EmpleadoResponseDTO.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .apellido(entity.getApellido())
                .email(entity.getEmail())
                .especialidad(entity.getEspecialidad())
                .build();
    }
}