# 🏋️ Sistema de Gestão Academia

Projeto desenvolvido para a disciplina **Padrões de Projeto (PP)** — Turma 5B Eng. Software  
**Grupo G35** | João Victor · Diogo Rodrigues  
Avaliação M2 — Junho/2026

---

## 📋 Sobre o Projeto

Sistema web completo para gestão de academia, permitindo o gerenciamento de **Alunos, Instrutores, Planos, Treinos e Pagamentos**, com automação do processo de verificação de inadimplência via **Padrão Decorator**.

---

## 🏗️ Arquitetura e Design Patterns

| Pattern | Implementação |
|---|---|
| **Decorator** ⭐ | `Decorator/` — Relatório de Aluno em camadas (Treino + Pagamento + Inadimplência) |
| **Command** | `ICommand/` — 26 Actions + CommandFactory |
| **Builder** | `Builder/` — PlanoBuilder, TreinoBuilder, PagamentoBuilder |
| **Factory Method** | `Util/FabricaConexao` — Conexão MySQL centralizada |
| **DAO** | `DAO/` — 5 DAOs com CRUD completo |
| **Front Controller** | `Controller/AcademiaServlet` — Ponto único de entrada |

---

## 🔗 Relacionamentos

- **N:1** — Aluno → Plano  
- **N:1** — Aluno → Instrutor  
- **1:1** — Aluno → Treino  
- **1:N** — Aluno → Pagamento *(Foreign Key no banco)*

---

## ✅ Funcionalidades

- ✅ CRUD completo: Aluno, Instrutor, Plano, Treino, Pagamento  
- ✅ Consultar por ID (página dedicada)  
- ✅ **Automação com Decorator**: Relatório completo do aluno com análise de inadimplência, multa de 2% e histórico de pagamentos  
- ✅ Verificação em massa de inadimplência com atualização automática de status  

---

## 🔒 Segurança (Bônus)

- Headers HTTP de proteção: `X-Frame-Options`, `X-XSS-Protection`, `X-Content-Type-Options`  
- Token CSRF gerado por sessão  
- Sanitização de entradas (`ValidadorSeguranca`)  
- Validação de CPF, e-mail e campos obrigatórios  

---

## 🧪 Testes Automatizados (Bônus)

Testes JUnit localizados em `test/java/`:

| Classe de Teste | Testa |
|---|---|
| `RelatorioAlunoBaseTest` | Componente base do Decorator |
| `ComTreinoDecoratorTest` | Decorator de treino |
| `ComInadimplenciaDecoratorTest` | Decorator de inadimplência (automação) |
| `ValidadorSegurancaTest` | Sanitização e validação de entradas |
| `AlunoTest` | Model + 10 atributos obrigatórios |
| `PagamentoTest` | Model + Builder |
| `PlanoTest` | Model + Builder |

---

## 🚀 Como Executar

### Pré-requisitos
- JDK 11+
- Apache Tomcat 8.5+
- MySQL 8.x
- NetBeans IDE 12+
- `mysql-connector-java-8.x.jar`
- `jstl-1.2.jar`

### Passo a passo

```bash
# 1. Clone o repositório
git clone https://github.com/seu-usuario/academia.git

# 2. Importe o projeto no NetBeans
# File > Open Project > selecione a pasta Academia

# 3. Execute o SQL do banco
# MySQL Workbench > abrir academia_banco.sql > Execute

# 4. Adicione as bibliotecas
# Clique direito em Libraries > Add JAR/Folder
# Adicione: mysql-connector-java-8.x.jar e jstl-1.2.jar

# 5. Configure a conexão (se necessário)
# src/java/Util/FabricaConexao.java
# Ajuste USUARIO e SENHA conforme seu MySQL

# 6. Run no NetBeans
# Acesse: http://localhost:8080/Academia_/
```

---

## 📁 Estrutura do Projeto

```
src/java/
├── Controller/       → AcademiaServlet (Front Controller)
├── DAO/              → AlunoDAO, InstrutorDAO, PlanoDAO, TreinoDAO, PagamentoDAO
├── Decorator/        → RelatorioAluno, Base, Abstrato, 3 Decorators concretos
├── Builder/          → PlanoBuilder, TreinoBuilder, PagamentoBuilder
├── ICommand/         → Interface + 26 Actions + CommandFactory
├── Model/            → Aluno, Instrutor, Plano, Treino, Pagamento, Pessoa
├── Seguranca/        → FiltroSeguranca, ValidadorSeguranca
└── Util/             → FabricaConexao

web/
├── *.html            → Formulários (criar, excluir, consultar)
├── *.jsp             → Listagens e edição (com JSTL)
└── estilo.css        → Folha de estilos global

test/java/
├── Decorator/        → 3 classes de teste do Decorator
├── Model/            → 3 classes de teste dos Models
└── Seguranca/        → 1 classe de teste do ValidadorSeguranca
```

---

## 📊 Diagrama de Classes

Ver arquivo `diagrama_classes.pdf` e `diagrama_decorator.pdf` na raiz do projeto.

---

## 👥 Integrantes

| Nome | RA |
|---|---|
| João Victor | — |
| Diogo Rodrigues | — |

---

> Disciplina: Padrões de Projeto (PP) · Prof. — · 5B Eng. Software · 2026
