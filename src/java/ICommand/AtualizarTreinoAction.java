package ICommand;

import Builder.TreinoBuilder;
import Model.Treino;
import DAO.TreinoDAO;
import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AtualizarTreinoAction implements ICommand {

    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {
        Treino t = new TreinoBuilder()
                .comId(Integer.parseInt(req.getParameter("id")))
                .comNomeTreino(req.getParameter("nomeTreino"))
                .comObjetivo(req.getParameter("objetivo"))
                .comNivel(req.getParameter("nivel"))
                .comDuracaoMinutos(Integer.parseInt(req.getParameter("duracaoMinutos")))
                .comQuantidadeExercicios(Integer.parseInt(req.getParameter("quantidadeExercicios")))
                .comDescricao(req.getParameter("descricao"))
                .comDataCriacao(LocalDate.parse(req.getParameter("dataCriacao")))
                .comObservacoes(req.getParameter("observacoes"))
                .comStatus(req.getParameter("status"))
                .constroi();
        new TreinoDAO().atualizar(t);
        req.setAttribute("msg", "Treino atualizado com sucesso!");
        req.setAttribute("treinos", new TreinoDAO().listar());
        return "treino_listar.jsp";
    }
}
