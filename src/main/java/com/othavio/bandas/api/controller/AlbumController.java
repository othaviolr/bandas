package com.othavio.bandas.api.controller;

import com.othavio.bandas.application.usecase.CadastrarAlbumUseCase;
import com.othavio.bandas.domain.entity.Album;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping("/albuns")
public class AlbumController {

    private final CadastrarAlbumUseCase cadastrarAlbumUseCase;

    public AlbumController(CadastrarAlbumUseCase cadastrarAlbumUseCase) {
        this.cadastrarAlbumUseCase = cadastrarAlbumUseCase;
    }

    @PostMapping
    public ResponseEntity<AlbumResponse> cadastrar(@Valid @RequestBody AlbumRequest request) {
        Album album = cadastrarAlbumUseCase.executar(
                request.nome(),
                request.dataLancamento(),
                request.bandaId()
        );
        URI uri = URI.create("/albuns/" + album.getId());
        return ResponseEntity.created(uri).body(new AlbumResponse(album.getId(), album.getNome(), album.getDataLancamento(), album.getBanda().getId()));
    }

    public record AlbumRequest(
            @NotBlank String nome,
            @NotNull LocalDate dataLancamento,
            @NotNull UUID bandaId
    ) {}

    public record AlbumResponse(UUID id, String nome, LocalDate dataLancamento, UUID bandaId) {}
}