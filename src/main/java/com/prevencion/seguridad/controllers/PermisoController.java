package com.prevencion.seguridad.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prevencion.seguridad.models.Permiso;
import com.prevencion.seguridad.services.PermisosService;

@RestController
public class PermisoController {
    
    @Autowired
    PermisosService permisosService;

    @GetMapping("/permisos")
    List<Permiso> all() {
        return permisosService.getAllPermisos();
    }

    @GetMapping("/permisos/{codigo}")
    Permiso findUsuario(@PathVariable int codigo) {
        return permisosService.getPermiso(codigo);
    }

    @DeleteMapping("/permisos/{codigo}")
    void deleteUsuario(@PathVariable int codigo) {
        permisosService.deletePermiso(codigo);
    }

    @PostMapping("/permisos")
    Permiso crearUsuario(@RequestBody Permiso permiso) {
        permisosService.createPermiso(permiso);
        return permiso;
    }

    @PutMapping("/permisos/{codigo}")
    void modificarUsuario(@PathVariable int codigo, @RequestBody Permiso permiso) {
        permisosService.updatePermiso(codigo, permiso);
    }
}
