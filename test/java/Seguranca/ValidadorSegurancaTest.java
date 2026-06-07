package Seguranca;

import org.junit.Test;
import static org.junit.Assert.*;

public class ValidadorSegurancaTest {

    @Test
    public void testCpfOnzeDigitos_Positivo() {

        String cpf = "12345678900";

        boolean resultado = ValidadorSeguranca.cpfValido(cpf);

        assertTrue("CPF com 11 digitos deve ser valido", resultado);
    }

    @Test
    public void testCpfMenosDigitos_Negativo() {

        String cpf = "1234567";

        boolean resultado = ValidadorSeguranca.cpfValido(cpf);

        assertFalse("CPF com menos de 11 digitos deve ser invalido", resultado);
    }

    @Test
    public void testCpfNulo_Negativo() {

        String cpf = null;

        boolean resultado = ValidadorSeguranca.cpfValido(cpf);

        assertFalse("CPF nulo deve ser invalido", resultado);
    }

    @Test
    public void testEmailFormatoValido_Positivo() {
    
        String email = "aluno@academia.com";

        boolean resultado = ValidadorSeguranca.emailValido(email);

        assertTrue("Email valido deve passar", resultado);
    }

    @Test
    public void testEmailSemArroba_Negativo() {

        String email = "alunoAcademia.com";

        boolean resultado = ValidadorSeguranca.emailValido(email);

        assertFalse("Email sem @ deve ser invalido", resultado);
    }

    @Test
    public void testEmailNulo_Negativo() {

        String email = null;

        boolean resultado = ValidadorSeguranca.emailValido(email);

        assertFalse("Email nulo deve ser invalido", resultado);
    }



    @Test
    public void testSanitizarRemoveScript_Positivo() {

        String entrada = "<script>alert(1)</script>";

     
        String resultado = ValidadorSeguranca.sanitizar(entrada);

        assertFalse("Deve remover caracteres perigosos",
                resultado.contains("<") || resultado.contains(">"));
    }

    @Test
    public void testSanitizarTextoNormal_Positivo() {
        String entrada = "Joao Silva";

   
        String resultado = ValidadorSeguranca.sanitizar(entrada);

      
        assertEquals("Texto normal nao deve ser alterado", "Joao Silva", resultado);
    }

    @Test
    public void testSanitizarNulo_Negativo() {
    
        String entrada = null;

      
        String resultado = ValidadorSeguranca.sanitizar(entrada);


        assertEquals("Nulo deve retornar string vazia", "", resultado);
    }

   

    @Test
    public void testNumeroPositivo_Positivo() {
        
        String valor = "149.90";

        boolean resultado = ValidadorSeguranca.numeroPositivo(valor);

   
        assertTrue("Numero positivo deve ser valido", resultado);
    }

    @Test
    public void testNumeroNegativo_Negativo() {
        
        String valor = "-50";

        boolean resultado = ValidadorSeguranca.numeroPositivo(valor);

        assertFalse("Numero negativo deve ser invalido", resultado);
    }

    @Test
    public void testTextoNaoNumerico_Negativo() {
    
        String valor = "abc";

        boolean resultado = ValidadorSeguranca.numeroPositivo(valor);

        assertFalse("Texto nao numerico deve ser invalido", resultado);
    }
}
