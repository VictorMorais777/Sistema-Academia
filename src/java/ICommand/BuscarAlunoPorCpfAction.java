package ICommand;

import DAO.AlunoDAO;
import Model.Aluno;
import Seguranca.ValidacaoRequest;
import Seguranca.ValidadorSeguranca;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Consulta aluno pelo CPF.
 */
public class BuscarAlunoPorCpfAction implements ICommand {

    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String cpf = ValidadorSeguranca.sanitizar(req.getParameter("cpf"));

        String erro = new ValidacaoRequest()
                .regra(ValidadorSeguranca.cpfValido(cpf), "Erro: CPF invalido. Informe 11 digitos numericos.")
                .validar();

        if (erro != null) {
            req.setAttribute("msg", erro);
            req.setAttribute("alunos", new AlunoDAO().listar());
            return "aluno_listar.jsp";
        }

        Aluno aluno = new AlunoDAO().buscarPorCpf(cpf);
        String paginaRetorno = aluno != null ? "aluno_resultado_cpf.jsp" : "aluno_listar.jsp";

        req.setAttribute("aluno", aluno);
        if (aluno == null) {
            req.setAttribute("msg", "Nenhum aluno encontrado com o CPF informado.");
            req.setAttribute("alunos", new AlunoDAO().listar());
        }
        return paginaRetorno;
    }
}
