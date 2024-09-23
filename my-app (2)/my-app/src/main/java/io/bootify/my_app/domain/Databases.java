package io.bootify.my_app.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "\"Databases\"")
@Getter
@Setter
public class Databases {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "database")
    private Set<MovimientoSensor> movimientoSensores;

    @OneToMany(mappedBy = "database")
    private Set<TemperaturaSensor> databaseTemperaturaSensors;

    @OneToMany(mappedBy = "database")
    private Set<AccesoSensor> databaseAccesoSensores;

}
