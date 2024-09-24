// File: src/main/java/io/bootify/my_app/ControlAcceso/AuthenticationService.java
package io.bootify.my_app.ControlAcceso;

import io.bootify.my_app.domain.Usuario;
import io.bootify.my_app.repos.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public String authenticate(String nombreUsuario, String contraseña) {
        return usuarioRepository.findByNombre(nombreUsuario)
                .map(usuario -> {
                    if (usuario.getContraseña().equals(contraseña)) {
                        return "Autenticación exitosa";
                    } else {
                        return "Contraseña incorrecta";
                    }
                })
                .orElse("Nombre de usuario no encontrado");
    }

    public Usuario createUser(String nombre, String contraseña, boolean esAdmin) {
        Usuario newUser = new Usuario(nombre, contraseña, esAdmin);
        return usuarioRepository.save(newUser);
    }

    public void deleteUser(Integer id) {
        usuarioRepository.deleteById(id);
    }
}