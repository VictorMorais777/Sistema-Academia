package ICommand;

import DAO.PagamentoDAO;
import Model.Pagamento;
import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AtualizarPagamentoAction implements ICommand {

    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String dataPagamentoStr = req.getParameter("dataPagamento");
        Pagamento p = Pagamento.getBuilder()
                .comId(Integer.parseInt(req.getParameter("id")))
                .comIdAluno(Integer.parseInt(req.getParameter("idAluno")))
                .comValor(Double.parseDouble(req.getParameter("valor")))
                .comDataPagamento(dataPagamentoStr != null && !dataPagamentoStr.isBlank()
                        ? LocalDate.parse(dataPagamentoStr) : null)
                .comDataVencimento(LocalDate.parse(req.getParameter("dataVencimento")))
                .comFormaPagamento(req.getParameter("formaPagamento"))
                .comStatus(req.getParameter("status"))
                .comMulta(Double.parseDouble(req.getParameter("multa")))
                .comDesconto(Double.parseDouble(req.getParameter("desconto")))
                .comReferencia(req.getParameter("referencia"))
                .constroi();
        new PagamentoDAO().atualizar(p);
        req.setAttribute("msg", "Pagamento atualizado com sucesso!");
        req.setAttribute("pagamentos", new PagamentoDAO().listar());
        return "pagamento_listar.jsp";
    }
}
