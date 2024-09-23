package io.bootify.my_app.repos;

import io.bootify.my_app.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByNombre(String nombre);
}