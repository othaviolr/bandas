package com.othavio.bandas.api.controller;

import com.othavio.bandas.application.usecase.CadastrarBandaUseCase;
import com.othavio.bandas.domain.entity.Banda;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bandas")
public class BandaController {

    private final CadastrarBandaUseCase cadastrarBandaUseCase;

    public BandaController(CadastrarBandaUseCase cadastrarBandaUseCase) {
        this.cadastrarBandaUseCase = cadastrarBandaUseCase;
    }

    @PostMapping
    public ResponseEntity<BandaResponse> cadastrar(@RequestBody BandaRequest request) {
        Banda banda = cadastrarBandaUseCase.executar(request.nome());
        return ResponseEntity.ok(new BandaResponse(banda.getId().toString(), banda.getNome()));
    }

    public record BandaRequest(String nome) {}

    public record BandaResponse(String id, String nome) {}
}