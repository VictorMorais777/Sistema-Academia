package ICommand;

import DAO.PlanoDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuscarPlanoPorIdAction implements ICommand {

    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {
        req.setAttribute("plano", new PlanoDAO().buscarPorId(Integer.parseInt(req.getParameter("id"))));
        return "plano_editar.jsp";
    }
}
