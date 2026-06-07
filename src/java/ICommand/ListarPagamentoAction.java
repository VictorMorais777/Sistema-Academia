package ICommand;

import DAO.PagamentoDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListarPagamentoAction implements ICommand {

    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {
        req.setAttribute("pagamentos", new PagamentoDAO().listar());
        return "pagamento_listar.jsp";
    }
}
