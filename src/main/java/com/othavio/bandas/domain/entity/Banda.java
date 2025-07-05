package com.othavio.bandas.domain.entity;

import java.util.UUID;

public class Banda {
    private final UUID id;
    private final String nome;

    public Banda(String nome) {
        this.id = UUID.randomUUID();
        this.nome = nome;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}