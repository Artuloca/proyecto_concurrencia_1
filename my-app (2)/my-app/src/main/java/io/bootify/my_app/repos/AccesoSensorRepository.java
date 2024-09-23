
package io.bootify.my_app.repos;

import io.bootify.my_app.domain.AccesoSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccesoSensorRepository extends JpaRepository<AccesoSensor, Integer> {
}