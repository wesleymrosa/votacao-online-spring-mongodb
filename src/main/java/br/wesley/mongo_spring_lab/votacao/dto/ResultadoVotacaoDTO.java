package br.wesley.mongo_spring_lab.votacao.dto;

public class ResultadoVotacaoDTO {

    private String id;
    private String nome;
    private String partido;
    private Integer numero;
    private Long quantidadeDeVotos;
    private String percentual;

    public ResultadoVotacaoDTO() {
    }

    public ResultadoVotacaoDTO(String id, String nome, String partido, Integer numero, Long quantidadeDeVotos, String percentual) {
        this.id = id;
        this.nome = nome;
        this.partido = partido;
        this.numero = numero;
        this.quantidadeDeVotos = quantidadeDeVotos;
        this.percentual = percentual;
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

    public Long getQuantidadeDeVotos() {
        return quantidadeDeVotos;
    }

    public void setQuantidadeDeVotos(Long quantidadeDeVotos) {
        this.quantidadeDeVotos = quantidadeDeVotos;
    }

    public String getPercentual() {
        return percentual;
    }

    public void setPercentual(String percentual) {
        this.percentual = percentual;
    }
}
