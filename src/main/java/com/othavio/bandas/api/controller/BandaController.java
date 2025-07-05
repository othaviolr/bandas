package com.othavio.bandas.api.controller;

import com.othavio.bandas.application.usecase.CadastrarBandaUseCase;
import com.othavio.bandas.domain.entity.Banda;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/bandas")
public class BandaController {

    private final CadastrarBandaUseCase cadastrarBandaUseCase;

    public BandaController(CadastrarBandaUseCase cadastrarBandaUseCase) {
        this.cadastrarBandaUseCase = cadastrarBandaUseCase;
    }

    @PostMapping
    public ResponseEntity<BandaResponse> cadastrar(@Valid @RequestBody BandaRequest request) {
        Banda banda = cadastrarBandaUseCase.executar(request.nome());
        URI uri = URI.create("/bandas/" + banda.getId());
        return ResponseEntity.created(uri).body(new BandaResponse(banda.getId(), banda.getNome()));
    }

    public record BandaRequest(@NotBlank String nome) {}

    public record BandaResponse(java.util.UUID id, String nome) {}
}