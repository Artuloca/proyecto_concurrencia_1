package io.bootify.my_app.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false)
    private String contraseña;

    @Column(nullable = false)
    private boolean esAdmin;

    // Constructor vacío (opcional)
    public Usuario() {
    }

    // Constructor con parámetros (opcional)
    public Usuario(String nombre, String contraseña, boolean esAdmin) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.esAdmin = esAdmin;
    }
}