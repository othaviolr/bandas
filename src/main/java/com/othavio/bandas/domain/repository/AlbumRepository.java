package com.othavio.bandas.domain.repository;

import com.othavio.bandas.domain.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AlbumRepository extends JpaRepository<Album, UUID> {
    List<Album> findByBandaId(UUID bandaId);
}