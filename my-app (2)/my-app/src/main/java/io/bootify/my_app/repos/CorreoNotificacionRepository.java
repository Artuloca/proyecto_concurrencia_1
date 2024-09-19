package io.bootify.my_app.repos;

import io.bootify.my_app.domain.CorreoNotificacion;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CorreoNotificacionRepository extends JpaRepository<CorreoNotificacion, Integer> {
}
