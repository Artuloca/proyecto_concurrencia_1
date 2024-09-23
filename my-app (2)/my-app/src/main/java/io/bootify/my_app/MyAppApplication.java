// File: src/main/java/io/bootify/my_app/MyAppApplication.java
package io.bootify.my_app;

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
        };
    }
}