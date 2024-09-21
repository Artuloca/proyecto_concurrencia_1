// File: src/main/java/io/bootify/my_app/service/DatabaseCleanupService.java
package io.bootify.my_app.reset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DatabaseCleanupService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void clearDatabase() {
        jdbcTemplate.execute("TRUNCATE TABLE movimiento");
        jdbcTemplate.execute("TRUNCATE TABLE temperatura");
        jdbcTemplate.execute("TRUNCATE TABLE acceso");

    }
}