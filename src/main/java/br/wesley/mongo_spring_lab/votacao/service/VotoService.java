package br.wesley.mongo_spring_lab.votacao.service;

import br.wesley.mongo_spring_lab.votacao.dto.ResultadoVotacaoDTO;
import br.wesley.mongo_spring_lab.votacao.dto.VotoDTO;
import br.wesley.mongo_spring_lab.votacao.model.Candidato;
import br.wesley.mongo_spring_lab.votacao.model.Voto;
import br.wesley.mongo_spring_lab.votacao.repository.CandidatoRepository;
import br.wesley.mongo_spring_lab.votacao.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VotoService {

    @Autowired
    private VotoRepository votoRepository;

    @Autowired
    private CandidatoRepository candidatoRepository;

    public Voto votar(VotoDTO dto) {
        Optional<Voto> existente = votoRepository.findByCpf(dto.getCpf());
        if (existente.isPresent()) {
            throw new RuntimeException("Este CPF já votou.");
        }

        Voto voto = new Voto(dto.getCpf(), dto.getCandidatoId());
        return votoRepository.save(voto);
    }

    public List<Voto> listarTodos() {
        return votoRepository.findAll();
    }

    public List<ResultadoVotacaoDTO> apurarResultado() {
        List<Voto> votos = votoRepository.findAll();
        List<Candidato> candidatos = candidatoRepository.findAll();

        long totalVotos = votos.size();

        Map<String, Long> votosPorCandidato = votos.stream()
                .collect(Collectors.groupingBy(Voto::getCandidatoId, Collectors.counting()));

        return candidatos.stream()
                .map(c -> {
                    long qtde = votosPorCandidato.getOrDefault(c.getId(), 0L);
                    String percentual = totalVotos == 0 ? "0%" : String.format("%.2f%%", (qtde * 100.0) / totalVotos);
                    return new ResultadoVotacaoDTO(
                            c.getId(),
                            c.getNome(),
                            c.getPartido(),
                            c.getNumero(),
                            qtde,
                            percentual
                    );
                })
                .sorted(Comparator.comparingLong(ResultadoVotacaoDTO::getQuantidadeDeVotos).reversed())
                .collect(Collectors.toList());
    }

    public String gerarResultadoPorExtenso() {
        List<ResultadoVotacaoDTO> resultados = this.apurarResultado();
        return resultados.stream()
                .map(r -> String.format(
                        "Nome: %s, Partido: %s, Número: %d, Votos: %d, Percentual: %s;%n%s",
                        r.getNome(),
                        r.getPartido(),
                        r.getNumero(),
                        r.getQuantidadeDeVotos(),
                        r.getPercentual(),
                        ".".repeat(150)
                ))
                .collect(Collectors.joining(System.lineSeparator()));
    }

}
