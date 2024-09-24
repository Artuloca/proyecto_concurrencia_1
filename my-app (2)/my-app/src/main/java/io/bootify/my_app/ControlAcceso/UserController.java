package io.bootify.my_app.ControlAcceso;

import io.bootify.my_app.domain.Usuario;
import io.bootify.my_app.repos.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/create")
    public Usuario createUser(@RequestBody Usuario newUser) {
        return usuarioRepository.save(newUser);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Integer id) {
        usuarioRepository.deleteById(id);
    }
}
