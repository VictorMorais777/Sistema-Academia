package ICommand;

import DAO.AlunoDAO;
import Model.Aluno;
import Seguranca.ValidacaoRequest;
import Seguranca.ValidadorSeguranca;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AtualizarAlunoAction implements ICommand {

    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {

        String nome      = ValidadorSeguranca.sanitizar(req.getParameter("nome"));
        String cpf       = ValidadorSeguranca.sanitizar(req.getParameter("cpf"));
        String telefone  = ValidadorSeguranca.sanitizar(req.getParameter("telefone"));
        String email     = ValidadorSeguranca.sanitizar(req.getParameter("email"));
        String objetivo  = ValidadorSeguranca.sanitizar(req.getParameter("objetivo"));
        String status    = ValidadorSeguranca.sanitizar(req.getParameter("status"));
        String pesoStr   = req.getParameter("peso");
        String alturaStr = req.getParameter("altura");

        String erro = new ValidacaoRequest()
                .regra(ValidadorSeguranca.campoObrigatorio(nome), "Erro: Nome e obrigatorio.")
                .regra(ValidadorSeguranca.cpfValido(cpf),         "Erro: CPF invalido.")
                .regra(ValidadorSeguranca.emailValido(email),     "Erro: E-mail invalido.")
                .validar();

        if (erro != null) {
            req.setAttribute("msg", erro);
            req.setAttribute("aluno", new AlunoDAO().buscarPorId(Integer.parseInt(req.getParameter("id"))));
            return "aluno_editar.jsp";
        }

        Aluno a = Aluno.fromRequestAtualizar(req, nome, cpf, telefone, email, objetivo, status, pesoStr, alturaStr);
        new AlunoDAO().atualizar(a);
        req.setAttribute("msg", "Aluno atualizado com sucesso!");
        req.setAttribute("alunos", new AlunoDAO().listar());
        return "aluno_listar.jsp";
    }
}
