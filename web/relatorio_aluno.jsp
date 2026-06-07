<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Relatorio do Aluno</title>
    <link rel="stylesheet" href="estilo.css">
    <style>
        .opcoes-box { background:#f8f9fa; border:1px solid #ddd; border-radius:8px; padding:20px; margin-bottom:20px; }
        .opcoes-box h3 { margin-bottom:14px; color:#1a1a2e; font-size:15px; }
        .checkbox-group { display:flex; flex-wrap:wrap; gap:14px; }
        .checkbox-item { display:flex; align-items:center; gap:8px; font-size:14px; cursor:pointer; }
        .checkbox-item input { width:16px; height:16px; cursor:pointer; }
        .relatorio-box { background:#1a1a2e; color:#a0f0a0; font-family:'Courier New',monospace;
                         font-size:13px; padding:24px; border-radius:8px; white-space:pre-wrap; line-height:1.8; }
        .relatorio-vazio { color:#888; text-align:center; padding:40px; font-style:italic; }
    </style>
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
</nav>
<div class="container">
    <div class="card">
        <h2>Relatorio do Aluno — ${aluno.nome}</h2>
        <p style="color:#555;margin-bottom:16px">
            Selecione as informacoes que deseja incluir no relatorio:
        </p>

        <form action="AcademiaServlet" method="post">
            <input type="hidden" name="action" value="gerarRelatorio">
            <input type="hidden" name="id" value="${aluno.id}">

            <div class="opcoes-box">
                <h3>O que deseja incluir no relatorio?</h3>
                <div class="checkbox-group">
                    <label class="checkbox-item">
                        <input type="checkbox" name="dadosAluno" value="sim"
                            ${param.dadosAluno == 'sim' || relatorio == null ? 'checked' : ''}>
                        Dados do Aluno
                    </label>
                    <label class="checkbox-item">
                        <input type="checkbox" name="treino" value="sim"
                            ${param.treino == 'sim' ? 'checked' : ''}>
                        Treino Atual
                    </label>
                    <label class="checkbox-item">
                        <input type="checkbox" name="pagamentos" value="sim"
                            ${param.pagamentos == 'sim' ? 'checked' : ''}>
                        Historico de Pagamentos
                    </label>
                    <label class="checkbox-item">
                        <input type="checkbox" name="inadimplencia" value="sim"
                            ${param.inadimplencia == 'sim' ? 'checked' : ''}>
                        Analise de Inadimplencia
                    </label>
                </div>
            </div>

            <div style="display:flex;gap:8px;margin-bottom:16px">
                <button type="submit" class="btn btn-primary">Gerar Relatorio</button>
                <a href="AcademiaServlet?action=listarAluno" class="btn btn-secondary">Voltar</a>
            </div>
        </form>

        <c:if test="${not empty relatorio}">
            <div class="relatorio-box">${relatorio}</div>
        </c:if>
        <c:if test="${empty relatorio && not empty aluno}">
            <div class="relatorio-box relatorio-vazio">
                Selecione pelo menos uma opcao e clique em "Gerar Relatorio".
            </div>
        </c:if>
    </div>
</div>
</body>
</html>
