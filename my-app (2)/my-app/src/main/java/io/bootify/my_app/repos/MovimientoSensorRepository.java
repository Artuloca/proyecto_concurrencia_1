package io.bootify.my_app.repos;

import io.bootify.my_app.domain.MovimientoSensor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MovimientoSensorRepository extends JpaRepository<MovimientoSensor, Integer> {
}
