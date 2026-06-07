<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-BR">
    <head><meta charset="UTF-8"><title>Pagamentos</title><link rel="stylesheet" href="estilo.css"></head>
    <body>
        <header><h1>🏋️ Sistema Academia</h1></header>
        <nav>
            <a href="index.html">Home</a>
            <a href="AcademiaServlet?action=listarAluno">Alunos</a>
            <a href="AcademiaServlet?action=listarInstrutor">Instrutores</a>
            <a href="AcademiaServlet?action=listarPlano">Planos</a>
            <a href="AcademiaServlet?action=listarTreino">Treinos</a>
            <a href="AcademiaServlet?action=listarPagamento" class="ativo">Pagamentos</a>
            <a href="AcademiaServlet?action=verificarInadimplencia">Inadimplência</a>
        </nav>
        <div class="container"><div class="card">
                <h2>Pagamentos</h2>
                <a href="pagamento_criar.html" class="btn btn-primary" style="margin-bottom:14px">+ Novo Pagamento</a>
                <c:if test="${not empty msg}"><div class="${msg.startsWith('Erro') ? 'msg-err' : 'msg-ok'}">${msg}</div></c:if>
                    <table>
                        <tr>
                            <th>ID</th>
                            <th>Aluno</th>
                            <th>Valor</th>
                            <th>Vencimento</th>
                            <th>Forma</th>
                            <th>Status</th>
                            <th>Referência</th>
                            <th>Ações</th>
                        </tr>
                    <c:forEach var="p" items="${pagamentos}">
                        <tr>
                            <td>${p.id}</td>
                            <td>${p.nomeAluno}</td>
                            <td>R$ ${p.valor}</td>
                            <td>${p.dataVencimento}</td>
                            <td>${p.formaPagamento}</td>
                            <td><span class="badge badge-${p.status == 'Pago' ? 'ativo' : (p.status == 'Inadimplente' ? 'inadimplente' : 'inativo')}">${p.status}</span></td>
                            <td>${p.referencia}</td>
                            <td class="acoes">
                                <a href="AcademiaServlet?action=buscarPagamentoPorId&id=${p.id}" class="btn btn-warning">Editar</a>
                                <a href="pagamento_excluir.html?id=${p.id}" class="btn btn-danger">Excluir</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div></div>
    </body></html>
