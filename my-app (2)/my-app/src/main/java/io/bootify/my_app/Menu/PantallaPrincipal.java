// File: src/main/java/io/bootify/my_app/Menu/PantallaPrincipal.java
package io.bootify.my_app.Menu;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

@Component
public class PantallaPrincipal {

    @Async("taskExecutor")
    public CompletableFuture<Void> mostrarPantalla() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();

        System.out.print("Ingrese la contraseña: ");
        String contraseña = scanner.nextLine();

        // Aquí puedes agregar la lógica para manejar el nombre de usuario y la contraseña
        System.out.println("Usuario: " + nombreUsuario);
        System.out.println("Contraseña: " + contraseña);

        return CompletableFuture.completedFuture(null);
    }
}