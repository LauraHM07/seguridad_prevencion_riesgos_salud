package com.prevencion.seguridad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prevencion.seguridad.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByNombre(String username);
}
