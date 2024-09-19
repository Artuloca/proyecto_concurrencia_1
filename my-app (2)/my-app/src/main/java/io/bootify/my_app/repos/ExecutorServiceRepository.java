package io.bootify.my_app.repos;

import io.bootify.my_app.domain.ExecutorService;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExecutorServiceRepository extends JpaRepository<ExecutorService, Integer> {
}
