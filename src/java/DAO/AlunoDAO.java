package DAO;

import java.sql.*;
import java.util.*;
import java.sql.Date;
import Util.FabricaConexao;
import Model.Aluno;

public class AlunoDAO {

    private Connection cx() throws Exception {
        return FabricaConexao.getConexaoMySQL();
    }

    public void cadastrar(Aluno a) throws Exception {
        String sql = "INSERT INTO aluno(nome,cpf,dataNascimento,telefone,email,peso,altura,objetivo,status,dataCadastro,idPlano,idInstrutor,idTreino) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection c = cx(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, a.getNome());
            ps.setString(2, a.getCpf());
            ps.setDate(3, Date.valueOf(a.getDataNascimento()));
            ps.setString(4, a.getTelefone());
            ps.setString(5, a.getEmail());
            ps.setDouble(6, a.getPeso());
            ps.setDouble(7, a.getAltura());
            ps.setString(8, a.getObjetivo());
            ps.setString(9, a.getStatus());
            ps.setDate(10, Date.valueOf(a.getDataCadastro()));
            ps.setInt(11, a.getIdPlano());
            ps.setInt(12, a.getIdInstrutor());
            ps.setInt(13, a.getIdTreino());
            ps.executeUpdate();
        }
    }

    public List<Aluno> listar() throws Exception {
        List<Aluno> lista = new ArrayList<>();
        try (Connection c = cx(); PreparedStatement ps = c.prepareStatement("SELECT * FROM aluno"); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(map(rs));
            }
        }
        return lista;
    }

    public Aluno buscarPorId(int id) throws Exception {
        try (Connection c = cx(); PreparedStatement ps = c.prepareStatement("SELECT * FROM aluno WHERE id=?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Aluno a = map(rs);
                    a.setPlano(new PlanoDAO().buscarPorId(a.getIdPlano()));
                    a.setInstrutor(new InstrutorDAO().buscarPorId(a.getIdInstrutor()));
                    a.setTreino(new TreinoDAO().buscarPorId(a.getIdTreino()));
                    a.setPagamentos(new PagamentoDAO().listarPorAluno(a.getId()));
                    return a;
                }
            }
        }
        return null;
    }

    public Aluno buscarPorCpf(String cpf) throws Exception {

        String cpfNumeros = cpf.replaceAll("[^0-9]", "");

        String sql = "SELECT * FROM aluno WHERE REPLACE(REPLACE(REPLACE(cpf,'.',''),'-',''),'/','') = ?";
        try (Connection c = cx(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, cpfNumeros);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Aluno a = map(rs);
                    a.setPlano(new PlanoDAO().buscarPorId(a.getIdPlano()));
                    a.setInstrutor(new InstrutorDAO().buscarPorId(a.getIdInstrutor()));
                    a.setTreino(new TreinoDAO().buscarPorId(a.getIdTreino()));
                    a.setPagamentos(new PagamentoDAO().listarPorAluno(a.getId()));
                    return a;
                }
            }
        }
        return null;
    }

    public void atualizar(Aluno a) throws Exception {
        String sql = "UPDATE aluno SET nome=?,cpf=?,dataNascimento=?,telefone=?,email=?,peso=?,altura=?,objetivo=?,status=?,dataCadastro=?,idPlano=?,idInstrutor=?,idTreino=? WHERE id=?";
        try (Connection c = cx(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, a.getNome());
            ps.setString(2, a.getCpf());
            ps.setDate(3, Date.valueOf(a.getDataNascimento()));
            ps.setString(4, a.getTelefone());
            ps.setString(5, a.getEmail());
            ps.setDouble(6, a.getPeso());
            ps.setDouble(7, a.getAltura());
            ps.setString(8, a.getObjetivo());
            ps.setString(9, a.getStatus());
            ps.setDate(10, Date.valueOf(a.getDataCadastro()));
            ps.setInt(11, a.getIdPlano());
            ps.setInt(12, a.getIdInstrutor());
            ps.setInt(13, a.getIdTreino());
            ps.setInt(14, a.getId());
            ps.executeUpdate();
        }
    }

    public void excluir(int id) throws Exception {
        try (Connection c = cx(); PreparedStatement ps = c.prepareStatement("DELETE FROM aluno WHERE id=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    private Aluno map(ResultSet rs) throws SQLException {
        Aluno a = new Aluno();
        a.setId(rs.getInt("id"));
        a.setNome(rs.getString("nome"));
        a.setCpf(rs.getString("cpf"));
        a.setDataNascimento(rs.getDate("dataNascimento").toLocalDate());
        a.setTelefone(rs.getString("telefone"));
        a.setEmail(rs.getString("email"));
        a.setPeso(rs.getDouble("peso"));
        a.setAltura(rs.getDouble("altura"));
        a.setObjetivo(rs.getString("objetivo"));
        a.setStatus(rs.getString("status"));
        a.setDataCadastro(rs.getDate("dataCadastro").toLocalDate());
        a.setIdPlano(rs.getInt("idPlano"));
        a.setIdInstrutor(rs.getInt("idInstrutor"));
        a.setIdTreino(rs.getInt("idTreino"));
        return a;
    }
}
