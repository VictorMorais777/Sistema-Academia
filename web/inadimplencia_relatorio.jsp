<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-BR">
    <head><meta charset="UTF-8"><title>Relatório de Inadimplência</title><link rel="stylesheet" href="estilo.css"></head>
    <body>
        <header><h1>🏋️ Sistema Academia</h1></header>
        <nav>
            <a href="index.html">Home</a>
            <a href="AcademiaServlet?action=listarAluno">Alunos</a>
            <a href="AcademiaServlet?action=listarPagamento">Pagamentos</a>
            <a href="AcademiaServlet?action=verificarInadimplencia" class="ativo">Inadimplência</a>
        </nav>
        <div class="container"><div class="card">
                <h2>⚠️ Relatório de Inadimplência</h2>
                <c:if test="${not empty msg}"><div class="${msg.startsWith('Erro') ? 'msg-err' : 'msg-ok'}">${msg}</div></c:if>
                    <p style="margin-bottom:14px;color:#555">Pagamentos vencidos com multa de 2% aplicada automaticamente.</p>
                    <table>
                        <tr>
                            <th>ID Pag.</th>
                            <th>Aluno</th>
                            <th>Valor</th>
                            <th>Vencimento</th>
                            <th>Multa (2%)</th>
                            <th>Status</th>
                            <th>Referência</th>
                        </tr>
                    <c:forEach var="p" items="${inadimplentes}">
                        <tr>
                            <td>${p.id}</td>
                            <td>${p.nomeAluno}</td>
                            <td>R$ ${p.valor}</td>
                            <td>${p.dataVencimento}</td>
                            <td>R$ ${p.multa}</td>
                            <td><span class="badge badge-inadimplente">${p.status}</span></td>
                            <td>${p.referencia}</td>
                        </tr>
                    </c:forEach>
                </table>
                <div style="margin-top:16px">
                    <a href="AcademiaServlet?action=verificarInadimplencia" class="btn btn-danger">Atualizar Verificação</a>
                    <a href="index.html" class="btn btn-secondary" style="margin-left:8px">Voltar</a>
                </div>
            </div></div>
    </body></html>
