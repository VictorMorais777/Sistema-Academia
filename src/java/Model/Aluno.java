package Model;

import java.time.LocalDate;
import java.util.List;
import javax.servlet.http.HttpServletRequest;


public class Aluno extends Pessoa {

    private double peso;
    private double altura;
    private String objetivo;
    private String status;
    private LocalDate dataCadastro;
    private int idPlano;
    private int idInstrutor;
    private int idTreino;
    private Plano plano;
    private Instrutor instrutor;
    private Treino treino;
    private List<Pagamento> pagamentos;

    public Aluno() {}

    public static Aluno fromRequest(HttpServletRequest req,
            String nome, String cpf, String telefone, String email,
            String objetivo, String status, String pesoStr, String alturaStr) {
        Aluno a = new Aluno();
        a.setNome(nome);
        a.setCpf(cpf);
        a.setDataNascimento(LocalDate.parse(req.getParameter("dataNascimento")));
        a.setTelefone(telefone);
        a.setEmail(email);
        a.setPeso(Double.parseDouble(pesoStr));
        a.setAltura(Double.parseDouble(alturaStr));
        a.setObjetivo(objetivo);
        a.setStatus(status);
        a.setDataCadastro(LocalDate.now());
        a.setIdPlano(Integer.parseInt(req.getParameter("idPlano")));
        a.setIdInstrutor(Integer.parseInt(req.getParameter("idInstrutor")));
        a.setIdTreino(Integer.parseInt(req.getParameter("idTreino")));
        return a;
    }

    public static Aluno fromRequestAtualizar(HttpServletRequest req,
            String nome, String cpf, String telefone, String email,
            String objetivo, String status, String pesoStr, String alturaStr) {
        Aluno a = fromRequest(req, nome, cpf, telefone, email, objetivo, status, pesoStr, alturaStr);
        a.setId(Integer.parseInt(req.getParameter("id")));
        a.setDataCadastro(LocalDate.parse(req.getParameter("dataCadastro")));
        return a;
    }

    public static Aluno criarParaTeste(int id, String nome, String cpf,
            String objetivo, String status) {
        Aluno a = new Aluno();
        a.setId(id);
        a.setNome(nome);
        a.setCpf(cpf);
        a.setObjetivo(objetivo);
        a.setStatus(status);
        a.setDataCadastro(java.time.LocalDate.now());
        return a;
    }

    public double getPeso() { return peso; }
    public void setPeso(double v) { this.peso = v; }

    public double getAltura() { return altura; }
    public void setAltura(double v) { this.altura = v; }

    public String getObjetivo() { return objetivo; }
    public void setObjetivo(String v) { this.objetivo = v; }

    public String getStatus() { return status; }
    public void setStatus(String v) { this.status = v; }

    public LocalDate getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDate v) { this.dataCadastro = v; }

    public int getIdPlano() { return idPlano; }
    public void setIdPlano(int v) { this.idPlano = v; }

    public int getIdInstrutor() { return idInstrutor; }
    public void setIdInstrutor(int v) { this.idInstrutor = v; }

    public int getIdTreino() { return idTreino; }
    public void setIdTreino(int v) { this.idTreino = v; }

    public Plano getPlano() { return plano; }
    public void setPlano(Plano v) { this.plano = v; }

    public Instrutor getInstrutor() { return instrutor; }
    public void setInstrutor(Instrutor v) { this.instrutor = v; }

    public Treino getTreino() { return treino; }
    public void setTreino(Treino v) { this.treino = v; }

    public List<Pagamento> getPagamentos() { return pagamentos; }
    public void setPagamentos(List<Pagamento> v) { this.pagamentos = v; }
}

