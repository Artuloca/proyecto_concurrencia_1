package io.bootify.my_app.ASINCRONO;

import io.bootify.my_app.SENSORES.SensorAcceso;
import io.bootify.my_app.SENSORES.SensorMovimiento;
import io.bootify.my_app.SENSORES.SensorTemperatura;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Component
@EnableAsync
public class ConfiguracionAsincrona {

    private final Random random = new Random();
    private final SensorAcceso sensorAcceso;
    private final SensorMovimiento sensorMovimiento;
    private final SensorTemperatura sensorTemperatura;

    public ConfiguracionAsincrona(SensorAcceso sensorAcceso, SensorMovimiento sensorMovimiento, SensorTemperatura sensorTemperatura) {
        this.sensorAcceso = sensorAcceso;
        this.sensorMovimiento = sensorMovimiento;
        this.sensorTemperatura = sensorTemperatura;
    }

    @Async("taskExecutor")
    public CompletableFuture<String> verificarMovimiento(boolean movimiento) {
        return CompletableFuture.completedFuture(sensorMovimiento.verificarMovimiento(movimiento));
    }

    @Async("taskExecutor")
    public CompletableFuture<String> verificarTemperatura(int temperatura) {
        return CompletableFuture.completedFuture(sensorTemperatura.verificarTemperatura(temperatura));
    }

    @Async("taskExecutor")
    public CompletableFuture<String> verificarAcceso(boolean acceso) {
        return CompletableFuture.completedFuture(sensorAcceso.verificarAcceso(acceso));
    }
}