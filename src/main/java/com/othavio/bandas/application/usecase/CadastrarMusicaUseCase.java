package com.othavio.bandas.application.usecase;

import com.othavio.bandas.domain.entity.Album;
import com.othavio.bandas.domain.entity.Musica;
import com.othavio.bandas.domain.repository.AlbumRepository;
import com.othavio.bandas.domain.repository.MusicaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CadastrarMusicaUseCase {

    private final MusicaRepository musicaRepository;
    private final AlbumRepository albumRepository;

    public CadastrarMusicaUseCase(MusicaRepository musicaRepository, AlbumRepository albumRepository) {
        this.musicaRepository = musicaRepository;
        this.albumRepository = albumRepository;
    }

    @Transactional
    public Musica executar(String nome, int duracaoSegundos, UUID albumId) {
        Album album = albumRepository.findById(albumId)
                .orElseThrow(() -> new IllegalArgumentException("Album não encontrado"));

        Musica musica = new Musica(nome, duracaoSegundos, album);
        return musicaRepository.save(musica);
    }
}