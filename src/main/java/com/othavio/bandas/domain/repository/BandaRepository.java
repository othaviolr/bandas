package com.othavio.bandas.domain.repository;

import com.othavio.bandas.domain.entity.Banda;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BandaRepository {
    Banda salvar(Banda banda);
    Optional<Banda> buscarPorId(UUID id);
    List<Banda> listar();
}