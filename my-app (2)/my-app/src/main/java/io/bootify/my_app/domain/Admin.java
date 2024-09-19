package io.bootify.my_app.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "\"Admin\"")
@Getter
@Setter
public class Admin {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(mappedBy = "admin", fetch = FetchType.LAZY)
    private WebSocket webSocket;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "monitorizador_id")
    private Monitorizador monitorizador;

    @OneToMany(mappedBy = "admin")
    private Set<User> user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "database_id", unique = true)
    private Databases database;

}
