package io.bootify.my_app.SENSORES;

import org.springframework.stereotype.Component;

@Component
public class SensorAcceso {

    public String verificarAcceso(boolean acceso) {
        if (acceso) {
            return "SENSOR ACCESO ACTIVADO, MANDANDO NOTIFICACION DE INTRUSION";
        }
        return "";
    }
}