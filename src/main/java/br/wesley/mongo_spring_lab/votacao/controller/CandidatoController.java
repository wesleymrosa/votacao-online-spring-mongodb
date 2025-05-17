package br.wesley.mongo_spring_lab.votacao.controller;

import br.wesley.mongo_spring_lab.votacao.dto.CandidatoDTO;
import br.wesley.mongo_spring_lab.votacao.service.CandidatoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Candidatos", description = "Operações relacionadas a candidatos")
@RestController
@RequestMapping("/api/candidatos")
public class CandidatoController {

    @Autowired
    private CandidatoService service;

    @Operation(summary = "Listar todos os candidatos")
    @GetMapping
    public ResponseEntity<List<CandidatoDTO>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @Operation(summary = "Cadastrar novo candidato")
    @PostMapping
    public ResponseEntity<CandidatoDTO> criar(@Valid @RequestBody CandidatoDTO dto) {
        return ResponseEntity.ok(service.salvar(dto));
    }
}
