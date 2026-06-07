package ICommand;

import DAO.InstrutorDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExcluirInstrutorAction implements ICommand {

    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {
        new InstrutorDAO().excluir(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("msg", "Instrutor excluído com sucesso!");
        req.setAttribute("instrutores", new InstrutorDAO().listar());
        return "instrutor_listar.jsp";
    }
}
