package io.bootify.my_app.repos;

import io.bootify.my_app.domain.Databases;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DatabasesRepository extends JpaRepository<Databases, Integer> {
}
