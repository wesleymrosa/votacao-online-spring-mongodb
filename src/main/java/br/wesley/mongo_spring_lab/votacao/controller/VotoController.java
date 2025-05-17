package br.wesley.mongo_spring_lab.votacao.controller;

import br.wesley.mongo_spring_lab.votacao.dto.ResultadoVotacaoDTO;
import br.wesley.mongo_spring_lab.votacao.dto.VotoDTO;
import br.wesley.mongo_spring_lab.votacao.model.Voto;
import br.wesley.mongo_spring_lab.votacao.service.VotoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Votos", description = "Operações de votação e apuração")
@RestController
@RequestMapping("/api/votos")
public class VotoController {

    @Autowired
    private VotoService votoService;

    @Operation(summary = "Registrar voto")
    @PostMapping
    public ResponseEntity<Voto> votar(@RequestBody @Valid VotoDTO dto) {
        Voto voto = votoService.votar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(voto);
    }

    @Operation(summary = "Listar todos os votos")
    @GetMapping
    public ResponseEntity<List<Voto>> listarTodos() {
        List<Voto> votos = votoService.listarTodos();
        return ResponseEntity.ok(votos);
    }

    @Operation(summary = "Resultado da apuração em formato de lista")
    @GetMapping("/resultado")
    public ResponseEntity<List<ResultadoVotacaoDTO>> resultado() {
        List<ResultadoVotacaoDTO> resultado = votoService.apurarResultado();
        return ResponseEntity.ok(resultado);
    }

    @Operation(summary = "Resultado da apuração por extenso (ordenado)")
    @GetMapping("/resultado-extenso")
    public ResponseEntity<String> resultadoPorExtenso() {
        return ResponseEntity.ok(votoService.gerarResultadoPorExtenso());
    }
}
