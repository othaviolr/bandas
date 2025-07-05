package com.othavio.bandas.domain.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "musicas")
public class Musica {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(name = "duracao_segundos", nullable = false)
    private int duracaoSegundos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id", nullable = false)
    private Album album;

    protected Musica() {}

    public Musica(String nome, int duracaoSegundos, Album album) {
        this.nome = nome;
        this.duracaoSegundos = duracaoSegundos;
        this.album = album;
    }

    public UUID getId() { return id; }
    public String getNome() { return nome; }
    public int getDuracaoSegundos() { return duracaoSegundos; }
    public Album getAlbum() { return album; }
}