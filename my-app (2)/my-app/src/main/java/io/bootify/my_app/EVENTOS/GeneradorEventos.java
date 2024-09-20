package io.bootify.my_app.EVENTOS;

import io.bootify.my_app.SENSORES.SensorAcceso;
import io.bootify.my_app.SENSORES.SensorMovimiento;
import io.bootify.my_app.SENSORES.SensorTemperatura;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class GeneradorEventos {

    private final Random random = new Random();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final SensorAcceso sensorAcceso;
    private final SensorMovimiento sensorMovimiento;
    private final SensorTemperatura sensorTemperatura;

    public GeneradorEventos(SensorAcceso sensorAcceso, SensorMovimiento sensorMovimiento, SensorTemperatura sensorTemperatura) {
        this.sensorAcceso = sensorAcceso;
        this.sensorMovimiento = sensorMovimiento;
        this.sensorTemperatura = sensorTemperatura;
        scheduler.scheduleAtFixedRate(this::generarEvento, 0, 5, TimeUnit.SECONDS);
    }

    public void generarEvento() {
        boolean movimiento = random.nextDouble() <= 0.2;
        int temperatura = random.nextInt(56) - 5; // Genera un número entre -5 y 50
        boolean acceso = random.nextDouble() <= 0.1;

        String mensajeMovimiento = sensorMovimiento.verificarMovimiento(movimiento);
        String mensajeTemperatura = sensorTemperatura.verificarTemperatura(temperatura);
        String mensajeAcceso = sensorAcceso.verificarAcceso(acceso);

        System.out.println("Se ha realizado un barrido en el edificio, resultados:\n"+
                "Movimiento: " + (movimiento ? "detectado" : "no detectado") +
                (mensajeMovimiento.isEmpty() ? "" : ", " + mensajeMovimiento) + "\n" +
                "Temperatura: " + temperatura +
                (mensajeTemperatura.isEmpty() ? "" : ", " + mensajeTemperatura) + "\n" +
                "Acceso: " + (acceso ? "detectado" : "no detectado") +
                (mensajeAcceso.isEmpty() ? "" : ", " + mensajeAcceso) + "\n");
    }
}