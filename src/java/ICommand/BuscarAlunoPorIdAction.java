package ICommand;

import DAO.AlunoDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuscarAlunoPorIdAction implements ICommand {

    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("aluno", new AlunoDAO().buscarPorId(id));
        return "aluno_editar.jsp";
    }
}
