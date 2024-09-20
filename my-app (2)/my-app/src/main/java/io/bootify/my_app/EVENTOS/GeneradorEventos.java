package io.bootify.my_app.EVENTOS;

import io.bootify.my_app.SENSORES.SensorAcceso;
import io.bootify.my_app.SENSORES.SensorMovimiento;
import io.bootify.my_app.SENSORES.SensorTemperatura;
import io.bootify.my_app.SERVICIO.SensorService;
import io.bootify.my_app.domain.Acceso;
import io.bootify.my_app.domain.Movimiento;
import io.bootify.my_app.domain.Temperatura;
import io.bootify.my_app.repos.AccesoRepository;
import io.bootify.my_app.repos.MovimientoRepository;
import io.bootify.my_app.repos.TemperaturaRepository;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class GeneradorEventos {
    private final MovimientoRepository movimientoRepository;
    private final TemperaturaRepository temperaturaRepository;
    private final AccesoRepository accesoRepository;

    private final Random random = new Random();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final SensorService sensorService;

    public GeneradorEventos(SensorService sensorService, MovimientoRepository movimientoRepository, TemperaturaRepository temperaturaRepository, AccesoRepository accesoRepository) {
        this.sensorService = sensorService;
        this.movimientoRepository = movimientoRepository;
        this.temperaturaRepository = temperaturaRepository;
        this.accesoRepository = accesoRepository;
        scheduler.scheduleAtFixedRate(this::generarEvento, 0, 5, TimeUnit.SECONDS);
    }


    public void generarEvento() {
        boolean movimientoBool = random.nextDouble() <= 0.2;
        int temperaturaInt = random.nextInt(56) - 5; // Genera un número entre -5 y 50
        boolean accesoBool = random.nextDouble() <= 0.1;

        sensorService.procesarDatosSensores(movimientoBool, temperaturaInt, accesoBool);

        // Save events to the database
        Movimiento movimiento = new Movimiento();
        movimiento.setMovimiento(movimientoBool);
        movimientoRepository.save(movimiento);

        Temperatura temperatura = new Temperatura();
        temperatura.setTemperatura(temperaturaInt);
        temperaturaRepository.save(temperatura);

        Acceso acceso = new Acceso();
        acceso.setAcceso(accesoBool);
        accesoRepository.save(acceso);
    }
}