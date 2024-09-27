// File: src/main/java/io/bootify/my_app/REST/UserController.java
package io.bootify.my_app.REST;

import io.bootify.my_app.domain.Usuario;
import io.bootify.my_app.repos.UsuarioRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UsuarioRepository usuarioRepository;

    public UserController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/api/users")
    public List<Usuario> getUsers() {
        return usuarioRepository.findAll();
    }
}