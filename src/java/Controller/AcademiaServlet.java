package Controller;

import ICommand.CommandFactory;
import ICommand.ICommand;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AcademiaServlet", urlPatterns = {"/AcademiaServlet"})
public class AcademiaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        processar(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        processar(req, res);
    }

    private void processar(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        String pagina = "index.html";

        try {
            ICommand command = CommandFactory.getCommand(action);

            if (command != null) {
                pagina = command.executar(req, res);
            } else {
                req.setAttribute("msg", "Acao nao reconhecida: " + action);
                pagina = "index.html";
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            req.setAttribute("msg", "Erro: " + ex.getMessage());
            if (action != null && action.contains("Aluno")) {
                pagina = "aluno_listar.jsp";
            } else if (action != null && action.contains("Instrutor")) {
                pagina = "instrutor_listar.jsp";
            } else if (action != null && action.contains("Plano")) {
                pagina = "plano_listar.jsp";
            } else if (action != null && action.contains("Treino")) {
                pagina = "treino_listar.jsp";
            } else if (action != null && action.contains("Pagamento")) {
                pagina = "pagamento_listar.jsp";
            } else {
                pagina = "index.html";
            }
        }

        req.getRequestDispatcher(pagina).forward(req, res);
    }
}
