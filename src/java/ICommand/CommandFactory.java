package ICommand;


public class CommandFactory {

    public static ICommand getCommand(String action) {
        if (action == null || action.isEmpty()) {
            return null;
        }
        switch (action) {
   
            case "cadastrarAluno":
                return new CadastrarAlunoAction();
            case "listarAluno":
                return new ListarAlunoAction();
            case "buscarAlunoPorId":
                return new BuscarAlunoPorIdAction();
            case "buscarAlunoPorCpf":
                return new BuscarAlunoPorCpfAction();
            case "atualizarAluno":
                return new AtualizarAlunoAction();
            case "excluirAluno":
                return new ExcluirAlunoAction();
         
            case "cadastrarInstrutor":
                return new CadastrarInstrutorAction();
            case "listarInstrutor":
                return new ListarInstrutorAction();
            case "buscarInstrutorPorId":
                return new BuscarInstrutorPorIdAction();
            case "atualizarInstrutor":
                return new AtualizarInstrutorAction();
            case "excluirInstrutor":
                return new ExcluirInstrutorAction();
  
            case "cadastrarPlano":
                return new CadastrarPlanoAction();
            case "listarPlano":
                return new ListarPlanoAction();
            case "buscarPlanoPorId":
                return new BuscarPlanoPorIdAction();
            case "atualizarPlano":
                return new AtualizarPlanoAction();
            case "excluirPlano":
                return new ExcluirPlanoAction();
            
            case "cadastrarTreino":
                return new CadastrarTreinoAction();
            case "listarTreino":
                return new ListarTreinoAction();
            case "buscarTreinoPorId":
                return new BuscarTreinoPorIdAction();
            case "atualizarTreino":
                return new AtualizarTreinoAction();
            case "excluirTreino":
                return new ExcluirTreinoAction();
            
            case "cadastrarPagamento":
                return new CadastrarPagamentoAction();
            case "listarPagamento":
                return new ListarPagamentoAction();
            case "buscarPagamentoPorId":
                return new BuscarPagamentoPorIdAction();
            case "atualizarPagamento":
                return new AtualizarPagamentoAction();
            case "excluirPagamento":
                return new ExcluirPagamentoAction();
           
            case "gerarRelatorio":
                return new GerarRelatorioAlunoAction();
           
            case "verificarInadimplencia":
                return new VerificarInadimplenciaAction();
            default:
                return null;
        }
    }
}
