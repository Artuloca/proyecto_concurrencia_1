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
}