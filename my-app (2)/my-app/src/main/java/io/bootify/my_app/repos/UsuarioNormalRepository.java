package io.bootify.my_app.repos;

import io.bootify.my_app.domain.UsuarioNormal;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioNormalRepository extends JpaRepository<UsuarioNormal, Integer> {
}
