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

import com.prevencion.seguridad.models.Usuario;
import com.prevencion.seguridad.services.UsuariosService;

@RestController
public class UsuarioController {

    @Autowired
    UsuariosService usuarioService;

    @GetMapping("/usuarios")
    List<Usuario> all() {
        return usuarioService.getAllUsers();
    }

    @GetMapping("/usuarios/{codigo}")
    Usuario findUsuario(@PathVariable int codigo) {
        return usuarioService.getUser(codigo);
    }

    @DeleteMapping("/usuarios/{codigo}")
    void deleteUsuario(@PathVariable int codigo) {
        usuarioService.deleteUser(codigo);
    }

    @PostMapping("/usuarios")
    Usuario crearUsuario(@RequestBody Usuario usuario) {
        usuarioService.createUser(usuario);
        return usuario;
    }

    @PutMapping("/usuarios/{codigo}")
    void modificarUsuario(@PathVariable int codigo, @RequestBody Usuario usuario) {
        usuarioService.updateUser(codigo, usuario);
    }
}
