<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="UTF-8">
        <title>Alunos</title>
        <link rel="stylesheet" href="estilo.css">
    </head>
    <body>
        <header><h1>🏋️ Sistema Academia</h1></header>
        <nav>
            <a href="index.html">Home</a>
            <a href="AcademiaServlet?action=listarAluno" class="ativo">Alunos</a>
            <a href="AcademiaServlet?action=listarInstrutor">Instrutores</a>
            <a href="AcademiaServlet?action=listarPlano">Planos</a>
            <a href="AcademiaServlet?action=listarTreino">Treinos</a>
            <a href="AcademiaServlet?action=listarPagamento">Pagamentos</a>
            <a href="AcademiaServlet?action=verificarInadimplencia">Inadimplência</a>
        </nav>

        <div class="container">
            <div class="card">
                <h2>Alunos Cadastrados</h2>

                <div style="display:flex;flex-wrap:wrap;gap:10px;margin-bottom:14px;align-items:center">
                    <a href="aluno_criar.jsp" class="btn btn-primary">+ Novo Aluno</a>

                    <form action="AcademiaServlet" method="get"
                          style="display:flex;gap:6px;align-items:center;margin-left:auto">
                        <input type="hidden" name="action" value="buscarAlunoPorCpf">
                        <input type="text" name="cpf" placeholder="Buscar por CPF..."
                               style="width:200px;margin:0" maxlength="14">
                        <button type="submit" class="btn btn-secondary">🔍 Buscar</button>
                    </form>
                </div>

                <c:if test="${not empty msg}">
                    <div class="${msg.startsWith('Erro') ? 'msg-err' : 'msg-ok'}">${msg}</div>
                </c:if>

                <table>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>CPF</th>
                        <th>Objetivo</th>
                        <th>Status</th>
                        <th>Ações</th>
                    </tr>
                    <c:forEach var="a" items="${alunos}">
                        <tr>
                            <td>${a.id}</td>
                            <td>${a.nome}</td>
                            <td>${a.cpf}</td>
                            <td>${a.objetivo}</td>
                            <td>
                                <span class="badge badge-${a.status == 'Ativo' ? 'ativo' : 'inativo'}">${a.status}</span>
                            </td>
                            <td class="acoes">
                                <a href="AcademiaServlet?action=buscarAlunoPorId&id=${a.id}" class="btn btn-warning">Editar</a>
                        <a href="AcademiaServlet?action=gerarRelatorio&id=${a.id}" class="btn btn-secondary">Relatorio</a>
                                <a href="aluno_excluir.html?id=${a.id}" class="btn btn-danger">Excluir</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
