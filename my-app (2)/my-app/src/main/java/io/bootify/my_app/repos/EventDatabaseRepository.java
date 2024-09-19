package io.bootify.my_app.repos;

import io.bootify.my_app.domain.EventDatabase;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventDatabaseRepository extends JpaRepository<EventDatabase, Integer> {
}
