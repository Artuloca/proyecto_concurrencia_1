package io.bootify.my_app.repos;

import io.bootify.my_app.domain.TemperaturaSensor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TemperaturaSensorRepository extends JpaRepository<TemperaturaSensor, Integer> {
}
