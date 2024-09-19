package io.bootify.my_app.repos;

import io.bootify.my_app.domain.WebSocket;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WebSocketRepository extends JpaRepository<WebSocket, Integer> {
}
