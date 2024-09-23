// File: src/main/java/io/bootify/my_app/MyAppApplication.java
package io.bootify.my_app;

import io.bootify.my_app.domain.Usuario;
import io.bootify.my_app.repos.UsuarioRepository;
import io.bootify.my_app.reset.DatabaseCleanupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import jakarta.annotation.PreDestroy;

@SpringBootApplication
public class MyAppApplication {

    @Autowired
    private DatabaseCleanupService databaseCleanupService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public static void main(final String[] args) {
        SpringApplication.run(MyAppApplication.class, args);
    }

    @PreDestroy
    public void onExit() {
        databaseCleanupService.clearDatabase();
        System.out.println("Base de datos vaciada correctamente.");
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("Aplicación iniciada correctamente Fernando!");

            // Crear usuarios de prueba
            Usuario usuario1 = new Usuario("usuario1", "password1", true);
            Usuario usuario2 = new Usuario("usuario2", "password2", false);
            Usuario usuario3 = new Usuario("usuario3", "password3", false);

            // Guardar usuarios en la base de datos
            usuarioRepository.save(usuario1);
            usuarioRepository.save(usuario2);
            usuarioRepository.save(usuario3);

            System.out.println("Usuarios de prueba creados correctamente.");
        };
    }
}

