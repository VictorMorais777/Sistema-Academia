package Decorator;

import Model.Aluno;
import Model.Pagamento;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.ArrayList;


public class ComInadimplenciaDecoratorTest {

    private RelatorioAluno base;

    @Before
    public void setUp() {
        Aluno aluno = Aluno.criarParaTeste(1, "Carlos Teste",
                "11122233344", "Saude", "Ativo");
        base = new RelatorioAlunoBase(aluno);
    }

    @Test
    public void testAlunoEmDia_Positivo() {

        Pagamento p = Pagamento.criarParaTeste(1, 1, 149.90, 10, "Pendente", "Jun/2026");
        RelatorioAluno rel = new ComInadimplenciaDecorator(base, Arrays.asList(p));

        String resultado = rel.gerar();
        assertTrue("Aluno em dia deve aparecer no relatorio",
                resultado.contains("em dia") || resultado.contains("dia"));
    }

    @Test
    public void testAlunoInadimplente_Negativo() {

        Pagamento p = Pagamento.criarParaTeste(1, 1, 100.00, -5, "Pendente", "Mai/2026");
        RelatorioAluno rel = new ComInadimplenciaDecorator(base, Arrays.asList(p));

        String resultado = rel.gerar();


        assertTrue("Deve identificar pagamento vencido",
                resultado.contains("VENCIDO") || resultado.contains("vencido"));
    }

    @Test
    public void testMultaDoisPorCento_Positivo() {

        Pagamento p = Pagamento.criarParaTeste(1, 1, 100.00, -5, "Pendente", "Mai/2026");
        RelatorioAluno rel = new ComInadimplenciaDecorator(base, Arrays.asList(p));

        String resultado = rel.gerar();

        assertTrue("Multa de 2% sobre R$100 deve ser R$2,00",
                resultado.contains("2,00") || resultado.contains("2.00"));
    }

    @Test
    public void testSemPagamentos_Negativo() {

        RelatorioAluno rel = new ComInadimplenciaDecorator(base, new ArrayList<>());

        String resultado = rel.gerar();

        assertNotNull("Deve gerar relatorio mesmo sem pagamentos", resultado);
        assertFalse("Nao deve indicar vencidos sem pagamentos",
                resultado.contains("VENCIDO"));
    }
}
