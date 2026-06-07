<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html><html lang="pt-BR"><head><meta charset="UTF-8"><title>Treinos</title>
        <link rel="stylesheet" href="estilo.css"></head>
    <body>
        <header><h1>🏋️ Sistema Academia</h1></header>
        <nav>
            <a href="index.html">Home</a>
            <a href="AcademiaServlet?action=listarAluno">Alunos</a>
            <a href="AcademiaServlet?action=listarInstrutor">Instrutores</a>
            <a href="AcademiaServlet?action=listarPlano">Planos</a>
            <a href="AcademiaServlet?action=listarTreino" class="ativo">Treinos</a>
            <a href="AcademiaServlet?action=listarPagamento">Pagamentos</a>
            <a href="AcademiaServlet?action=verificarInadimplencia">Inadimplência</a>
        </nav>
        <div class="container"><div class="card">
                <h2>Treinos</h2>
                <a href="treino_criar.html" class="btn btn-primary" style="margin-bottom:14px">+ Novo Treino</a>
                <c:if test="${not empty msg}"><div class="${msg.startsWith('Erro') ? 'msg-err' : 'msg-ok'}">${msg}</div></c:if>
                    <table>
                        <tr><th>ID</th><th>Nome</th><th>Objetivo</th><th>Nível</th><th>Duração</th><th>Status</th><th>Ações</th></tr>
                            <c:forEach var="t" items="${treinos}">
                        <tr>
                            <td>${t.id}</td><td>${t.nomeTreino}</td><td>${t.objetivo}</td>
                            <td>${t.nivel}</td><td>${t.duracaoMinutos} min</td>
                            <td><span class="badge badge-${t.status == 'Ativo' ? 'ativo' : 'inativo'}">${t.status}</span></td>
                            <td class="acoes">
                                <a href="AcademiaServlet?action=buscarTreinoPorId&id=${t.id}" class="btn btn-warning">Editar</a>
                                <a href="treino_excluir.html?id=${t.id}" class="btn btn-danger">Excluir</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div></div>
    </body></html>
