package ICommand;

import DAO.PagamentoDAO;
import Model.Pagamento;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class VerificarInadimplenciaAction implements ICommand {

    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {
        PagamentoDAO dao = new PagamentoDAO();
        List<Pagamento> todos = dao.listar();
        LocalDate hoje = LocalDate.now();
        int atualizados = 0;

        for (Pagamento p : todos) {
            boolean vencido = p.getDataVencimento().isBefore(hoje);
            boolean pendente = "Pendente".equalsIgnoreCase(p.getStatus());
            if (vencido && pendente) {
                p.setStatus("Inadimplente");
                p.setMulta(p.getValor() * 0.02);
                dao.atualizar(p);
                atualizados++;
            }
        }

        List<Pagamento> inadimplentes = dao.listar().stream()
                .filter(p -> "Inadimplente".equalsIgnoreCase(p.getStatus()))
                .collect(Collectors.toList());

        req.setAttribute("inadimplentes", inadimplentes);
        req.setAttribute("msg", "Verificacao concluida. " + atualizados + " pagamento(s) atualizado(s) para Inadimplente.");
        return "inadimplencia_relatorio.jsp";
    }
}
