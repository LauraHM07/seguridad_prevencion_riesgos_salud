package com.prevencion.seguridad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prevencion.seguridad.models.Permiso;

public interface PermisoRepository extends JpaRepository<Permiso, Integer> {
    
}
