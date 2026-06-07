package ICommand;

import DAO.AlunoDAO;
import Model.Aluno;
import Seguranca.ValidacaoRequest;
import Seguranca.ValidadorSeguranca;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastrarAlunoAction implements ICommand {

    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {

        String nome = ValidadorSeguranca.sanitizar(req.getParameter("nome"));
        String cpf = ValidadorSeguranca.sanitizar(req.getParameter("cpf"));
        String telefone = ValidadorSeguranca.sanitizar(req.getParameter("telefone"));
        String email = ValidadorSeguranca.sanitizar(req.getParameter("email"));
        String objetivo = ValidadorSeguranca.sanitizar(req.getParameter("objetivo"));
        String status = ValidadorSeguranca.sanitizar(req.getParameter("status"));
        String pesoStr = req.getParameter("peso");
        String alturaStr = req.getParameter("altura");

        String erro = new ValidacaoRequest()
                .regra(ValidadorSeguranca.campoObrigatorio(nome), "Erro: Nome e obrigatorio.")
                .regra(ValidadorSeguranca.cpfValido(cpf), "Erro: CPF invalido. Informe 11 digitos numericos.")
                .regra(ValidadorSeguranca.emailValido(email), "Erro: E-mail invalido.")
                .regra(ValidadorSeguranca.numeroPositivo(pesoStr), "Erro: Peso deve ser valor positivo.")
                .regra(ValidadorSeguranca.numeroPositivo(alturaStr), "Erro: Altura deve ser valor positivo.")
                .validar();

        if (erro != null) {
            req.setAttribute("msg", erro);
            return "aluno_criar.jsp";
        }

        Aluno a = Aluno.fromRequest(req, nome, cpf, telefone, email, objetivo, status, pesoStr, alturaStr);
        new AlunoDAO().cadastrar(a);
        req.setAttribute("msg", "Aluno cadastrado com sucesso!");
        return "aluno_listar.jsp";
    }
}
