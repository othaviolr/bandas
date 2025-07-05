package com.othavio.bandas.domain.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "integrantes")
public class Integrante {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String instrumento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "banda_id", nullable = false)
    private Banda banda;

    protected Integrante() {}

    public Integrante(String nome, String instrumento, Banda banda) {
        this.nome = nome;
        this.instrumento = instrumento;
        this.banda = banda;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public Banda getBanda() {
        return banda;
    }
}