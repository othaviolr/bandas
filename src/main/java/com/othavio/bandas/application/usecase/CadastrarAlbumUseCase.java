package com.othavio.bandas.application.usecase;

import com.othavio.bandas.domain.entity.Album;
import com.othavio.bandas.domain.entity.Banda;
import com.othavio.bandas.domain.repository.AlbumRepository;
import com.othavio.bandas.domain.repository.BandaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class CadastrarAlbumUseCase {

    private final AlbumRepository albumRepository;
    private final BandaRepository bandaRepository;

    public CadastrarAlbumUseCase(AlbumRepository albumRepository, BandaRepository bandaRepository) {
        this.albumRepository = albumRepository;
        this.bandaRepository = bandaRepository;
    }

    @Transactional
    public Album executar(String nome, LocalDate dataLancamento, UUID bandaId) {
        Banda banda = bandaRepository.findById(bandaId)
                .orElseThrow(() -> new IllegalArgumentException("Banda não encontrada"));

        Album album = new Album(nome, dataLancamento, banda);
        return albumRepository.save(album);
    }
}