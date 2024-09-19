package io.bootify.my_app.repos;

import io.bootify.my_app.domain.Temperatura;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TemperaturaRepository extends JpaRepository<Temperatura, Integer> {
}
