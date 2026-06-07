package DAO;

import java.sql.*;
import java.util.*;
import java.sql.Date;
import Util.FabricaConexao;
import Builder.TreinoBuilder;
import Model.Treino;

public class TreinoDAO {

    private Connection cx() throws Exception {
        return FabricaConexao.getConexaoMySQL();
    }

    public void cadastrar(Treino t) throws Exception {
        String sql = "INSERT INTO treino(nomeTreino,objetivo,nivel,duracaoMinutos,quantidadeExercicios,descricao,dataCriacao,observacoes,status) VALUES(?,?,?,?,?,?,?,?,?)";
        try (Connection c = cx(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, t.getNomeTreino());
            ps.setString(2, t.getObjetivo());
            ps.setString(3, t.getNivel());
            ps.setInt(4, t.getDuracaoMinutos());
            ps.setInt(5, t.getQuantidadeExercicios());
            ps.setString(6, t.getDescricao());
            ps.setDate(7, Date.valueOf(t.getDataCriacao()));
            ps.setString(8, t.getObservacoes());
            ps.setString(9, t.getStatus());
            ps.executeUpdate();
        }
    }

    public List<Treino> listar() throws Exception {
        List<Treino> lista = new ArrayList<>();
        try (Connection c = cx(); PreparedStatement ps = c.prepareStatement("SELECT * FROM treino"); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(map(rs));
            }
        }
        return lista;
    }

    public Treino buscarPorId(int id) throws Exception {
        try (Connection c = cx(); PreparedStatement ps = c.prepareStatement("SELECT * FROM treino WHERE id=?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return map(rs);
                }
            }
        }
        return null;
    }

    public void atualizar(Treino t) throws Exception {
        String sql = "UPDATE treino SET nomeTreino=?,objetivo=?,nivel=?,duracaoMinutos=?,quantidadeExercicios=?,descricao=?,dataCriacao=?,observacoes=?,status=? WHERE id=?";
        try (Connection c = cx(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, t.getNomeTreino());
            ps.setString(2, t.getObjetivo());
            ps.setString(3, t.getNivel());
            ps.setInt(4, t.getDuracaoMinutos());
            ps.setInt(5, t.getQuantidadeExercicios());
            ps.setString(6, t.getDescricao());
            ps.setDate(7, Date.valueOf(t.getDataCriacao()));
            ps.setString(8, t.getObservacoes());
            ps.setString(9, t.getStatus());
            ps.setInt(10, t.getId());
            ps.executeUpdate();
        }
    }

    public void excluir(int id) throws Exception {
        try (Connection c = cx(); PreparedStatement ps = c.prepareStatement("DELETE FROM treino WHERE id=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    private Treino map(ResultSet rs) throws SQLException {
        return new TreinoBuilder()
                .comId(rs.getInt("id")).comNomeTreino(rs.getString("nomeTreino"))
                .comObjetivo(rs.getString("objetivo")).comNivel(rs.getString("nivel"))
                .comDuracaoMinutos(rs.getInt("duracaoMinutos")).comQuantidadeExercicios(rs.getInt("quantidadeExercicios"))
                .comDescricao(rs.getString("descricao")).comDataCriacao(rs.getDate("dataCriacao").toLocalDate())
                .comObservacoes(rs.getString("observacoes")).comStatus(rs.getString("status")).constroi();
    }
}
