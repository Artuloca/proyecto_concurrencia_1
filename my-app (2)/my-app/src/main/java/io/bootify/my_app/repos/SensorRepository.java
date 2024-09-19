package io.bootify.my_app.repos;

import io.bootify.my_app.domain.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SensorRepository extends JpaRepository<Sensor, Integer> {
}
