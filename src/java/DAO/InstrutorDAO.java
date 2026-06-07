package DAO;

import java.sql.*;
import java.util.*;
import java.sql.Date;
import Util.FabricaConexao;
import Model.Instrutor;

public class InstrutorDAO {

    private Connection cx() throws Exception {
        return FabricaConexao.getConexaoMySQL();
    }

    public void cadastrar(Instrutor i) throws Exception {
        String sql = "INSERT INTO instrutor(nome,cpf,dataNascimento,telefone,email,especialidade,cref,salario,cargaHoraria,status,dataContratacao) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection c = cx(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, i.getNome());
            ps.setString(2, i.getCpf());
            ps.setDate(3, Date.valueOf(i.getDataNascimento()));
            ps.setString(4, i.getTelefone());
            ps.setString(5, i.getEmail());
            ps.setString(6, i.getEspecialidade());
            ps.setInt(7, i.getCref());
            ps.setDouble(8, i.getSalario());
            ps.setDouble(9, i.getCargaHoraria());
            ps.setString(10, i.getStatus());
            ps.setDate(11, Date.valueOf(i.getDataContratacao()));
            ps.executeUpdate();
        }
    }

    public List<Instrutor> listar() throws Exception {
        List<Instrutor> lista = new ArrayList<>();
        try (Connection c = cx(); PreparedStatement ps = c.prepareStatement("SELECT * FROM instrutor"); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(map(rs));
            }
        }
        return lista;
    }

    public Instrutor buscarPorId(int id) throws Exception {
        try (Connection c = cx(); PreparedStatement ps = c.prepareStatement("SELECT * FROM instrutor WHERE id=?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return map(rs);
                }
            }
        }
        return null;
    }

    public void atualizar(Instrutor i) throws Exception {
        String sql = "UPDATE instrutor SET nome=?,cpf=?,dataNascimento=?,telefone=?,email=?,especialidade=?,cref=?,salario=?,cargaHoraria=?,status=?,dataContratacao=? WHERE id=?";
        try (Connection c = cx(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, i.getNome());
            ps.setString(2, i.getCpf());
            ps.setDate(3, Date.valueOf(i.getDataNascimento()));
            ps.setString(4, i.getTelefone());
            ps.setString(5, i.getEmail());
            ps.setString(6, i.getEspecialidade());
            ps.setInt(7, i.getCref());
            ps.setDouble(8, i.getSalario());
            ps.setDouble(9, i.getCargaHoraria());
            ps.setString(10, i.getStatus());
            ps.setDate(11, Date.valueOf(i.getDataContratacao()));
            ps.setInt(12, i.getId());
            ps.executeUpdate();
        }
    }

    public void excluir(int id) throws Exception {
        try (Connection c = cx(); PreparedStatement ps = c.prepareStatement("DELETE FROM instrutor WHERE id=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    private Instrutor map(ResultSet rs) throws SQLException {
        Instrutor i = new Instrutor();
        i.setId(rs.getInt("id"));
        i.setNome(rs.getString("nome"));
        i.setCpf(rs.getString("cpf"));
        i.setDataNascimento(rs.getDate("dataNascimento").toLocalDate());
        i.setTelefone(rs.getString("telefone"));
        i.setEmail(rs.getString("email"));
        i.setEspecialidade(rs.getString("especialidade"));
        i.setCref(rs.getInt("cref"));
        i.setSalario(rs.getDouble("salario"));
        i.setCargaHoraria(rs.getDouble("cargaHoraria"));
        i.setStatus(rs.getString("status"));
        i.setDataContratacao(rs.getDate("dataContratacao").toLocalDate());
        return i;
    }
}
