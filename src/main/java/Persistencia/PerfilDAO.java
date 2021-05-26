package Persistencia;

import Entidades.Perfil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PerfilDAO extends ConexaoComBancoDeDados implements InterfaceDAO {

    @Override
    public void salvar(Object entidade) throws SQLException {

        // cast entidade ...transformando entidade em Perfil
        Perfil perfil = (Perfil) entidade;

        // Montando o sql
        String sql = "INSERT INTO PERFIL ("
                + "CODIGO,"
                + "NOME,"
                + "DESCRICAO) VALUES (?,?,?);";

        // Abrir conexão com banco de dados
        conectar();
        PreparedStatement pstm = conexao.prepareStatement(sql);
        pstm.setInt(1, perfil.getCodigo());
        pstm.setString(2, perfil.getNome());
        pstm.setString(3, perfil.getDescricao());
        pstm.execute();
        conexao.commit();
        desconectar();

    }

    @Override
    public void deletar(Object entidade) throws SQLException {

        //CAST
        Perfil perfil = (Perfil) entidade;

        // MONTAGEM DA STRING SQL
        String sql = "DELETE FROM PERFIL WHERE CODIGO = ?";
        conectar();
        PreparedStatement pstm = conexao.prepareStatement(sql);
        pstm.setInt(1, perfil.getCodigo());
        pstm.execute();
        conexao.commit();
        desconectar();

    }

    @Override
    public Object buscarPorId(int id) throws SQLException {

        String sql = "SELECT * FROM PERFIL WHERE CODIGO = ?";
        conectar();
        PreparedStatement pstm = conexao.prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet lista = pstm.executeQuery();
        Perfil perfil = new Perfil();
        while (lista.next()) {

            perfil.setCodigo(lista.getInt("CODIGO"));
            perfil.setNome(lista.getString("NOME"));
            perfil.setDescricao(lista.getString("DESCRICAO"));

        }
        desconectar();
        return perfil;

    }

    @Override
    public void atualizar(Object entidade) throws SQLException {

        Perfil perfil = (Perfil) entidade;

        String sql = "UPDATE PERFIL SET "
                + "NOME = ?,"
                + "DESCRICAO = ?"
                + "WHERE CODIGO = ?";

        conectar();
        PreparedStatement pstm = conexao.prepareStatement(sql);
        pstm.setString(1, perfil.getNome());
        pstm.setString(2, perfil.getDescricao());
        pstm.setInt(3, perfil.getCodigo());
        pstm.execute();
        conexao.commit();
        desconectar();

    }

    @Override
    public List<Perfil> listarTodos() throws SQLException {

        List<Perfil> listaDePerfis = new ArrayList<>();

        String sql = "SELECT * FROM PERFIL ;";
        conectar();
        PreparedStatement pstm = conexao.prepareStatement(sql);
        ResultSet linhasDaTabelas = pstm.executeQuery();
        while (linhasDaTabelas.next()) {
            
            Perfil perfil = new Perfil();
            perfil.setCodigo(linhasDaTabelas.getInt("CODIGO"));
            perfil.setNome(linhasDaTabelas.getString("NOME"));
            perfil.setDescricao(linhasDaTabelas.getString("DESCRICAO"));

            listaDePerfis.add(perfil);

        }
        desconectar();
        return listaDePerfis;

    }

}
