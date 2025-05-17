
package br.wesley.mongo_spring_lab.votacao.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "votos")
public class Voto {

    @Id
    private String id;
    private String cpf;
    private String candidatoId;

    public Voto() {
    }

    public Voto(String cpf, String candidatoId) {
        this.cpf = cpf;
        this.candidatoId = candidatoId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCandidatoId() {
        return candidatoId;
    }

    public void setCandidatoId(String candidatoId) {
        this.candidatoId = candidatoId;
    }
}
