// File: src/main/java/io/bootify/my_app/REST/EventController.java
package io.bootify.my_app.REST;

import io.bootify.my_app.domain.Movimiento;
import io.bootify.my_app.domain.Temperatura;
import io.bootify.my_app.domain.Acceso;
import io.bootify.my_app.repos.MovimientoRepository;
import io.bootify.my_app.repos.TemperaturaRepository;
import io.bootify.my_app.repos.AccesoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {

    private final MovimientoRepository movimientoRepository;
    private final TemperaturaRepository temperaturaRepository;
    private final AccesoRepository accesoRepository;

    public EventController(MovimientoRepository movimientoRepository, TemperaturaRepository temperaturaRepository, AccesoRepository accesoRepository) {
        this.movimientoRepository = movimientoRepository;
        this.temperaturaRepository = temperaturaRepository;
        this.accesoRepository = accesoRepository;
    }

    @GetMapping("/api/events/movimientos")
    public List<Movimiento> getMovimientos() {
        return movimientoRepository.findAll();
    }

    @GetMapping("/api/events/temperaturas")
    public List<Temperatura> getTemperaturas() {
        return temperaturaRepository.findAll();
    }

    @GetMapping("/api/events/accesos")
    public List<Acceso> getAccesos() {
        return accesoRepository.findAll();
    }
}