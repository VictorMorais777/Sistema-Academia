package Decorator;


public abstract class RelatorioDecorator implements RelatorioAluno {

    protected final RelatorioAluno relatorio;

    public RelatorioDecorator(RelatorioAluno relatorio) {
        this.relatorio = relatorio;
    }

    @Override
    public String gerar() {
        return relatorio.gerar();
    }
}
