package io.bootify.my_app.repos;

import io.bootify.my_app.domain.Monitorizador;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MonitorizadorRepository extends JpaRepository<Monitorizador, Integer> {
}
