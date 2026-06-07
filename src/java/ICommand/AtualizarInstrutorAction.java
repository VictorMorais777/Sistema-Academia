package ICommand;

import DAO.InstrutorDAO;
import Model.Instrutor;
import Seguranca.ValidacaoRequest;
import Seguranca.ValidadorSeguranca;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AtualizarInstrutorAction implements ICommand {

    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {

        String nome  = ValidadorSeguranca.sanitizar(req.getParameter("nome"));
        String cpf   = ValidadorSeguranca.sanitizar(req.getParameter("cpf"));
        String email = ValidadorSeguranca.sanitizar(req.getParameter("email"));

        String erro = new ValidacaoRequest()
                .regra(ValidadorSeguranca.campoObrigatorio(nome), "Erro: Nome e obrigatorio.")
                .regra(ValidadorSeguranca.cpfValido(cpf),         "Erro: CPF invalido.")
                .regra(email.isEmpty() || ValidadorSeguranca.emailValido(email), "Erro: E-mail invalido.")
                .validar();

        if (erro != null) {
            req.setAttribute("msg", erro);
            req.setAttribute("instrutor", new InstrutorDAO().buscarPorId(Integer.parseInt(req.getParameter("id"))));
            return "instrutor_editar.jsp";
        }

        Instrutor i = Instrutor.fromRequestAtualizar(req, nome, cpf, email);
        new InstrutorDAO().atualizar(i);
        req.setAttribute("msg", "Instrutor atualizado com sucesso!");
        req.setAttribute("instrutores", new InstrutorDAO().listar());
        return "instrutor_listar.jsp";
    }
}
