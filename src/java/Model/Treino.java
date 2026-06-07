package Model;

import java.time.LocalDate;

public class Treino {

    private int id;
    private String nomeTreino;
    private String objetivo;
    private String nivel;
    private int duracaoMinutos;
    private int quantidadeExercicios;
    private String descricao;
    private LocalDate dataCriacao;
    private String observacoes;
    private String status;

    public Treino() {
    }

    public int getId() {
        return id;
    }

    public void setId(int v) {
        this.id = v;
    }

    public String getNomeTreino() {
        return nomeTreino;
    }

    public void setNomeTreino(String v) {
        this.nomeTreino = v;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String v) {
        this.objetivo = v;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String v) {
        this.nivel = v;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int v) {
        this.duracaoMinutos = v;
    }

    public int getQuantidadeExercicios() {
        return quantidadeExercicios;
    }

    public void setQuantidadeExercicios(int v) {
        this.quantidadeExercicios = v;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String v) {
        this.descricao = v;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate v) {
        this.dataCriacao = v;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String v) {
        this.observacoes = v;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String v) {
        this.status = v;
    }


    public static Treino criarParaTeste(int id, String nomeTreino, String objetivo,
            String nivel, int duracaoMinutos, int quantidadeExercicios) {
        Treino t = new Treino();
        t.setId(id);
        t.setNomeTreino(nomeTreino);
        t.setObjetivo(objetivo);
        t.setNivel(nivel);
        t.setDuracaoMinutos(duracaoMinutos);
        t.setQuantidadeExercicios(quantidadeExercicios);
        t.setDataCriacao(java.time.LocalDate.now());
        t.setStatus("Ativo");
        return t;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {

        private Treino t = new Treino();

        public Builder comId(int v) {
            t.id = v;
            return this;
        }

        public Builder comNomeTreino(String v) {
            t.nomeTreino = v;
            return this;
        }

        public Builder comObjetivo(String v) {
            t.objetivo = v;
            return this;
        }

        public Builder comNivel(String v) {
            t.nivel = v;
            return this;
        }

        public Builder comDuracaoMinutos(int v) {
            t.duracaoMinutos = v;
            return this;
        }

        public Builder comQuantidadeExercicios(int v) {
            t.quantidadeExercicios = v;
            return this;
        }

        public Builder comDescricao(String v) {
            t.descricao = v;
            return this;
        }

        public Builder comDataCriacao(LocalDate v) {
            t.dataCriacao = v;
            return this;
        }

        public Builder comObservacoes(String v) {
            t.observacoes = v;
            return this;
        }

        public Builder comStatus(String v) {
            t.status = v;
            return this;
        }

        public Treino constroi() {
            return t;
        }
    }
}
