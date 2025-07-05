package com.othavio.bandas.api.controller;

import com.othavio.bandas.application.usecase.CadastrarIntegranteUseCase;
import com.othavio.bandas.domain.entity.Integrante;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/integrantes")
public class IntegranteController {

    private final CadastrarIntegranteUseCase cadastrarIntegranteUseCase;

    public IntegranteController(CadastrarIntegranteUseCase cadastrarIntegranteUseCase) {
        this.cadastrarIntegranteUseCase = cadastrarIntegranteUseCase;
    }

    @PostMapping
    public ResponseEntity<IntegranteResponse> cadastrar(@Valid @RequestBody IntegranteRequest request) {
        Integrante integrante = cadastrarIntegranteUseCase.executar(
                request.nome(),
                request.instrumento(),
                request.bandaId()
        );
        URI uri = URI.create("/integrantes/" + integrante.getId());
        return ResponseEntity.created(uri).body(new IntegranteResponse(integrante.getId(), integrante.getNome(), integrante.getInstrumento(), integrante.getBanda().getId()));
    }

    public record IntegranteRequest(
            @NotBlank String nome,
            @NotBlank String instrumento,
            @NotNull UUID bandaId
    ) {}

    public record IntegranteResponse(UUID id, String nome, String instrumento, UUID bandaId) {}
}