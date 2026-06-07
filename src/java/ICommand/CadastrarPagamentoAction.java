package ICommand;

import Builder.PagamentoBuilder;
import Model.Pagamento;
import DAO.PagamentoDAO;
import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastrarPagamentoAction implements ICommand {

    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {
        Pagamento p = new PagamentoBuilder()
                .comIdAluno(Integer.parseInt(req.getParameter("idAluno")))
                .comValor(Double.parseDouble(req.getParameter("valor")))
                .comDataVencimento(LocalDate.parse(req.getParameter("dataVencimento")))
                .comFormaPagamento(req.getParameter("formaPagamento"))
                .comStatus(req.getParameter("status"))
                .comMulta(0.0)
                .comDesconto(0.0)
                .comReferencia(req.getParameter("referencia"))
                .constroi();
        new PagamentoDAO().cadastrar(p);
        req.setAttribute("msg", "Pagamento cadastrado com sucesso!");
        req.setAttribute("pagamentos", new PagamentoDAO().listar());
        return "pagamento_listar.jsp";
    }
}
