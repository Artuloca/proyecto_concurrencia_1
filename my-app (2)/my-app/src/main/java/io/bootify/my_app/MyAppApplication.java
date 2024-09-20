package io.bootify.my_app;

import io.bootify.my_app.EVENTOS.GeneradorEventos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyAppApplication {

    public static void main(final String[] args) {
        ApplicationContext context = SpringApplication.run(MyAppApplication.class, args);

        GeneradorEventos eventito = context.getBean(GeneradorEventos.class);
        System.out.println(eventito);
    }


    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("Aplicación iniciada correctamente Fernando!");
        };
    }
}