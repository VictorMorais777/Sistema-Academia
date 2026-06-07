package ICommand;

import DAO.PlanoDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListarPlanoAction implements ICommand {

    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {
        req.setAttribute("planos", new PlanoDAO().listar());
        return "plano_listar.jsp";
    }
}
