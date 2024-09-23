package io.bootify.my_app.SERVICIO;

import io.bootify.my_app.ASINCRONO.ConfiguracionAsincrona;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
public class SensorService {

    private final ConfiguracionAsincrona configuracionAsincrona;

    public SensorService(ConfiguracionAsincrona configuracionAsincrona) {
        this.configuracionAsincrona = configuracionAsincrona;
    }

    public void procesarDatosSensores(boolean movimiento, int temperatura, boolean acceso) {
        try {
            String resultadoMovimiento = configuracionAsincrona.verificarMovimiento(movimiento).get();
            String resultadoTemperatura = configuracionAsincrona.verificarTemperatura(temperatura).get();
            String resultadoAcceso = configuracionAsincrona.verificarAcceso(acceso).get();

            System.out.println("Evento: Movimiento - " + movimiento + ", Temperatura - " + temperatura + ", Acceso - " + acceso);

            if (!resultadoMovimiento.isEmpty()) {
                System.out.println(resultadoMovimiento);
            }

            if (!resultadoTemperatura.isEmpty()) {
                System.out.println(resultadoTemperatura);
            }

            if (!resultadoAcceso.isEmpty()) {
                System.out.println(resultadoAcceso);
            }

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}