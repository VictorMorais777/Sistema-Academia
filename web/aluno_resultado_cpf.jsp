<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="UTF-8">
        <title>Resultado CPF</title>
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

            <c:if test="${not empty msg}">
                <div class="msg-err">${msg}</div>
            </c:if>

            <c:if test="${not empty aluno}">

 
                <div class="card">
                    <h2>👤 Ficha do Aluno — CPF ${aluno.cpf}</h2>
                    <table>
                        <tr><th colspan="4" style="text-align:center;background:#16213e">Dados Pessoais</th></tr>
                        <tr>
                            <td><strong>ID</strong></td><td>${aluno.id}</td>
                            <td><strong>Nome</strong></td><td>${aluno.nome}</td>
                        </tr>
                        <tr>
                            <td><strong>CPF</strong></td><td>${aluno.cpf}</td>
                            <td><strong>Nascimento</strong></td><td>${aluno.dataNascimento}</td>
                        </tr>
                        <tr>
                            <td><strong>Telefone</strong></td><td>${aluno.telefone}</td>
                            <td><strong>Email</strong></td><td>${aluno.email}</td>
                        </tr>
                        <tr>
                            <td><strong>Peso</strong></td><td>${aluno.peso} kg</td>
                            <td><strong>Altura</strong></td><td>${aluno.altura} m</td>
                        </tr>
                        <tr>
                            <td><strong>Objetivo</strong></td><td>${aluno.objetivo}</td>
                            <td><strong>Status</strong></td>
                            <td>
                                <span class="badge badge-${aluno.status == 'Ativo' ? 'ativo' : 'inativo'}">${aluno.status}</span>
                            </td>
                        </tr>
                        <tr>
                            <td><strong>Cadastro</strong></td><td>${aluno.dataCadastro}</td>
                            <td></td><td></td>
                        </tr>
                    </table>
                </div>

         
                <div class="card">
                    <h2>📋 Plano / Instrutor / Treino</h2>
                    <table>
                        <tr>
                            <th>Plano</th>
                            <th>Valor Mensal</th>
                            <th>Instrutor</th>
                            <th>Especialidade</th>
                            <th>Treino</th>
                            <th>Nível</th>
                        </tr>
                        <tr>
                            <td><c:out value="${aluno.plano.nomePlano}" default="—"/></td>
                            <td>
                                <c:if test="${not empty aluno.plano}">R$ ${aluno.plano.valorMensal}</c:if>
                                <c:if test="${empty aluno.plano}">—</c:if>
                                </td>
                                <td><c:out value="${aluno.instrutor.nome}" default="—"/></td>
                            <td><c:out value="${aluno.instrutor.especialidade}" default="—"/></td>
                            <td><c:out value="${aluno.treino.nomeTreino}" default="—"/></td>
                            <td><c:out value="${aluno.treino.nivel}" default="—"/></td>
                        </tr>
                    </table>
                </div>

                <div class="card">
                    <h2>💰 Histórico de Pagamentos</h2>
                    <c:choose>
                        <c:when test="${empty aluno.pagamentos}">
                            <p style="color:#888">Nenhum pagamento registrado.</p>
                        </c:when>
                        <c:otherwise>
                            <table>
                                <tr>
                                    <th>ID</th>
                                    <th>Valor</th>
                                    <th>Vencimento</th>
                                    <th>Pagamento</th>
                                    <th>Forma</th>
                                    <th>Multa</th>
                                    <th>Status</th>
                                    <th>Referência</th>
                                </tr>
                                <c:forEach var="pg" items="${aluno.pagamentos}">
                                    <tr>
                                        <td>${pg.id}</td>
                                        <td>R$ ${pg.valor}</td>
                                        <td>${pg.dataVencimento}</td>
                                        <td>${not empty pg.dataPagamento ? pg.dataPagamento : '—'}</td>
                                        <td>${pg.formaPagamento}</td>
                                        <td>R$ ${pg.multa}</td>
                                        <td>
                                            <span class="badge badge-${pg.status == 'Pago' ? 'ativo' : (pg.status == 'Inadimplente' ? 'inadimplente' : 'inativo')}">
                                                ${pg.status}
                                            </span>
                                        </td>
                                        <td>${pg.referencia}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </c:otherwise>
                    </c:choose>
                </div>

             
                <div style="display:flex;gap:10px;margin-bottom:24px">
                    <a href="AcademiaServlet?action=buscarAlunoPorId&id=${aluno.id}" class="btn btn-warning">✏️ Editar Aluno</a>
                    <a href="AcademiaServlet?action=listarAluno" class="btn btn-secondary">← Voltar para Lista</a>
                </div>

            </c:if>

        </div>
    </body>
</html>
