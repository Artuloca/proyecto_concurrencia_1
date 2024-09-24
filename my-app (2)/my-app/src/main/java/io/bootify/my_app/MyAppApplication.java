package io.bootify.my_app;

import io.bootify.my_app.reset.DatabaseCleanupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import jakarta.annotation.PreDestroy;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.Executor;

@SpringBootApplication
public class MyAppApplication {

    @Autowired
    private DatabaseCleanupService databaseCleanupService;

    public static void main(final String[] args) {
        SpringApplication.run(MyAppApplication.class, args);
        openHomePage();
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

    @Configuration
    @EnableAsync
    public class AsyncConfig {
        @Bean(name = "taskExecutor")
        public Executor taskExecutor() {
            ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
            executor.setCorePoolSize(2);
            executor.setMaxPoolSize(2);
            executor.setQueueCapacity(500);
            executor.setThreadNamePrefix("AsynchThread-");
            executor.initialize();
            return executor;
        }
    }

private static void openHomePage() {
    try {
        URI uri = new URI("http://localhost:8080/");
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().browse(uri);
        } else {
            // Intentar abrir el navegador utilizando la línea de comandos
            String os = System.getProperty("os.name").toLowerCase();
            Runtime rt = Runtime.getRuntime();
            if (os.contains("win")) {
                rt.exec("rundll32 url.dll,FileProtocolHandler " + uri);
            } else if (os.contains("mac")) {
                rt.exec("open " + uri);
            } else if (os.contains("nix") || os.contains("nux")) {
                String[] browsers = {"xdg-open", "google-chrome", "firefox"};
                boolean success = false;
                for (String browser : browsers) {
                    if (!success) {
                        try {
                            rt.exec(new String[]{browser, uri.toString()});
                            success = true;
                        } catch (Exception e) {
                            // Intentar con el siguiente navegador
                        }
                    }
                }
                if (!success) {
                    System.out.println("No se pudo abrir el navegador. Por favor, ábrelo manualmente.");
                }
            }
        }
    } catch (IOException | URISyntaxException e) {
        e.printStackTrace();
    }
}
}