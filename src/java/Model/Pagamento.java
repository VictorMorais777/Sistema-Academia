package Model;

import java.time.LocalDate;

public class Pagamento {

    private int id;
    private int idAluno;
    private String nomeAluno;  
    private double valor;
    private LocalDate dataPagamento;
    private LocalDate dataVencimento;
    private String formaPagamento;
    private String status;
    private double multa;
    private double desconto;
    private String comprovante;
    private String referencia;

    public Pagamento() {
    }

    public int getId() {
        return id;
    }

    public void setId(int v) {
        this.id = v;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int v) {
        this.idAluno = v;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String v) {
        this.nomeAluno = v;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double v) {
        this.valor = v;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate v) {
        this.dataPagamento = v;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate v) {
        this.dataVencimento = v;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String v) {
        this.formaPagamento = v;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String v) {
        this.status = v;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double v) {
        this.multa = v;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double v) {
        this.desconto = v;
    }

    public String getComprovante() {
        return comprovante;
    }

    public void setComprovante(String v) {
        this.comprovante = v;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String v) {
        this.referencia = v;
    }


    public static Pagamento criarParaTeste(int id, int idAluno, double valor,
            int diasVencimento, String status, String referencia) {
        Pagamento p = new Pagamento();
        p.setId(id);
        p.setIdAluno(idAluno);
        p.setValor(valor);
        p.setDataVencimento(java.time.LocalDate.now().plusDays(diasVencimento));
        p.setStatus(status);
        p.setReferencia(referencia);
        p.setMulta(0.0);
        p.setDesconto(0.0);
        return p;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {

        private Pagamento p = new Pagamento();

        public Builder comId(int v) {
            p.id = v;
            return this;
        }

        public Builder comIdAluno(int v) {
            p.idAluno = v;
            return this;
        }

        public Builder comNomeAluno(String v) {
            p.nomeAluno = v;
            return this;
        }

        public Builder comValor(double v) {
            p.valor = v;
            return this;
        }

        public Builder comDataPagamento(LocalDate v) {
            p.dataPagamento = v;
            return this;
        }

        public Builder comDataVencimento(LocalDate v) {
            p.dataVencimento = v;
            return this;
        }

        public Builder comFormaPagamento(String v) {
            p.formaPagamento = v;
            return this;
        }

        public Builder comStatus(String v) {
            p.status = v;
            return this;
        }

        public Builder comMulta(double v) {
            p.multa = v;
            return this;
        }

        public Builder comDesconto(double v) {
            p.desconto = v;
            return this;
        }

        public Builder comComprovante(String v) {
            p.comprovante = v;
            return this;
        }

        public Builder comReferencia(String v) {
            p.referencia = v;
            return this;
        }

        public Pagamento constroi() {
            return p;
        }
    }
}
