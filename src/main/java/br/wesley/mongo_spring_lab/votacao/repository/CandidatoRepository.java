package br.wesley.mongo_spring_lab.votacao.repository;

import br.wesley.mongo_spring_lab.votacao.model.Candidato;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CandidatoRepository extends MongoRepository<Candidato, String> {
    boolean existsByNumero(Integer numero);
}
