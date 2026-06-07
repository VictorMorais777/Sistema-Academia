package Decorator;

import Model.Treino;


public class ComTreinoDecorator extends RelatorioDecorator {

    private final Treino treino;

    public ComTreinoDecorator(RelatorioAluno relatorio, Treino treino) {
        super(relatorio);
        this.treino = treino;
    }

    @Override
    public String gerar() {
        StringBuilder sb = new StringBuilder(super.gerar());
        //StringBuilder sb = new StringBuilder(relatorio.gerar());
        sb.append("\n\n--- TREINO ATUAL ---");

        if (treino == null) {
            sb.append("\nNenhum treino vinculado.");
        } else {
            sb.append("\nNome: ").append(treino.getNomeTreino())
              .append("\nObjetivo: ").append(treino.getObjetivo())
              .append("\nNivel: ").append(treino.getNivel())
              .append("\nDuracao: ").append(treino.getDuracaoMinutos()).append(" minutos")
              .append("\nExercicios: ").append(treino.getQuantidadeExercicios())
              .append("\nDescricao: ").append(treino.getDescricao());
        }
        return sb.toString();
    }
}
