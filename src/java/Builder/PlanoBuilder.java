package Builder;

import Model.Plano;


public class PlanoBuilder {

    private Plano plano;

    public PlanoBuilder() {
        this.plano = new Plano();
    }

    public PlanoBuilder comId(int id) {
        plano.setId(id);
        return this;
    }

    public PlanoBuilder comNomePlano(String v) {
        plano.setNomePlano(v);
        return this;
    }

    public PlanoBuilder comDescricao(String v) {
        plano.setDescricao(v);
        return this;
    }

    public PlanoBuilder comValorMensal(double v) {
        plano.setValorMensal(v);
        return this;
    }

    public PlanoBuilder comDuracaoMeses(int v) {
        plano.setDuracaoMeses(v);
        return this;
    }

    public PlanoBuilder comAcessoLivre(String v) {
        plano.setAcessoLivre(v);
        return this;
    }

    public PlanoBuilder comTipoConvenio(String v) {
        plano.setTipoConvenio(v);
        return this;
    }

    public PlanoBuilder comQuantidadeAulas(int v) {
        plano.setQuantidadeAulas(v);
        return this;
    }

    public PlanoBuilder comTipoPlano(String v) {
        plano.setTipoPlano(v);
        return this;
    }

    public PlanoBuilder comDesconto(double v) {
        plano.setDesconto(v);
        return this;
    }

    public PlanoBuilder comStatus(String v) {
        plano.setStatus(v);
        return this;
    }

    public Plano constroi() {
        return plano;
    }
}
