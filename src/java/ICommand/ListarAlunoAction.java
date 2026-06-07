package ICommand;

import DAO.AlunoDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListarAlunoAction implements ICommand {

    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {
        req.setAttribute("alunos", new AlunoDAO().listar());
        return "aluno_listar.jsp";
    }
}
