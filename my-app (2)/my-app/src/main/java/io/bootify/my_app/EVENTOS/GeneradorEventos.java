package io.bootify.my_app.EVENTOS;

import io.bootify.my_app.SENSORES.SensorAcceso;
import io.bootify.my_app.SENSORES.SensorMovimiento;
import io.bootify.my_app.SENSORES.SensorTemperatura;
import io.bootify.my_app.SERVICIO.SensorService;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class GeneradorEventos {

    private final Random random = new Random();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final SensorService sensorService;

    public GeneradorEventos(SensorService sensorService) {
        this.sensorService = sensorService;
        scheduler.scheduleAtFixedRate(this::generarEvento, 0, 5, TimeUnit.SECONDS);
    }

    public void generarEvento() {
        boolean movimiento = random.nextDouble() <= 0.2;
        int temperatura = random.nextInt(56) - 5; // Genera un número entre -5 y 50
        boolean acceso = random.nextDouble() <= 0.1;

        sensorService.procesarDatosSensores(movimiento, temperatura, acceso);
    }
}