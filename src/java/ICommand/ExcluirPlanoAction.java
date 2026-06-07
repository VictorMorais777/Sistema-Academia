package ICommand;

import DAO.PlanoDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExcluirPlanoAction implements ICommand {

    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {
        new PlanoDAO().excluir(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("msg", "Plano excluído com sucesso!");
        req.setAttribute("planos", new PlanoDAO().listar());
        return "plano_listar.jsp";
    }
}
