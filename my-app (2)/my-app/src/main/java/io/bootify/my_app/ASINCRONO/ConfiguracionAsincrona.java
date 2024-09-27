package io.bootify.my_app.ASINCRONO;

import org.springframework.ui.Model;
import io.bootify.my_app.Menu.PantallaPrincipal;
import io.bootify.my_app.SENSORES.SensorAcceso;
import io.bootify.my_app.SENSORES.SensorMovimiento;
import io.bootify.my_app.SENSORES.SensorTemperatura;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@EnableAsync
public class ConfiguracionAsincrona {

    private final SensorAcceso sensorAcceso;
    private final SensorMovimiento sensorMovimiento;
    private final SensorTemperatura sensorTemperatura;
    private final PantallaPrincipal pantallaUsuario;

    public ConfiguracionAsincrona(SensorAcceso sensorAcceso, SensorMovimiento sensorMovimiento, SensorTemperatura sensorTemperatura, PantallaPrincipal pantallaUsuario) {
        this.sensorAcceso = sensorAcceso;
        this.sensorMovimiento = sensorMovimiento;
        this.sensorTemperatura = sensorTemperatura;
        this.pantallaUsuario = pantallaUsuario;
    }

    @Async("taskExecutor")
    public CompletableFuture<String> verificarMovimiento(boolean movimiento) {
        System.out.println("Verificando movimiento " + Thread.currentThread().getName());
        return CompletableFuture.completedFuture(sensorMovimiento.verificarMovimiento(movimiento));
    }

    @Async("taskExecutor")
    public CompletableFuture<String> verificarTemperatura(int temperatura) {
        System.out.println("Verificando temperatura " + Thread.currentThread().getName());
        return CompletableFuture.completedFuture(sensorTemperatura.verificarTemperatura(temperatura));
    }

    @Async("taskExecutor")
    public CompletableFuture<String> verificarAcceso(boolean acceso) {
        System.out.println("Verificando acceso " + Thread.currentThread().getName());
        return CompletableFuture.completedFuture(sensorAcceso.verificarAcceso(acceso));
    }

    @Async("taskExecutor")
    public CompletableFuture<Void> mostrarPantallaUsuario(String nombreUsuario, String contraseña, Model model) {
        return pantallaUsuario.mostrarPantalla(nombreUsuario, contraseña, model);
    }
}