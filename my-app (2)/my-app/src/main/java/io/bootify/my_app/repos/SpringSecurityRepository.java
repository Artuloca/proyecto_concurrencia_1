package io.bootify.my_app.repos;

import io.bootify.my_app.domain.SpringSecurity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SpringSecurityRepository extends JpaRepository<SpringSecurity, Integer> {
}
