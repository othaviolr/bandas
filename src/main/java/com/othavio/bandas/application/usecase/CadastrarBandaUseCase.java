package com.othavio.bandas.application.usecase;

import com.othavio.bandas.domain.entity.Banda;
import com.othavio.bandas.domain.repository.BandaRepository;
import org.springframework.stereotype.Component;

@Component
public class CadastrarBandaUseCase {

    private final BandaRepository bandaRepository;

    public CadastrarBandaUseCase(BandaRepository bandaRepository) {
        this.bandaRepository = bandaRepository;
    }

    public Banda executar(String nome) {
        Banda banda = new Banda(nome);
        return bandaRepository.save(banda);
    }
}