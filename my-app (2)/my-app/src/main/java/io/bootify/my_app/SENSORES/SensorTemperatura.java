package io.bootify.my_app.SENSORES;

import org.springframework.stereotype.Component;

@Component
public class SensorTemperatura {

    public String verificarTemperatura(int temperatura) {
        if (temperatura <=10||temperatura>=40) {
            return "SE HA DETECTADO UNA TEMPERATURA PELIGROSA, MANDANDO NOTIFICACION DE TEMPERATURA PELIGROSA";
        }
        return "";

    }
}