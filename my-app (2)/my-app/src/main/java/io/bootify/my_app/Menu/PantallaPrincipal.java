package io.bootify.my_app.Menu;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import java.util.concurrent.CompletableFuture;

@Component
public class PantallaPrincipal {

    @Async("taskExecutor")
    public CompletableFuture<Void> mostrarPantalla(String nombreUsuario, String contraseña, Model model) {
        model.addAttribute("usuario", nombreUsuario);
        model.addAttribute("contraseña", contraseña);

        // Simular un retraso para demostrar la concurrencia
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return CompletableFuture.completedFuture(null);
    }
}