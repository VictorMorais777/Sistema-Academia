package Decorator;

import Model.Aluno;


public class RelatorioAlunoBase implements RelatorioAluno {

    private final Aluno aluno;

    public RelatorioAlunoBase(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public String gerar() {
        return "=== RELATORIO DO ALUNO ===" +
               "\nID: " + aluno.getId() +
               "\nNome: " + aluno.getNome() +
               "\nCPF: " + aluno.getCpf() +
               "\nObjetivo: " + aluno.getObjetivo() +
               "\nStatus: " + aluno.getStatus() +
               "\nCadastro: " + aluno.getDataCadastro();
    }
}
