package io.bootify.my_app.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Evento {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String tipo;

    @OneToMany(mappedBy = "evento")
    private Set<Sensor> eventoSensors;

    @OneToMany(mappedBy = "evento")
    private Set<Movimiento> eventoMovimientoes;

    @OneToMany(mappedBy = "evento")
    private Set<Temperatura> eventoTemperaturas;

    @OneToMany(mappedBy = "evento")
    private Set<Acceso> eventoAccesoes;

}
