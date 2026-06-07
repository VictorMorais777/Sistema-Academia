<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="UTF-8">
        <title>Editar Plano</title>
        <link rel="stylesheet" href="estilo.css">
    </head>

    <body>

        <header>
            <h1>🏋️ Sistema Academia</h1>
        </header>

        <nav>
            <a href="index.html">Home</a>
            <a href="AcademiaServlet?action=listarPlano" class="ativo">Planos</a>
        </nav>

        <div class="container">
            <div class="card">
                <h2>Editar Plano</h2>

                <form action="AcademiaServlet" method="post">
                    <input type="hidden" name="action" value="atualizarPlano">
                    <input type="hidden" name="id" value="${plano.id}">

                    <div class="form-grid">

                        <div class="form-group">
                            <label>Nome do Plano</label>
                            <input type="text" name="nomePlano" value="${plano.nomePlano}" required>
                        </div>

                        <div class="form-group">
                            <label>Descrição</label>
                            <input type="text" name="descricao" value="${plano.descricao}">
                        </div>

                        <div class="form-group">
                            <label>Valor Mensal</label>
                            <input type="number" step="0.01" name="valorMensal" value="${plano.valorMensal}" required>
                        </div>

                        <div class="form-group">
                            <label>Duração (meses)</label>
                            <input type="number" name="duracaoMeses" value="${plano.duracaoMeses}" required>
                        </div>

                        <div class="form-group">
                            <label>Acesso Livre</label>
                            <input type="text" name="acessoLivre" value="${plano.acessoLivre}">
                        </div>

                        <div class="form-group">
                            <label>Tipo Convênio</label>
                            <input type="text" name="tipoConvenio" value="${plano.tipoConvenio}">
                        </div>

                        <div class="form-group">
                            <label>Qtd Aulas</label>
                            <input type="number" name="quantidadeAulas" value="${plano.quantidadeAulas}">
                        </div>

                        <div class="form-group">
                            <label>Tipo Plano</label>
                            <input type="text" name="tipoPlano" value="${plano.tipoPlano}">
                        </div>

                        <div class="form-group">
                            <label>Desconto</label>
                            <input type="number" step="0.01" name="desconto" value="${plano.desconto}">
                        </div>

                        <div class="form-group">
                            <label>Status</label>
                            <select name="status">
                                <option value="Ativo" ${plano.status == 'Ativo' ? 'selected' : ''}>Ativo</option>
                                <option value="Inativo" ${plano.status == 'Inativo' ? 'selected' : ''}>Inativo</option>
                            </select>
                        </div>

                    </div>

                    <div style="margin-top:16px;display:flex;gap:8px">
                        <button type="submit" class="btn btn-primary">Atualizar</button>
                        <a href="AcademiaServlet?action=listarPlano" class="btn btn-secondary">Cancelar</a>
                    </div>

                </form>
            </div>
        </div>

    </body>
</html>