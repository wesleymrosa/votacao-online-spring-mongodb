package br.wesley.mongo_spring_lab.votacao.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class VotoDTO {

    @NotBlank(message = "O CPF é obrigatório")
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 dígitos numéricos")
    private String cpf;

    @NotBlank(message = "O ID do candidato é obrigatório")
    private String candidatoId;

    public VotoDTO() {
    }

    public VotoDTO(String cpf, String candidatoId) {
        this.cpf = cpf;
        this.candidatoId = candidatoId;
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
