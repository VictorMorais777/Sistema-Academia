package Model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PagamentoTest {

    private Pagamento pagamento;

    @Before
    public void setUp() {
        pagamento = Pagamento.criarParaTeste(1, 1, 149.90, -90, "Pendente", "Fev/2025");
        pagamento.setFormaPagamento("PIX");
        pagamento.setMulta(0.0);
        pagamento.setDesconto(0.0);
    }

    @Test
    public void testGetValor() {
        assertEquals(149.90, pagamento.getValor(), 0.01);
    }

    @Test
    public void testGetStatus() {
        assertEquals("Pendente", pagamento.getStatus());
    }

    @Test
    public void testGetFormaPagamento() {
        assertEquals("PIX", pagamento.getFormaPagamento());
    }

    @Test
    public void testGetIdAluno() {
        assertEquals(1, pagamento.getIdAluno());
    }

    @Test
    public void testVencimentoPassado() {
        assertTrue("Vencimento deve ser no passado",
                pagamento.getDataVencimento().isBefore(pagamento.getDataVencimento().plusDays(1)));
    }

    @Test
    public void testMultaZero() {
        assertEquals(0.0, pagamento.getMulta(), 0.01);
    }

    @Test
    public void testBuilder() {
        Pagamento p = Pagamento.getBuilder()
                .comId(99)
                .comIdAluno(2)
                .comValor(200.0)
                .comDataVencimento(pagamento.getDataVencimento())
                .comFormaPagamento("Cartao")
                .comStatus("Pago")
                .comMulta(0.0)
                .comDesconto(10.0)
                .comReferencia("Mar/2025")
                .constroi();

        assertEquals(99, p.getId());
        assertEquals(200.0, p.getValor(), 0.01);
        assertEquals("Pago", p.getStatus());
        assertEquals(10.0, p.getDesconto(), 0.01);
    }
}
