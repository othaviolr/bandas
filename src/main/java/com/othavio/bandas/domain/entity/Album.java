package com.othavio.bandas.domain.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "albuns")
public class Album {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(name = "data_lancamento")
    private LocalDate dataLancamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "banda_id", nullable = false)
    private Banda banda;

    protected Album() {}

    public Album(String nome, LocalDate dataLancamento, Banda banda) {
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.banda = banda;
    }

    public UUID getId() { return id; }
    public String getNome() { return nome; }
    public LocalDate getDataLancamento() { return dataLancamento; }
    public Banda getBanda() { return banda; }
}