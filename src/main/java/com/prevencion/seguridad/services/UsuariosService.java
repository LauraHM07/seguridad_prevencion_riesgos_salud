package com.prevencion.seguridad.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prevencion.seguridad.models.Usuario;
import com.prevencion.seguridad.repositories.UsuarioRepository;

@Service
public class UsuariosService {
    
    @Autowired
    private UsuarioRepository userRepository;

    public Usuario createUser(Usuario user) {
        return userRepository.save(user);
    }

    public Usuario updateUser(int id, Usuario user) {
        user.setCodigo(id); 
        return userRepository.save(user);
    }

    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }

    public Usuario getUser(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public List<Usuario> getAllUsers() {
        return userRepository.findAll();
    }
}
