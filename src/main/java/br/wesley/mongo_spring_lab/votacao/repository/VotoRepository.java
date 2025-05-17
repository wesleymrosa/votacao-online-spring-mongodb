package br.wesley.mongo_spring_lab.votacao.repository;

import br.wesley.mongo_spring_lab.votacao.model.Voto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface VotoRepository extends MongoRepository<Voto, String> {
    Optional<Voto> findByCpf(String cpf);
}
