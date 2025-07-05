package com.othavio.bandas.domain.repository;

import com.othavio.bandas.domain.entity.Integrante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface IntegranteRepository extends JpaRepository<Integrante, UUID> {
    List<Integrante> findByBandaId(UUID bandaId);
}