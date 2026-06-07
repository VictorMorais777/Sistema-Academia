package Decorator;

import Model.Aluno;
import Model.Treino;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ComTreinoDecoratorTest {

    private RelatorioAluno base;
    private Treino treino;

    @Before
    public void setUp() {

        Aluno aluno = Aluno.criarParaTeste(1, "Maria Oliveira",
                "98765432100", "Emagrecimento", "Ativo");
        base = new RelatorioAlunoBase(aluno);
        treino = Treino.criarParaTeste(1, "Treino Cardio",
                "Emagrecimento", "Iniciante", 40, 5);
    }

    @Test
    public void testDecoratorAdicionaTreino_Positivo() {

        RelatorioAluno rel = new ComTreinoDecorator(base, treino);

        String resultado = rel.gerar();

        assertTrue("Relatorio deve conter secao de treino",
                resultado.contains("TREINO"));
    }

    @Test
    public void testDecoratorSemTreino_Negativo() {
        RelatorioAluno rel = new ComTreinoDecorator(base, null);

        String resultado = rel.gerar();

        assertFalse("Sem treino nao deve mostrar nome do treino",
                resultado.contains("Treino Cardio"));
    }

    @Test
    public void testDecoratorMantemDadosBase_Positivo() {

        RelatorioAluno rel = new ComTreinoDecorator(base, treino);

        String resultado = rel.gerar();

        assertTrue("Decorator deve manter dados do aluno",
                resultado.contains("Maria Oliveira"));
    }

    @Test
    public void testDecoratorContemNivelTreino_Positivo() {

        RelatorioAluno rel = new ComTreinoDecorator(base, treino);

        String resultado = rel.gerar();

        assertTrue("Relatorio deve conter nivel do treino",
                resultado.contains("Iniciante"));
    }
}
