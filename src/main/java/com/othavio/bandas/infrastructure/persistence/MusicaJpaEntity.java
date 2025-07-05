package com.othavio.bandas.infrastructure.persistence;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "musicas")
@Access(AccessType.FIELD) // <-- força Hibernate a mapear só pelos campos
public class MusicaJpaEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(name = "duracao_segundos", nullable = false)
    private int duracaoSegundos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id", nullable = false)
    private AlbumJpaEntity album;

    // getters e setters
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
    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }
    public void setDuracaoSegundos(int duracaoSegundos) {
        this.duracaoSegundos = duracaoSegundos;
    }
    public AlbumJpaEntity getAlbum() {
        return album;
    }
    public void setAlbum(AlbumJpaEntity album) {
        this.album = album;
    }
}