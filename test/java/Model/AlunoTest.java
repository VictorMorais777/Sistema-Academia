package Model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class AlunoTest {

    private Aluno aluno;

    @Before
    public void setUp() {

        aluno = Aluno.criarParaTeste(1, "Joao Pereira",
                "12345678900", "Hipertrofia", "Ativo");
        aluno.setPeso(80.5);
        aluno.setAltura(1.75);
        aluno.setIdPlano(2);
        aluno.setIdInstrutor(1);
        aluno.setIdTreino(1);
    }

    @Test
    public void testGetNome_Positivo() {

        String nome = aluno.getNome();

        assertEquals("Nome deve ser Joao Pereira", "Joao Pereira", nome);
    }

    @Test
    public void testNomeIncorreto_Negativo() {

        Aluno outro = Aluno.criarParaTeste(2, "Maria", "98765432100",
                "Emagrecimento", "Ativo");


        String nome = outro.getNome();

        assertNotEquals("Nome nao deve ser Joao Pereira", "Joao Pereira", nome);
    }

    @Test
    public void testGetPeso_Positivo() {

        double peso = aluno.getPeso();

        assertEquals("Peso deve ser 80.5", 80.5, peso, 0.01);
    }

    @Test
    public void testStatusAtivo_Positivo() {

        String status = aluno.getStatus();

        assertEquals("Status deve ser Ativo", "Ativo", status);
    }

    @Test
    public void testStatusInativo_Negativo() {

        Aluno inativo = Aluno.criarParaTeste(3, "Pedro", "11100011100",
                "Saude", "Inativo");

        String status = inativo.getStatus();

        assertNotEquals("Status nao deve ser Ativo", "Ativo", status);
    }

    @Test
    public void testAlunoPossuiDezAtributos_Positivo() {

        assertNotNull(aluno.getNome());
        assertNotNull(aluno.getCpf());
        assertNotNull(aluno.getObjetivo());
        assertNotNull(aluno.getStatus());
        assertNotNull(aluno.getDataCadastro());
        assertTrue(aluno.getPeso() > 0);
        assertTrue(aluno.getAltura() > 0);
        assertTrue(aluno.getIdPlano() > 0);
        assertTrue(aluno.getIdInstrutor() > 0);
        assertTrue(aluno.getIdTreino() > 0);
    }
}
