package com.othavio.bandas.domain.repository;

import com.othavio.bandas.domain.entity.Banda;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface BandaRepository extends JpaRepository<Banda, UUID> {
}