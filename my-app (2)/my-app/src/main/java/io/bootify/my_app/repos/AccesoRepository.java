package io.bootify.my_app.repos;

import io.bootify.my_app.domain.Acceso;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccesoRepository extends JpaRepository<Acceso, Integer> {
}
