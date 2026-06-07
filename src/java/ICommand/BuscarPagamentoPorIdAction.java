package ICommand;

import DAO.PagamentoDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuscarPagamentoPorIdAction implements ICommand {

    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {
        req.setAttribute("pagamento", new PagamentoDAO().buscarPorId(Integer.parseInt(req.getParameter("id"))));
        return "pagamento_editar.jsp";
    }
}
