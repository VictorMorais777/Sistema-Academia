package Util;

import java.sql.Connection;
import java.sql.DriverManager;


public class FabricaConexao {

    private static final String URL = "jdbc:mysql://localhost:3306/academia?useSSL=false&serverTimezone=America/Sao_Paulo";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    private FabricaConexao() {
    }

    public static Connection getConexaoMySQL() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
