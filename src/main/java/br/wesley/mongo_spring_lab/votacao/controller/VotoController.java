package br.wesley.mongo_spring_lab.votacao.controller;

import br.wesley.mongo_spring_lab.votacao.dto.VotoDTO;
import br.wesley.mongo_spring_lab.votacao.model.Voto;
import br.wesley.mongo_spring_lab.votacao.service.VotoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
