package Decorator;

import Model.Pagamento;
import java.util.List;


public class ComPagamentoDecorator extends RelatorioDecorator {

    private final List<Pagamento> pagamentos;

    public ComPagamentoDecorator(RelatorioAluno relatorio, List<Pagamento> pagamentos) {
        super(relatorio);
        this.pagamentos = pagamentos;
    }

    @Override
    public String gerar() {
        StringBuilder sb = new StringBuilder(super.gerar());
        //StringBuilder sb = new StringBuilder(relatorio.gerar());
        sb.append("\n\n--- HISTORICO DE PAGAMENTOS ---");

        if (pagamentos == null || pagamentos.isEmpty()) {
            sb.append("\nNenhum pagamento registrado.");
        } else {
            double totalPago = 0;
            for (Pagamento p : pagamentos) {
                sb.append("\n[").append(p.getId()).append("] ")
                  .append(p.getReferencia())
                  .append(" | R$ ").append(String.format("%.2f", p.getValor()))
                  .append(" | ").append(p.getFormaPagamento())
                  .append(" | ").append(p.getStatus());
                if ("Pago".equalsIgnoreCase(p.getStatus())) {
                    totalPago += p.getValor();
                }
            }
            sb.append("\nTotal pago: R$ ").append(String.format("%.2f", totalPago));
        }
        return sb.toString();
    }
}
