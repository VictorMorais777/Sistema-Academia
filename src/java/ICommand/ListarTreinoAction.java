package ICommand;

import DAO.TreinoDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListarTreinoAction implements ICommand {

    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {
        req.setAttribute("treinos", new TreinoDAO().listar());
        return "treino_listar.jsp";
    }
}
