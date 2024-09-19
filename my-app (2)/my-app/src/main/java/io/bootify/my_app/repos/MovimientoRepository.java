package io.bootify.my_app.repos;

import io.bootify.my_app.domain.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {
}
