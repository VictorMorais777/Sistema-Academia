package Model;

public class Plano {

    private int id;
    private String nomePlano;
    private String descricao;
    private double valorMensal;
    private int duracaoMeses;
    private String acessoLivre;
    private String tipoConvenio;
    private int quantidadeAulas;
    private String tipoPlano;
    private double desconto;
    private String status;

    public Plano() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomePlano() {
        return nomePlano;
    }

    public void setNomePlano(String v) {
        this.nomePlano = v;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String v) {
        this.descricao = v;
    }

    public double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(double v) {
        this.valorMensal = v;
    }

    public int getDuracaoMeses() {
        return duracaoMeses;
    }

    public void setDuracaoMeses(int v) {
        this.duracaoMeses = v;
    }

    public String getAcessoLivre() {
        return acessoLivre;
    }

    public void setAcessoLivre(String v) {
        this.acessoLivre = v;
    }

    public String getTipoConvenio() {
        return tipoConvenio;
    }

    public void setTipoConvenio(String v) {
        this.tipoConvenio = v;
    }

    public int getQuantidadeAulas() {
        return quantidadeAulas;
    }

    public void setQuantidadeAulas(int v) {
        this.quantidadeAulas = v;
    }

    public String getTipoPlano() {
        return tipoPlano;
    }

    public void setTipoPlano(String v) {
        this.tipoPlano = v;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double v) {
        this.desconto = v;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String v) {
        this.status = v;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {

        private Plano p = new Plano();

        public Builder comId(int v) {
            p.id = v;
            return this;
        }

        public Builder comNomePlano(String v) {
            p.nomePlano = v;
            return this;
        }

        public Builder comDescricao(String v) {
            p.descricao = v;
            return this;
        }

        public Builder comValorMensal(double v) {
            p.valorMensal = v;
            return this;
        }

        public Builder comDuracaoMeses(int v) {
            p.duracaoMeses = v;
            return this;
        }

        public Builder comAcessoLivre(String v) {
            p.acessoLivre = v;
            return this;
        }

        public Builder comTipoConvenio(String v) {
            p.tipoConvenio = v;
            return this;
        }

        public Builder comQuantidadeAulas(int v) {
            p.quantidadeAulas = v;
            return this;
        }

        public Builder comTipoPlano(String v) {
            p.tipoPlano = v;
            return this;
        }

        public Builder comDesconto(double v) {
            p.desconto = v;
            return this;
        }

        public Builder comStatus(String v) {
            p.status = v;
            return this;
        }

        public Plano constroi() {
            return p;
        }
    }
}
