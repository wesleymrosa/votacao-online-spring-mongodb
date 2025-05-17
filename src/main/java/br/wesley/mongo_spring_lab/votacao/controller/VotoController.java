package br.wesley.mongo_spring_lab.votacao.controller;

import br.wesley.mongo_spring_lab.votacao.dto.ResultadoVotacaoDTO;
import br.wesley.mongo_spring_lab.votacao.dto.VotoDTO;
import br.wesley.mongo_spring_lab.votacao.model.Voto;
import br.wesley.mongo_spring_lab.votacao.service.VotoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/votos")
public class VotoController {

    @Autowired
    private VotoService votoService;

    @PostMapping
    public ResponseEntity<Voto> votar(@RequestBody @Valid VotoDTO dto) {
        Voto voto = votoService.votar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(voto);
    }

    @GetMapping
    public ResponseEntity<List<Voto>> listarTodos() {
        List<Voto> votos = votoService.listarTodos();
        return ResponseEntity.ok(votos);
    }

    @GetMapping("/resultado")
    public ResponseEntity<List<ResultadoVotacaoDTO>> resultado() {
        List<ResultadoVotacaoDTO> resultado = votoService.apurarResultado();
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/resultado-extenso")
    public ResponseEntity<String> resultadoPorExtenso() {
        return ResponseEntity.ok(votoService.gerarResultadoPorExtenso());
    }
}
