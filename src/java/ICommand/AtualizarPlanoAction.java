package ICommand;

import Builder.PlanoBuilder;
import Model.Plano;
import DAO.PlanoDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AtualizarPlanoAction implements ICommand {

    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {
        Plano p = new PlanoBuilder()
                .comId(Integer.parseInt(req.getParameter("id")))
                .comNomePlano(req.getParameter("nomePlano"))
                .comDescricao(req.getParameter("descricao"))
                .comValorMensal(Double.parseDouble(req.getParameter("valorMensal")))
                .comDuracaoMeses(Integer.parseInt(req.getParameter("duracaoMeses")))
                .comAcessoLivre(req.getParameter("acessoLivre"))
                .comTipoConvenio(req.getParameter("tipoConvenio"))
                .comQuantidadeAulas(Integer.parseInt(req.getParameter("quantidadeAulas")))
                .comTipoPlano(req.getParameter("tipoPlano"))
                .comDesconto(Double.parseDouble(req.getParameter("desconto")))
                .comStatus(req.getParameter("status"))
                .constroi();
        new PlanoDAO().atualizar(p);
        req.setAttribute("msg", "Plano atualizado com sucesso!");
        req.setAttribute("planos", new PlanoDAO().listar());
        return "plano_listar.jsp";
    }
}
