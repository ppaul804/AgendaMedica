package datasouces.hsqldb.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexaoBD {

    private final String urlDoBanco = "jdbc:hsqldb:file:database/";
    private final String nomeDoBanco = "agendaDB;hsqldb.lock_file=false";
    private final String usuarioDoBanco = "SA";
    private final String senha = "";

    public Connection conexao;

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(urlDoBanco + nomeDoBanco, usuarioDoBanco, senha);
    }

    public void executarScript(String sql) {
        try (Connection c = getConnection()) {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
