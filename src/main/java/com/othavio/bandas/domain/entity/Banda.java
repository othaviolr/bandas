package com.othavio.bandas.domain.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "bandas")
public class Banda {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Geração automática de UUID no Hibernate 6+
    private UUID id;

    @Column(nullable = false)
    private String nome;

    protected Banda() {
    }

    public Banda(String nome) {
        this.nome = nome;
    }

    public Banda(UUID id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}