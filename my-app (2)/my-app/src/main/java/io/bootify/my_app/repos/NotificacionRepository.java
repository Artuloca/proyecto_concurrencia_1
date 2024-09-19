package io.bootify.my_app.repos;

import io.bootify.my_app.domain.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NotificacionRepository extends JpaRepository<Notificacion, Integer> {
}
