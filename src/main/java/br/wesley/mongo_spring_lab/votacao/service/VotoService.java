package br.wesley.mongo_spring_lab.votacao.service;

import br.wesley.mongo_spring_lab.votacao.dto.VotoDTO;
import br.wesley.mongo_spring_lab.votacao.model.Voto;
import br.wesley.mongo_spring_lab.votacao.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VotoService {

    @Autowired
    private VotoRepository votoRepository;

    public Voto votar(VotoDTO dto) {
        Optional<Voto> existente = votoRepository.findByCpf(dto.getCpf());

        if (existente.isPresent()) {
            throw new RuntimeException("Este CPF já votou.");
        }

        Voto voto = new Voto(dto.getCpf(), dto.getCandidatoId());
        return votoRepository.save(voto);
    }
}
