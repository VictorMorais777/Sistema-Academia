package ICommand;

import DAO.TreinoDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExcluirTreinoAction implements ICommand {

    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {
        new TreinoDAO().excluir(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("msg", "Treino excluído com sucesso!");
        req.setAttribute("treinos", new TreinoDAO().listar());
        return "treino_listar.jsp";
    }
}
