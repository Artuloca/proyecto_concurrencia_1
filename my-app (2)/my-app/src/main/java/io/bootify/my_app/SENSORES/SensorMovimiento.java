package io.bootify.my_app.SENSORES;

import org.springframework.stereotype.Component;

@Component
public class SensorMovimiento {

    public String verificarMovimiento(boolean movimiento) {
        if (movimiento) {
            return "SENSOR MOVIMIENTO ACTIVADO, MANDANDO NOTIFICACION DE MOVIMIENTO";
        }
        return "";
    }
}