package Seguranca;


public class ValidadorSeguranca {

    private static final String REGEX_EMAIL = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
    private static final String REGEX_CHARS_PERIGOSOS = "[<>\"'%;()&+]";
    private static final int CPF_TAMANHO = 11;

    private ValidadorSeguranca() {}

    public static String sanitizar(String valor) {
        if (valor == null) {
            return "";
        }
        return valor.replaceAll(REGEX_CHARS_PERIGOSOS, "").trim();
    }

    public static boolean cpfValido(String cpf) {
        if (cpf == null || cpf.isEmpty()) {
            return false;
        }
        return cpf.replaceAll("[^0-9]", "").length() == CPF_TAMANHO;
    }

    public static boolean emailValido(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return email.matches(REGEX_EMAIL);
    }

    public static boolean campoObrigatorio(String valor) {
        return valor != null && !valor.trim().isEmpty();
    }

    public static boolean numeroPositivo(String valor) {
        if (valor == null || valor.trim().isEmpty()) {
            return false;
        }
        try {
            return Double.parseDouble(valor.trim()) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
