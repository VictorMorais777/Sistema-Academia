package Builder;

import Model.Pagamento;
import java.time.LocalDate;

public class PagamentoBuilder {

    private final Pagamento p = new Pagamento();

    public PagamentoBuilder comId(int v) {
        p.setId(v);
        return this;
    }

    public PagamentoBuilder comIdAluno(int v) {
        p.setIdAluno(v);
        return this;
    }

    public PagamentoBuilder comNomeAluno(String v) {
        p.setNomeAluno(v);
        return this;
    }

    public PagamentoBuilder comValor(double v) {
        p.setValor(v);
        return this;
    }

    public PagamentoBuilder comDataPagamento(LocalDate v) {
        p.setDataPagamento(v);
        return this;
    }

    public PagamentoBuilder comDataVencimento(LocalDate v) {
        p.setDataVencimento(v);
        return this;
    }

    public PagamentoBuilder comFormaPagamento(String v) {
        p.setFormaPagamento(v);
        return this;
    }

    public PagamentoBuilder comStatus(String v) {
        p.setStatus(v);
        return this;
    }

    public PagamentoBuilder comMulta(double v) {
        p.setMulta(v);
        return this;
    }

    public PagamentoBuilder comDesconto(double v) {
        p.setDesconto(v);
        return this;
    }

    public PagamentoBuilder comComprovante(String v) {
        p.setComprovante(v);
        return this;
    }

    public PagamentoBuilder comReferencia(String v) {
        p.setReferencia(v);
        return this;
    }

    public Pagamento constroi() {
        return p;
    }
}
