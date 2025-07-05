package com.othavio.bandas.infrastructure.persistence;

import com.othavio.bandas.domain.entity.Banda;
import com.othavio.bandas.domain.repository.BandaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class BandaRepositoryImpl implements BandaRepository {

    private final BandaJpaRepository jpaRepository;

    public BandaRepositoryImpl(BandaJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Banda salvar(Banda banda) {
        BandaJpaEntity entity = new BandaJpaEntity();
        entity.setNome(banda.getNome());
        BandaJpaEntity salvo = jpaRepository.save(entity);
        return new Banda(salvo.getNome());
    }

    @Override
    public Optional<Banda> buscarPorId(UUID id) {
        return jpaRepository.findById(id)
                .map(entity -> new Banda(entity.getNome()));
    }

    @Override
    public List<Banda> listar() {
        return jpaRepository.findAll()
                .stream()
                .map(entity -> new Banda(entity.getNome()))
                .toList();
    }
}