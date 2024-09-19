package io.bootify.my_app.repos;

import io.bootify.my_app.domain.AlertaNotificacion;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AlertaNotificacionRepository extends JpaRepository<AlertaNotificacion, Integer> {
}
