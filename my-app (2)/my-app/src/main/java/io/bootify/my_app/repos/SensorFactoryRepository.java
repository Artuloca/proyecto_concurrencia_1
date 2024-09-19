package io.bootify.my_app.repos;

import io.bootify.my_app.domain.SensorFactory;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SensorFactoryRepository extends JpaRepository<SensorFactory, Integer> {
}
