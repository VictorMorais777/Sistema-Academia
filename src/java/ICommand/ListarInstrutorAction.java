package ICommand;

import DAO.InstrutorDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListarInstrutorAction implements ICommand {

    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {
        req.setAttribute("instrutores", new InstrutorDAO().listar());
        return "instrutor_listar.jsp";
    }
}
