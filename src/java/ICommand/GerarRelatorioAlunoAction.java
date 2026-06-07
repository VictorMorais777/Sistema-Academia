package ICommand;

import DAO.AlunoDAO;
import DAO.PagamentoDAO;
import DAO.TreinoDAO;
import Decorator.ComInadimplenciaDecorator;
import Decorator.ComPagamentoDecorator;
import Decorator.ComTreinoDecorator;
import Decorator.RelatorioAluno;
import Decorator.RelatorioAlunoBase;
import Model.Aluno;
import Model.Pagamento;
import Model.Treino;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GerarRelatorioAlunoAction implements ICommand {

    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {
        int idAluno = Integer.parseInt(req.getParameter("id"));

        Aluno aluno = new AlunoDAO().buscarPorId(idAluno);
        if (aluno == null) {
            req.setAttribute("msg", "Aluno nao encontrado.");
            return "aluno_listar.jsp";
        }

        req.setAttribute("aluno", aluno);

 
        boolean algumSelecionado = req.getParameter("dadosAluno") != null
                || req.getParameter("treino") != null
                || req.getParameter("pagamentos") != null
                || req.getParameter("inadimplencia") != null;

        if (!algumSelecionado) {
            return "relatorio_aluno.jsp";
        }

        RelatorioAluno relatorio = null;

        if (req.getParameter("dadosAluno") != null) {
            relatorio = new RelatorioAlunoBase(aluno);
        }

        if (req.getParameter("treino") != null) {
            Treino treino = new TreinoDAO().buscarPorId(aluno.getIdTreino());
            relatorio = relatorio != null
                    ? new ComTreinoDecorator(relatorio, treino)
                    : new ComTreinoDecorator(new RelatorioAlunoBase(aluno), treino);
        }

        if (req.getParameter("pagamentos") != null) {
            List<Pagamento> pagamentos = new PagamentoDAO().listarPorAluno(idAluno);
            relatorio = relatorio != null
                    ? new ComPagamentoDecorator(relatorio, pagamentos)
                    : new ComPagamentoDecorator(new RelatorioAlunoBase(aluno), pagamentos);
        }

        if (req.getParameter("inadimplencia") != null) {
            List<Pagamento> pagamentos = new PagamentoDAO().listarPorAluno(idAluno);
            relatorio = relatorio != null
                    ? new ComInadimplenciaDecorator(relatorio, pagamentos)
                    : new ComInadimplenciaDecorator(new RelatorioAlunoBase(aluno), pagamentos);
        }

        req.setAttribute("relatorio", relatorio != null ? relatorio.gerar() : "Nenhuma opcao selecionada.");
        return "relatorio_aluno.jsp";
    }
}
