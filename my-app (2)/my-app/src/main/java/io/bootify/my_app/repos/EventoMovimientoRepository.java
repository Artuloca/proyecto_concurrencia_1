package io.bootify.my_app.repos;

import io.bootify.my_app.domain.EventoMovimiento;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventoMovimientoRepository extends JpaRepository<EventoMovimiento, Integer> {
}
