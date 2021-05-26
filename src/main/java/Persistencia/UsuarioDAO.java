package Persistencia;

import Entidades.Usuario;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends ConexaoComBancoDeDados implements InterfaceDAO {

    @Override
    public void salvar(Object entidade) throws SQLException {

        Usuario usuario = (Usuario) entidade;

        String sql = "INSERT INTO USUARIO ( "
                + "CPF,"
                + "NOME,"
                + "USERNAME,"
                + "SENHA,"
                + "CODIGO_PERFIL,"
                + "TELEFONE,"
                + "MATRICULA,"
                + "DATA_NASCIMENTO) VALUES"
                + "(?,?,?,?,?,?,NEXT VALUE FOR MATRICULA_SEQ,?);";

        conectar();

        PreparedStatement pstm = conexao.prepareStatement(sql);
        pstm.setString(1, usuario.getCpf());
        pstm.setString(2, usuario.getNome());
        pstm.setString(3, usuario.getUsername());
        pstm.setString(4, usuario.getSenha());
        pstm.setInt(5, usuario.getCodigoPerfil());
        pstm.setString(6, usuario.getTelefone());
        Date dataPadraoSql = new Date(usuario.getDataNascimento().getTime());
        pstm.setDate(7, dataPadraoSql);
        pstm.execute();
        conexao.commit();
        desconectar();
    }

    @Override
    public void deletar(Object entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object buscarPorId(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Object entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> listarTodos() throws SQLException {

        List<Usuario> listaDeUsuarios = new ArrayList<Usuario>();

        String sql = "SELECT * FROM USUARIO";

        conectar();

        try {

            PreparedStatement pst = conexao.prepareStatement(sql);
            ResultSet list = pst.executeQuery();
            while (list.next()) {
                Usuario usuario = new Usuario();
                usuario.setCpf(list.getString("CPF"));
                usuario.setNome(list.getString("NOME"));
                usuario.setUsername(list.getString("USERNAME"));
                usuario.setSenha(list.getString("SENHA"));
                usuario.setCodigoPerfil(list.getInt("CODIGO_PERFIL"));
                usuario.setTelefone(list.getString("TELEFONE"));
                usuario.setMatricula(list.getString("MATRICULA"));
                usuario.setDataNascimento(list.getDate("DATA_NASCIMENTO"));
                listaDeUsuarios.add(usuario);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println(e);
        }

        return listaDeUsuarios;

    }

    public Usuario loginBD(String username, String senha) throws SQLException {

        Usuario usuarioBD = new Usuario();

        String sql = "SELECT * FROM USUARIO WHERE USERNAME = ? AND SENHA = ?;";

        conectar();
        PreparedStatement pstm = conexao.prepareStatement(sql);
        pstm.setString(1, username);
        pstm.setString(2, senha);

        ResultSet linhasDaTabela = pstm.executeQuery();

        while (linhasDaTabela.next()) {
            usuarioBD.setCpf(linhasDaTabela.getString("CPF"));
            usuarioBD.setNome(linhasDaTabela.getString("NOME"));
            usuarioBD.setUsername(linhasDaTabela.getString("USERNAME"));
            usuarioBD.setSenha(linhasDaTabela.getString("SENHA"));
            usuarioBD.setCodigoPerfil(linhasDaTabela.getInt("CODIGO_PERFIL"));
            usuarioBD.setTelefone(linhasDaTabela.getString("TELEFONE"));
            usuarioBD.setMatricula(linhasDaTabela.getString("MATRICULA"));
            usuarioBD.setDataNascimento(linhasDaTabela.getDate("DATA_NASCIMENTO"));
        }

        desconectar();
        return usuarioBD;

    }

    public boolean existeUsername(String username) throws SQLException {

        Usuario usuarioBD = new Usuario();
        String sql = "SELECT * FROM USUARIO WHERE USERNAME = ? ;";

        conectar();
        PreparedStatement pstm = conexao.prepareStatement(sql);
        pstm.setString(1, username);

        ResultSet linhasDaTabela = pstm.executeQuery();

        while (linhasDaTabela.next()) {
            usuarioBD.setCpf(linhasDaTabela.getString("CPF"));
            usuarioBD.setNome(linhasDaTabela.getString("NOME"));
            usuarioBD.setUsername(linhasDaTabela.getString("USERNAME"));
            usuarioBD.setSenha(linhasDaTabela.getString("SENHA"));
            usuarioBD.setCodigoPerfil(linhasDaTabela.getInt("CODIGO_PERFIL"));
            usuarioBD.setTelefone(linhasDaTabela.getString("TELEFONE"));
            usuarioBD.setMatricula(linhasDaTabela.getString("MATRICULA"));
            usuarioBD.setDataNascimento(linhasDaTabela.getDate("DATA_NASCIMENTO"));
        }

        desconectar();

        if (usuarioBD.getUsername() != null) {

            return true;
        }

        return false;

    }

}
