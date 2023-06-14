package com.prevencion.seguridad.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prevencion.seguridad.models.Permiso;
import com.prevencion.seguridad.models.Usuario;
import com.prevencion.seguridad.repositories.UsuarioRepository;

@Service
public class UsuariosService {
    
    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private PermisosService permisosService;

    public Usuario createUser(Usuario user) {
        return userRepository.save(user);
    }

    public Usuario updateUser(int id, Usuario user) {
        
        Usuario usuario = getUser(id);
        
        List<Permiso> permisos = permisosService.getAllPermisos();

        for(Permiso permiso :  user.getPermissions()) {
            
            //Permiso per = permisosService.getPermiso(permiso.getCodigo());

            int posicion = permisos.indexOf(permiso);
            Permiso per = permisos.get(posicion);

            permiso.setNombre(per.getNombre());
        }

        user.setCodigo(id);
        user.setPassword(usuario.getPassword());
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

    public Usuario findByNombre(String username) {
        return userRepository.findByNombre(username);
    }
}
