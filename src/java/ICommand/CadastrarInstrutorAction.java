package ICommand;

import DAO.InstrutorDAO;
import Model.Instrutor;
import Seguranca.ValidacaoRequest;
import Seguranca.ValidadorSeguranca;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastrarInstrutorAction implements ICommand {

    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {

        String nome      = ValidadorSeguranca.sanitizar(req.getParameter("nome"));
        String cpf       = ValidadorSeguranca.sanitizar(req.getParameter("cpf"));
        String email     = ValidadorSeguranca.sanitizar(req.getParameter("email"));
        String salario   = req.getParameter("salario");

        String erro = new ValidacaoRequest()
                .regra(ValidadorSeguranca.campoObrigatorio(nome),  "Erro: Nome e obrigatorio.")
                .regra(ValidadorSeguranca.cpfValido(cpf),          "Erro: CPF invalido. Informe 11 digitos.")
                .regra(email.isEmpty() || ValidadorSeguranca.emailValido(email), "Erro: E-mail invalido.")
                .regra(ValidadorSeguranca.numeroPositivo(salario), "Erro: Salario deve ser valor positivo.")
                .validar();

        if (erro != null) {
            req.setAttribute("msg", erro);
            return "instrutor_criar.jsp";
        }

        Instrutor i = Instrutor.fromRequest(req, nome, cpf, email);
        new InstrutorDAO().cadastrar(i);
        req.setAttribute("msg", "Instrutor cadastrado com sucesso!");
        req.setAttribute("instrutores", new InstrutorDAO().listar());
        return "instrutor_listar.jsp";
    }
}
