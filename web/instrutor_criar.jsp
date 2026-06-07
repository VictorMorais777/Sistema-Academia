<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="UTF-8">
        <title>Novo Instrutor</title>
        <link rel="stylesheet" href="estilo.css">
    </head>
    <body>
        <header><h1>🏋️ Sistema Academia</h1></header>
        <nav>
            <a href="index.html">Home</a>
            <a href="AcademiaServlet?action=listarAluno">Alunos</a>
            <a href="AcademiaServlet?action=listarInstrutor" class="ativo">Instrutores</a>
            <a href="AcademiaServlet?action=listarPlano">Planos</a>
            <a href="AcademiaServlet?action=listarTreino">Treinos</a>
            <a href="AcademiaServlet?action=listarPagamento">Pagamentos</a>
            <a href="AcademiaServlet?action=verificarInadimplencia">Inadimplência</a>
        </nav>
        <div class="container">
            <div class="card">
                <h2>Cadastrar Novo Instrutor</h2>
                <c:if test="${not empty msg}">
                    <div class="msg-err">${msg}</div>
                </c:if>
                <form action="AcademiaServlet" method="post">
                    <input type="hidden" name="action" value="cadastrarInstrutor">
                    <div class="form-grid">
                        <div class="form-group"><label>Nome *</label><input type="text" name="nome" required></div>
                        <div class="form-group"><label>CPF *</label><input type="text" name="cpf" placeholder="000.000.000-00" required></div>
                        <div class="form-group"><label>Data Nascimento *</label><input type="date" name="dataNascimento" required></div>
                        <div class="form-group"><label>Telefone</label><input type="text" name="telefone"></div>
                        <div class="form-group"><label>Email *</label><input type="email" name="email" required></div>
                        <div class="form-group"><label>Especialidade</label><input type="text" name="especialidade"></div>
                        <div class="form-group"><label>CREF *</label><input type="number" name="cref" required></div>
                        <div class="form-group"><label>Salário *</label><input type="number" step="0.01" name="salario" required></div>
                        <div class="form-group"><label>Carga Horária</label><input type="number" step="0.5" name="cargaHoraria"></div>
                        <div class="form-group"><label>Status</label>
                            <select name="status"><option>Ativo</option><option>Inativo</option></select>
                        </div>
                        <div class="form-group"><label>Data Contratação *</label><input type="date" name="dataContratacao" required></div>
                    </div>
                    <div style="margin-top:16px;display:flex;gap:8px">
                        <button type="submit" class="btn btn-primary">Salvar</button>
                        <a href="AcademiaServlet?action=listarInstrutor" class="btn btn-secondary">Cancelar</a>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
