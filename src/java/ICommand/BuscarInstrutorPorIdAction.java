package ICommand;

import DAO.InstrutorDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuscarInstrutorPorIdAction implements ICommand {

    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {
        req.setAttribute("instrutor", new InstrutorDAO().buscarPorId(Integer.parseInt(req.getParameter("id"))));
        return "instrutor_editar.jsp";
    }
}
