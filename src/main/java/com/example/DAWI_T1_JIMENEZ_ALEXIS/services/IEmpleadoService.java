package com.example.DAWI_T1_JIMENEZ_ALEXIS.services;

import com.example.DAWI_T1_JIMENEZ_ALEXIS.dtos.EmpleadoRequestDTO;
import com.example.DAWI_T1_JIMENEZ_ALEXIS.dtos.EmpleadoResponseDTO;

import java.util.List;

public interface IEmpleadoService {

    List<EmpleadoResponseDTO> listarEmpleados();

    EmpleadoResponseDTO buscarEmpleado(Integer id);

    EmpleadoResponseDTO registrarEmpleado(EmpleadoRequestDTO request);

    EmpleadoResponseDTO actualizarEmpleado(Integer id, EmpleadoRequestDTO request);

    void eliminarEmpleado(Integer id);
}