package io.bootify.my_app.domain;

import io.bootify.my_app.repos.UsuarioRepository;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

@Entity
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false)
    private String contraseña;

    @Column(nullable = false)
    private boolean esAdmin;

    // Constructor vacío (opcional)
    public Usuario() {
    }

    // Constructor con parámetros (opcional)
    public Usuario(String nombre, String contraseña, boolean esAdmin) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.esAdmin = esAdmin;
    }

    @Component
    public static class UsuarioInitializer {

        @Autowired
        private UsuarioRepository usuarioRepository;

        @PostConstruct
        public void init() {
            if (usuarioRepository.findByNombre("admin").isEmpty()) {
                Usuario admin = new Usuario("admin", "admin", true);
                usuarioRepository.save(admin);
            }
            if (usuarioRepository.findByNombre("default").isEmpty()) {
                Usuario defaultUser = new Usuario("default", "default", false);
                usuarioRepository.save(defaultUser);
            }
        }
    }
}