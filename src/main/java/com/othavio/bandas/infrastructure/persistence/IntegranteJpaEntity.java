package com.othavio.bandas.infrastructure.persistence;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "integrantes")
public class IntegranteJpaEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String instrumento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "banda_id", nullable = false)
    private BandaJpaEntity banda;

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

    public String getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }

    public BandaJpaEntity getBanda() {
        return banda;
    }

    public void setBanda(BandaJpaEntity banda) {
        this.banda = banda;
    }
}