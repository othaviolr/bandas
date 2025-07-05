package com.othavio.bandas.application.usecase;

import com.othavio.bandas.domain.entity.Banda;
import com.othavio.bandas.domain.entity.Integrante;
import com.othavio.bandas.domain.repository.BandaRepository;
import com.othavio.bandas.domain.repository.IntegranteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CadastrarIntegranteUseCase {

    private final IntegranteRepository integranteRepository;
    private final BandaRepository bandaRepository;

    public CadastrarIntegranteUseCase(IntegranteRepository integranteRepository, BandaRepository bandaRepository) {
        this.integranteRepository = integranteRepository;
        this.bandaRepository = bandaRepository;
    }

    @Transactional
    public Integrante executar(String nome, String instrumento, UUID bandaId) {
        Banda banda = bandaRepository.findById(bandaId)
                .orElseThrow(() -> new IllegalArgumentException("Banda não encontrada"));

        Integrante integrante = new Integrante(nome, instrumento, banda);
        return integranteRepository.save(integrante);
    }
}