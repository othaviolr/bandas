package com.othavio.bandas.api.controller;

import com.othavio.bandas.application.usecase.CadastrarMusicaUseCase;
import com.othavio.bandas.domain.entity.Musica;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

    private final CadastrarMusicaUseCase cadastrarMusicaUseCase;

    public MusicaController(CadastrarMusicaUseCase cadastrarMusicaUseCase) {
        this.cadastrarMusicaUseCase = cadastrarMusicaUseCase;
    }

    @PostMapping
    public ResponseEntity<MusicaResponse> cadastrar(@Valid @RequestBody MusicaRequest request) {
        Musica musica = cadastrarMusicaUseCase.executar(
                request.nome(),
                request.duracaoSegundos(),
                request.albumId()
        );
        URI uri = URI.create("/musicas/" + musica.getId());
        return ResponseEntity.created(uri).body(new MusicaResponse(musica.getId(), musica.getNome(), musica.getDuracaoSegundos(), musica.getAlbum().getId()));
    }

    public record MusicaRequest(
            @NotBlank String nome,
            @Positive int duracaoSegundos,
            @NotNull UUID albumId
    ) {}

    public record MusicaResponse(UUID id, String nome, int duracaoSegundos, UUID albumId) {}
}