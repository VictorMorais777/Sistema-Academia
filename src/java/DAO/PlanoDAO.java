package DAO;

import java.sql.*;
import java.util.*;
import Util.FabricaConexao;
import Builder.PlanoBuilder;
import Model.Plano;

public class PlanoDAO {

    private Connection cx() throws Exception {
        return FabricaConexao.getConexaoMySQL();
    }

    public void cadastrar(Plano p) throws Exception {
        String sql = "INSERT INTO plano(nomePlano,descricao,valorMensal,duracaoMeses,acessoLivre,tipoConvenio,quantidadeAulas,tipoPlano,desconto,status) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try (Connection c = cx(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, p.getNomePlano());
            ps.setString(2, p.getDescricao());
            ps.setDouble(3, p.getValorMensal());
            ps.setInt(4, p.getDuracaoMeses());
            ps.setString(5, p.getAcessoLivre());
            ps.setString(6, p.getTipoConvenio());
            ps.setInt(7, p.getQuantidadeAulas());
            ps.setString(8, p.getTipoPlano());
            ps.setDouble(9, p.getDesconto());
            ps.setString(10, p.getStatus());
            ps.executeUpdate();
        }
    }

    public List<Plano> listar() throws Exception {
        List<Plano> lista = new ArrayList<>();
        try (Connection c = cx(); PreparedStatement ps = c.prepareStatement("SELECT * FROM plano"); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(map(rs));
            }
        }
        return lista;
    }

    public Plano buscarPorId(int id) throws Exception {
        try (Connection c = cx(); PreparedStatement ps = c.prepareStatement("SELECT * FROM plano WHERE id=?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return map(rs);
                }
            }
        }
        return null;
    }

    public void atualizar(Plano p) throws Exception {
        String sql = "UPDATE plano SET nomePlano=?,descricao=?,valorMensal=?,duracaoMeses=?,acessoLivre=?,tipoConvenio=?,quantidadeAulas=?,tipoPlano=?,desconto=?,status=? WHERE id=?";
        try (Connection c = cx(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, p.getNomePlano());
            ps.setString(2, p.getDescricao());
            ps.setDouble(3, p.getValorMensal());
            ps.setInt(4, p.getDuracaoMeses());
            ps.setString(5, p.getAcessoLivre());
            ps.setString(6, p.getTipoConvenio());
            ps.setInt(7, p.getQuantidadeAulas());
            ps.setString(8, p.getTipoPlano());
            ps.setDouble(9, p.getDesconto());
            ps.setString(10, p.getStatus());
            ps.setInt(11, p.getId());
            ps.executeUpdate();
        }
    }

    public void excluir(int id) throws Exception {
        try (Connection c = cx(); PreparedStatement ps = c.prepareStatement("DELETE FROM plano WHERE id=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    private Plano map(ResultSet rs) throws SQLException {
        return new PlanoBuilder()
                .comId(rs.getInt("id")).comNomePlano(rs.getString("nomePlano"))
                .comDescricao(rs.getString("descricao")).comValorMensal(rs.getDouble("valorMensal"))
                .comDuracaoMeses(rs.getInt("duracaoMeses")).comAcessoLivre(rs.getString("acessoLivre"))
                .comTipoConvenio(rs.getString("tipoConvenio")).comQuantidadeAulas(rs.getInt("quantidadeAulas"))
                .comTipoPlano(rs.getString("tipoPlano")).comDesconto(rs.getDouble("desconto"))
                .comStatus(rs.getString("status")).constroi();
    }
}
