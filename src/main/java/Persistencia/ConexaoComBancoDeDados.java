package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexaoComBancoDeDados {
    
    //url de conexão com banco
    private final String urlDoBanco = "jdbc:hsqldb:file:BancoDeDados/";

    // nome do Banco
    private final String nomeDoBanco = "agendaDB;hsqldb.lock_file=false";

    // nome do usuário do banco
    private final String usuarioDoBanco = "SA";

    //
    private final String senha = "";

    public Connection conexao;

    public void conectar() throws SQLException {

        conexao = DriverManager.getConnection(urlDoBanco + nomeDoBanco, usuarioDoBanco, senha);

    }

    public void desconectar() throws SQLException {
        conexao.close();
    }

    public void executarScript(String sql) throws SQLException {
        
        System.out.println("Executando Script sql .... \n" + sql);

        conectar();
        PreparedStatement pstm = conexao.prepareStatement(sql);
        pstm.execute();
        conexao.commit();
        desconectar();

    }

}
