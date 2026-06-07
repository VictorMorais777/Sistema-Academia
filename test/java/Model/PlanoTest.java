package Model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class PlanoTest {

    private Plano plano;

    @Before
    public void setUp() {

        plano = Plano.getBuilder()
                .comId(1)
                .comNomePlano("Premium")
                .comDescricao("Acesso completo")
                .comValorMensal(149.90)
                .comDuracaoMeses(1)
                .comAcessoLivre("Sim")
                .comTipoConvenio("Nenhum")
                .comQuantidadeAulas(8)
                .comTipoPlano("Mensal")
                .comDesconto(10.0)
                .comStatus("Ativo")
                .constroi();
    }

    @Test
    public void testBuilderNomePlano_Positivo() {

        String nome = plano.getNomePlano();

        assertEquals("Nome deve ser Premium", "Premium", nome);
    }

    @Test
    public void testNomePlanoIncorreto_Negativo() {

        String nome = plano.getNomePlano();

        assertNotEquals("Nome nao deve ser Basico", "Basico", nome);
    }

    @Test
    public void testValorMensal_Positivo() {

        double valor = plano.getValorMensal();

        assertEquals("Valor deve ser 149.90", 149.90, valor, 0.01);
    }

    @Test
    public void testStatusAtivo_Positivo() {

        String status = plano.getStatus();

        assertEquals("Status deve ser Ativo", "Ativo", status);
    }

    @Test
    public void testDescontoNegativo_Negativo() {

        Plano planoSemDesconto = Plano.getBuilder()
                .comNomePlano("Basico").comValorMensal(89.90)
                .comDuracaoMeses(1).comDesconto(0.0).comStatus("Ativo")
                .constroi();

        double desconto = planoSemDesconto.getDesconto();

        assertEquals("Plano basico nao tem desconto", 0.0, desconto, 0.01);
    }
}
