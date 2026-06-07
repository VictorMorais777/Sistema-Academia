<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html><html lang="pt-BR"><head><meta charset="UTF-8"><title>Editar Treino</title>
        <link rel="stylesheet" href="estilo.css"></head>
    <body>
        <header><h1>🏋️ Sistema Academia</h1></header>
        <nav><a href="index.html">Home</a><a href="AcademiaServlet?action=listarTreino" class="ativo">Treinos</a></nav>
        <div class="container"><div class="card">
                <h2>Editar Treino</h2>
                <form action="AcademiaServlet" method="post">
                    <input type="hidden" name="action" value="atualizarTreino">
                    <input type="hidden" name="id" value="${treino.id}">
                    <input type="hidden" name="dataCriacao" value="${treino.dataCriacao}">
                    <div class="form-grid">
                        <div class="form-group"><label>Nome</label><input type="text" name="nomeTreino" value="${treino.nomeTreino}" required></div>
                        <div class="form-group"><label>Objetivo</label><input type="text" name="objetivo" value="${treino.objetivo}"></div>
                        <div class="form-group"><label>Nível</label><input type="text" name="nivel" value="${treino.nivel}"></div>
                        <div class="form-group"><label>Duração (min)</label><input type="number" name="duracaoMinutos" value="${treino.duracaoMinutos}"></div>
                        <div class="form-group"><label>Qtd Exercícios</label><input type="number" name="quantidadeExercicios" value="${treino.quantidadeExercicios}"></div>
                        <div class="form-group"><label>Descrição</label><input type="text" name="descricao" value="${treino.descricao}"></div>
                        <div class="form-group"><label>Observações</label><input type="text" name="observacoes" value="${treino.observacoes}"></div>
                        <div class="form-group"><label>Status</label>
                            <select name="status">
                                <option <c:if test="${treino.status == 'Ativo'}">selected</c:if>>Ativo</option>
                                <option <c:if test="${treino.status == 'Inativo'}">selected</c:if>>Inativo</option>
                            </select>
                        </div>
                    </div>
                    <div style="margin-top:16px;display:flex;gap:8px">
                        <button type="submit" class="btn btn-primary">Atualizar</button>
                        <a href="AcademiaServlet?action=listarTreino" class="btn btn-secondary">Cancelar</a>
                    </div>
                </form>
            </div></div>
    </body></html>
