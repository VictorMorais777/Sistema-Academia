package DAO;

import java.sql.*;
import java.util.*;
import java.sql.Date;
import Util.FabricaConexao;
import Model.Pagamento;

public class PagamentoDAO {

    private Connection cx() throws Exception {
        return FabricaConexao.getConexaoMySQL();
    }

    public void cadastrar(Pagamento p) throws Exception {
        String sql = "INSERT INTO pagamento(idAluno,valor,dataPagamento,dataVencimento,formaPagamento,status,multa,desconto,comprovante,referencia) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try (Connection c = cx(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, p.getIdAluno());
            ps.setDouble(2, p.getValor());
            ps.setDate(3, p.getDataPagamento() != null ? Date.valueOf(p.getDataPagamento()) : null);
            ps.setDate(4, Date.valueOf(p.getDataVencimento()));
            ps.setString(5, p.getFormaPagamento());
            ps.setString(6, p.getStatus());
            ps.setDouble(7, p.getMulta());
            ps.setDouble(8, p.getDesconto());
            ps.setString(9, p.getComprovante());
            ps.setString(10, p.getReferencia());
            ps.executeUpdate();
        }
    }

    public List<Pagamento> listar() throws Exception {
        List<Pagamento> lista = new ArrayList<>();
        String sql = "SELECT p.*, a.nome AS nomeAluno FROM pagamento p LEFT JOIN aluno a ON p.idAluno = a.id ORDER BY p.id DESC";
        try (Connection c = cx(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(map(rs));
            }
        }
        return lista;
    }

    public List<Pagamento> listarPorAluno(int idAluno) throws Exception {
        List<Pagamento> lista = new ArrayList<>();
        String sql = "SELECT p.*, a.nome AS nomeAluno FROM pagamento p LEFT JOIN aluno a ON p.idAluno = a.id WHERE p.idAluno=? ORDER BY p.dataVencimento DESC";
        try (Connection c = cx(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, idAluno);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(map(rs));
                }
            }
        }
        return lista;
    }

    public Pagamento buscarPorId(int id) throws Exception {
        String sql = "SELECT p.*, a.nome AS nomeAluno FROM pagamento p LEFT JOIN aluno a ON p.idAluno = a.id WHERE p.id=?";
        try (Connection c = cx(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return map(rs);
                }
            }
        }
        return null;
    }

    public void atualizar(Pagamento p) throws Exception {
        String sql = "UPDATE pagamento SET idAluno=?,valor=?,dataPagamento=?,dataVencimento=?,formaPagamento=?,status=?,multa=?,desconto=?,comprovante=?,referencia=? WHERE id=?";
        try (Connection c = cx(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, p.getIdAluno());
            ps.setDouble(2, p.getValor());
            ps.setDate(3, p.getDataPagamento() != null ? Date.valueOf(p.getDataPagamento()) : null);
            ps.setDate(4, Date.valueOf(p.getDataVencimento()));
            ps.setString(5, p.getFormaPagamento());
            ps.setString(6, p.getStatus());
            ps.setDouble(7, p.getMulta());
            ps.setDouble(8, p.getDesconto());
            ps.setString(9, p.getComprovante());
            ps.setString(10, p.getReferencia());
            ps.setInt(11, p.getId());
            ps.executeUpdate();
        }
    }

    public void excluir(int id) throws Exception {
        try (Connection c = cx(); PreparedStatement ps = c.prepareStatement("DELETE FROM pagamento WHERE id=?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    private Pagamento map(ResultSet rs) throws SQLException {
        Pagamento p = new Pagamento();
        p.setId(rs.getInt("id"));
        p.setIdAluno(rs.getInt("idAluno"));
        p.setNomeAluno(rs.getString("nomeAluno"));
        p.setValor(rs.getDouble("valor"));
        p.setDataVencimento(rs.getDate("dataVencimento").toLocalDate());
        p.setFormaPagamento(rs.getString("formaPagamento"));
        p.setStatus(rs.getString("status"));
        p.setMulta(rs.getDouble("multa"));
        p.setDesconto(rs.getDouble("desconto"));
        p.setComprovante(rs.getString("comprovante"));
        p.setReferencia(rs.getString("referencia"));
        Date dp = rs.getDate("dataPagamento");
        if (dp != null) {
            p.setDataPagamento(dp.toLocalDate());
        }
        return p;
    }
}
