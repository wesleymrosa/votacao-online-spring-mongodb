package br.wesley.mongo_spring_lab.votacao.service;

import br.wesley.mongo_spring_lab.votacao.dto.CandidatoDTO;
import br.wesley.mongo_spring_lab.votacao.model.Candidato;
import br.wesley.mongo_spring_lab.votacao.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidatoService {

    @Autowired
    private CandidatoRepository repository;

    public List<CandidatoDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public CandidatoDTO salvar(CandidatoDTO dto) {
        Candidato candidato = new Candidato(
                null,
                dto.getNome(),
                dto.getPartido(),
                dto.getNumero()
        );
        return toDTO(repository.save(candidato));
    }

    private CandidatoDTO toDTO(Candidato candidato) {
        return new CandidatoDTO(

                candidato.getNome(),
                candidato.getPartido(),
                candidato.getNumero()
        );
    }
}
