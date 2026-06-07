package ICommand;

import DAO.PagamentoDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExcluirPagamentoAction implements ICommand {

    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {
        new PagamentoDAO().excluir(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("msg", "Pagamento excluído com sucesso!");
        req.setAttribute("pagamentos", new PagamentoDAO().listar());
        return "pagamento_listar.jsp";
    }
}
