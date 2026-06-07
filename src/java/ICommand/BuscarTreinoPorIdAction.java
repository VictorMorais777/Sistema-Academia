package ICommand;

import DAO.TreinoDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuscarTreinoPorIdAction implements ICommand {

    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {
        req.setAttribute("treino", new TreinoDAO().buscarPorId(Integer.parseInt(req.getParameter("id"))));
        return "treino_editar.jsp";
    }
}
