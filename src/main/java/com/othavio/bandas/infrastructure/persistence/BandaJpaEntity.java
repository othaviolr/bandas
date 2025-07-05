package com.othavio.bandas.infrastructure.persistence;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "bandas")
public class BandaJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Geração automática de UUID no Hibernate 6+
    private UUID id;

    @Column(nullable = false)
    private String nome;

    public BandaJpaEntity() {
    }

    public BandaJpaEntity(String nome) {
        this.nome = nome;
    }

    public BandaJpaEntity(UUID id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}