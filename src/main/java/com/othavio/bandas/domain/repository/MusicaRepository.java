package com.othavio.bandas.domain.repository;

import com.othavio.bandas.domain.entity.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MusicaRepository extends JpaRepository<Musica, UUID> {
    List<Musica> findByAlbumId(UUID albumId);
}