package br.wesley.mongo_spring_lab.votacao.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "candidatos")
public class Candidato {

    @Id
    private String id;

    private String nome;
    private String partido;
    private Integer numero;

    public Candidato() {
    }

    public Candidato(String id, String nome, String partido, Integer numero) {
        this.id = id;
        this.nome = nome;
        this.partido = partido;
        this.numero = numero;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
}
