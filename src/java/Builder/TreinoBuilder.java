package Builder;

import Model.Treino;
import java.time.LocalDate;

public class TreinoBuilder {

    private Treino treino;

    public TreinoBuilder() {
        this.treino = new Treino();
    }

    public TreinoBuilder comId(int v) { treino.setId(v); return this; }
    public TreinoBuilder comNomeTreino(String v) { treino.setNomeTreino(v); return this; }
    public TreinoBuilder comObjetivo(String v) { treino.setObjetivo(v); return this; }
    public TreinoBuilder comNivel(String v) { treino.setNivel(v); return this; }
    public TreinoBuilder comDuracaoMinutos(int v) { treino.setDuracaoMinutos(v); return this; }
    public TreinoBuilder comQuantidadeExercicios(int v) { treino.setQuantidadeExercicios(v); return this; }
    public TreinoBuilder comDescricao(String v) { treino.setDescricao(v); return this; }
    public TreinoBuilder comDataCriacao(LocalDate v) { treino.setDataCriacao(v); return this; }
    public TreinoBuilder comObservacoes(String v) { treino.setObservacoes(v); return this; }
    public TreinoBuilder comStatus(String v) { treino.setStatus(v); return this; }

    public Treino constroi() { return treino; }
}
