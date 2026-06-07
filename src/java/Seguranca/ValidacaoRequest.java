package Seguranca;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;

public class ValidacaoRequest {

    private final Map<Boolean, String> regras = new LinkedHashMap<>();

    public ValidacaoRequest regra(boolean valido, String msgErro) {
        if (!valido) {
            regras.put(false, msgErro);
        }
        return this;
    }

    public String validar() {
        return regras.values().stream().findFirst().orElse(null);
    }

    public boolean temErro() {
        return !regras.isEmpty();
    }
}
