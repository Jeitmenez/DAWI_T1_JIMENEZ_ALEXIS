package com.example.DAWI_T1_JIMENEZ_ALEXIS.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpleadoResponseDTO {

    private Integer id;
    private String nombre;
    private String apellido;
    private String email;
    private String especialidad;
}