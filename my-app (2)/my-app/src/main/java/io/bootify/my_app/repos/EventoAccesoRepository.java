package io.bootify.my_app.repos;

import io.bootify.my_app.domain.EventoAcceso;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventoAccesoRepository extends JpaRepository<EventoAcceso, Integer> {
}
