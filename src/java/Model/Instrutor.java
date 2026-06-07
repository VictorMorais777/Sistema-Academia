package Model;

import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;


public class Instrutor extends Pessoa {

    private String especialidade;
    private int cref;
    private double salario;
    private double cargaHoraria;
    private String status;
    private LocalDate dataContratacao;

    public Instrutor() {}


    public static Instrutor fromRequest(HttpServletRequest req,
            String nome, String cpf, String email) {
        Instrutor i = new Instrutor();
        i.setNome(nome);
        i.setCpf(cpf);
        i.setDataNascimento(LocalDate.parse(req.getParameter("dataNascimento")));
        i.setTelefone(req.getParameter("telefone"));
        i.setEmail(email);
        i.setEspecialidade(req.getParameter("especialidade"));
        i.setCref(Integer.parseInt(req.getParameter("cref")));
        i.setSalario(Double.parseDouble(req.getParameter("salario")));
        String carga = req.getParameter("cargaHoraria");
        i.setCargaHoraria(carga != null && !carga.isEmpty() ? Double.parseDouble(carga) : 0.0);
        i.setStatus(req.getParameter("status"));
        i.setDataContratacao(LocalDate.parse(req.getParameter("dataContratacao")));
        return i;
    }


    public static Instrutor fromRequestAtualizar(HttpServletRequest req,
            String nome, String cpf, String email) {
        Instrutor i = fromRequest(req, nome, cpf, email);
        i.setId(Integer.parseInt(req.getParameter("id")));
        return i;
    }

    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String v) { this.especialidade = v; }

    public int getCref() { return cref; }
    public void setCref(int v) { this.cref = v; }

    public double getSalario() { return salario; }
    public void setSalario(double v) { this.salario = v; }

    public double getCargaHoraria() { return cargaHoraria; }
    public void setCargaHoraria(double v) { this.cargaHoraria = v; }

    public String getStatus() { return status; }
    public void setStatus(String v) { this.status = v; }

    public LocalDate getDataContratacao() { return dataContratacao; }
    public void setDataContratacao(LocalDate v) { this.dataContratacao = v; }
}
