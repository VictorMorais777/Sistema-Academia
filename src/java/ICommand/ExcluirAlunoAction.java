package ICommand;

import DAO.AlunoDAO;
import DAO.PagamentoDAO;
import Model.Pagamento;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExcluirAlunoAction implements ICommand {

    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {
        int id = Integer.parseInt(req.getParameter("id"));

        PagamentoDAO pagamentoDAO = new PagamentoDAO();
        List<Pagamento> pagamentos = pagamentoDAO.listarPorAluno(id);

        boolean temDebito = pagamentos.stream().anyMatch(p
                -> "Pendente".equalsIgnoreCase(p.getStatus())
                || "Inadimplente".equalsIgnoreCase(p.getStatus()));

        if (temDebito) {
            req.setAttribute("msg", "Erro: Este aluno possui pagamentos em aberto e nao pode ser excluido.");
            req.setAttribute("alunos", new AlunoDAO().listar());
            return "aluno_listar.jsp";
        }

        for (Pagamento p : pagamentos) {
            pagamentoDAO.excluir(p.getId());
        }

        new AlunoDAO().excluir(id);
        req.setAttribute("msg", "Aluno excluido com sucesso!");
        req.setAttribute("alunos", new AlunoDAO().listar());
        return "aluno_listar.jsp";
    }
}
