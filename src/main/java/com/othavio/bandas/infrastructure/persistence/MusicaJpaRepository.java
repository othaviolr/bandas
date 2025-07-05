package com.othavio.bandas.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface MusicaJpaRepository extends JpaRepository<MusicaJpaEntity, UUID> {
}