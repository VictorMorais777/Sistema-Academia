package Decorator;

import Model.Pagamento;
import java.time.LocalDate;
import java.util.List;


public class ComInadimplenciaDecorator extends RelatorioDecorator {

    private final List<Pagamento> pagamentos;

    public ComInadimplenciaDecorator(RelatorioAluno relatorio, List<Pagamento> pagamentos) {
        super(relatorio);
        this.pagamentos = pagamentos;
    }

    @Override
    public String gerar() {
        StringBuilder sb = new StringBuilder(super.gerar());
        //StringBuilder sb = new StringBuilder(relatorio.gerar());
        sb.append("\n\n--- ANALISE DE INADIMPLENCIA (AUTOMACAO) ---");

        if (pagamentos == null || pagamentos.isEmpty()) {
            sb.append("\nSem pendencias financeiras.");
            return sb.toString();
        }

        double totalDebito = 0;
        int qtdVencidos = 0;
        LocalDate hoje = LocalDate.now();

        for (Pagamento p : pagamentos) {
            boolean vencido = p.getDataVencimento().isBefore(hoje);
            boolean pendente = "Pendente".equalsIgnoreCase(p.getStatus())
                            || "Inadimplente".equalsIgnoreCase(p.getStatus());

            if (vencido && pendente) {
                double multa = p.getValor() * 0.02;
                double totalComMulta = p.getValor() + multa;
                totalDebito += totalComMulta;
                qtdVencidos++;
                sb.append("\n[VENCIDO] Ref: ").append(p.getReferencia())
                  .append(" | Valor: R$ ").append(String.format("%.2f", p.getValor()))
                  .append(" | Multa (2%%): R$ ").append(String.format("%.2f", multa))
                  .append(" | Total: R$ ").append(String.format("%.2f", totalComMulta));
            }
        }

        if (qtdVencidos == 0) {
            sb.append("\nAluno em dia com seus pagamentos.");
        } else {
            sb.append("\n*** TOTAL EM ABERTO: R$ ").append(String.format("%.2f", totalDebito))
              .append(" (").append(qtdVencidos).append(" pagamento(s) vencido(s)) ***");
        }

        return sb.toString();
    }
}
