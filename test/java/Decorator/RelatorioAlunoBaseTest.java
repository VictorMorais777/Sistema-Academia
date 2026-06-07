package Decorator;

import Model.Aluno;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class RelatorioAlunoBaseTest {

    private Aluno aluno;

    @Before
    public void setUp() {

        aluno = Aluno.criarParaTeste(1, "Joao Pereira", "12345678900",
                "Hipertrofia", "Ativo");
    }

    @Test
    public void testGerarRelatorioComNome_Positivo() {

        RelatorioAluno rel = new RelatorioAlunoBase(aluno);

        String resultado = rel.gerar();

        assertTrue("Relatorio deve conter o nome do aluno",
                resultado.contains("Joao Pereira"));
    }

    @Test
    public void testGerarRelatorioSemNome_Negativo() {

        Aluno alunoSemNome = Aluno.criarParaTeste(2, "", "98765432100",
                "Emagrecimento", "Ativo");
        RelatorioAluno rel = new RelatorioAlunoBase(alunoSemNome);

        String resultado = rel.gerar();

        assertFalse("Relatorio nao deve conter nome de outro aluno",
                resultado.contains("Joao Pereira"));
    }

    @Test
    public void testGerarNaoRetornaNulo_Positivo() {

        RelatorioAluno rel = new RelatorioAlunoBase(aluno);

        String resultado = rel.gerar();

        assertNotNull("gerar() nao deve retornar null", resultado);
    }

    @Test
    public void testGerarContemCpf_Positivo() {
 
        RelatorioAluno rel = new RelatorioAlunoBase(aluno);

        String resultado = rel.gerar();

        assertTrue("Relatorio deve conter o CPF", resultado.contains("12345678900"));
    }

    @Test
    public void testGerarContemObjetivo_Positivo() {
 
        RelatorioAluno rel = new RelatorioAlunoBase(aluno);

        String resultado = rel.gerar();

        assertTrue("Relatorio deve conter o objetivo", resultado.contains("Hipertrofia"));
    }
}
