<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="UTF-8">
        <title>Editar Aluno</title>
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
                <h2>Editar Aluno</h2>

                <c:if test="${not empty msg}">
                    <div class="${msg.startsWith('Erro') ? 'msg-err' : 'msg-ok'}">${msg}</div>
                </c:if>

                <form action="AcademiaServlet" method="post">
                    <input type="hidden" name="action" value="atualizarAluno">
                    <input type="hidden" name="id" value="${aluno.id}">
                    <input type="hidden" name="dataCadastro" value="${aluno.dataCadastro}">

                    <div class="form-grid">
                        <div class="form-group">
                            <label>Nome *</label>
                            <input type="text" name="nome" value="${aluno.nome}" required>
                        </div>
                        <div class="form-group">
                            <label>CPF *</label>
                            <input type="text" name="cpf" value="${aluno.cpf}" required>
                        </div>
                        <div class="form-group">
                            <label>Data Nascimento *</label>
                            <input type="date" name="dataNascimento" value="${aluno.dataNascimento}" required>
                        </div>
                        <div class="form-group">
                            <label>Telefone</label>
                            <input type="text" name="telefone" value="${aluno.telefone}">
                        </div>
                        <div class="form-group">
                            <label>Email</label>
                            <input type="email" name="email" value="${aluno.email}">
                        </div>
                        <div class="form-group">
                            <label>Peso (kg) *</label>
                            <input type="number" step="0.1" name="peso" value="${aluno.peso}" required>
                        </div>
                        <div class="form-group">
                            <label>Altura (m) *</label>
                            <input type="number" step="0.01" name="altura" value="${aluno.altura}" required>
                        </div>
                        <div class="form-group">
                            <label>Objetivo</label>
                            <select name="objetivo">
                                <option <c:if test="${aluno.objetivo == 'Hipertrofia'}">selected</c:if>>Hipertrofia</option>
                                <option <c:if test="${aluno.objetivo == 'Emagrecimento'}">selected</c:if>>Emagrecimento</option>
                                <option <c:if test="${aluno.objetivo == 'Condicionamento'}">selected</c:if>>Condicionamento</option>
                                <option <c:if test="${aluno.objetivo == 'Saude'}">selected</c:if>>Saude</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Status</label>
                                <select name="status">
                                    <option <c:if test="${aluno.status == 'Ativo'}">selected</c:if>>Ativo</option>
                                <option <c:if test="${aluno.status == 'Inativo'}">selected</c:if>>Inativo</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>ID Plano *</label>
                                <input type="number" name="idPlano" value="${aluno.idPlano}" required>
                        </div>
                        <div class="form-group">
                            <label>ID Instrutor *</label>
                            <input type="number" name="idInstrutor" value="${aluno.idInstrutor}" required>
                        </div>
                        <div class="form-group">
                            <label>ID Treino *</label>
                            <input type="number" name="idTreino" value="${aluno.idTreino}" required>
                        </div>
                    </div>

                    <div style="margin-top:16px;display:flex;gap:8px">
                        <button type="submit" class="btn btn-primary">Atualizar</button>
                        <a href="AcademiaServlet?action=listarAluno" class="btn btn-secondary">Cancelar</a>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
