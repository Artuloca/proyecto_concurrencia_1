package io.bootify.my_app.repos;

import io.bootify.my_app.domain.EventoTemperatura;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventoTemperaturaRepository extends JpaRepository<EventoTemperatura, Integer> {
}
