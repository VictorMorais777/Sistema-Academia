<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html><html lang="pt-BR"><head><meta charset="UTF-8"><title>Planos</title>
        <link rel="stylesheet" href="estilo.css"></head>
    <body>
        <header><h1>🏋️ Sistema Academia</h1></header>
        <nav>
            <a href="index.html">Home</a>
            <a href="AcademiaServlet?action=listarAluno">Alunos</a>
            <a href="AcademiaServlet?action=listarInstrutor">Instrutores</a>
            <a href="AcademiaServlet?action=listarPlano" class="ativo">Planos</a>
            <a href="AcademiaServlet?action=listarTreino">Treinos</a>
            <a href="AcademiaServlet?action=listarPagamento">Pagamentos</a>
            <a href="AcademiaServlet?action=verificarInadimplencia">Inadimplência</a>
        </nav>
        <div class="container"><div class="card">
                <h2>Planos</h2>
                <a href="plano_criar.html" class="btn btn-primary" style="margin-bottom:14px">+ Novo Plano</a>
                <c:if test="${not empty msg}"><div class="${msg.startsWith('Erro') ? 'msg-err' : 'msg-ok'}">${msg}</div></c:if>
                    <table>
                        <tr><th>ID</th><th>Nome</th><th>Valor Mensal</th><th>Duração</th><th>Tipo</th><th>Status</th><th>Ações</th></tr>
                            <c:forEach var="p" items="${planos}">
                        <tr>
                            <td>${p.id}</td><td>${p.nomePlano}</td>
                            <td>R$ ${p.valorMensal}</td><td>${p.duracaoMeses} meses</td>
                            <td>${p.tipoPlano}</td>
                            <td><span class="badge badge-${p.status == 'Ativo' ? 'ativo' : 'inativo'}">${p.status}</span></td>
                            <td class="acoes">
                                <a href="AcademiaServlet?action=buscarPlanoPorId&id=${p.id}" class="btn btn-warning">Editar</a>
                                <a href="plano_excluir.html?id=${p.id}" class="btn btn-danger">Excluir</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div></div>
    </body></html>
