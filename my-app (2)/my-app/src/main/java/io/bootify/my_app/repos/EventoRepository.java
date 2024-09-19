package io.bootify.my_app.repos;

import io.bootify.my_app.domain.Evento;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventoRepository extends JpaRepository<Evento, Integer> {
}
