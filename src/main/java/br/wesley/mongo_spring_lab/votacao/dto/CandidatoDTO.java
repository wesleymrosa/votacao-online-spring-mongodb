package br.wesley.mongo_spring_lab.votacao.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CandidatoDTO {


    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O partido é obrigatório")
    private String partido;

    @NotNull(message = "O número é obrigatório")
    private Integer numero;

    public CandidatoDTO() {
    }

    public CandidatoDTO(String nome, String partido, Integer numero) {

        this.nome = nome;
        this.partido = partido;
        this.numero = numero;
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
