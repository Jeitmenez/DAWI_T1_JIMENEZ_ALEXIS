package com.example.DAWI_T1_JIMENEZ_ALEXIS.repositories;

import com.example.DAWI_T1_JIMENEZ_ALEXIS.entity.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpleadoRepository extends JpaRepository<EmpleadoEntity, Integer> {
}