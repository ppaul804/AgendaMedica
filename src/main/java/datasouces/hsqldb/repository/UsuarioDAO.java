package datasouces.hsqldb.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import datasouces.hsqldb.config.ConexaoBD;
import datasouces.hsqldb.models.Usuario;
import helper.DateTimeHelper;

public class UsuarioDAO extends ConexaoBD implements InterfaceDAO<Usuario> {

    @Override
    public void salvar(Usuario usuario) {
        String sql = "insert into USUARIO (CPF, NOME, USERNAME, SENHA, CODIGO_PERFIL, TELEFONE, MATRICULA, DATA_NASCIMENTO) "
                + "values (?, ?, ?, ?, ?, ?, NEXT VALUE FOR MATRICULA_SEQ, ?) ";

        try (Connection c = getConnection()) {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, usuario.getCpf());
            pstm.setString(2, usuario.getNome());
            pstm.setString(3, usuario.getUsername());
            pstm.setString(4, usuario.getSenha());
            pstm.setInt(5, usuario.getCodigoPerfil());
            pstm.setString(6, usuario.getTelefone());
            pstm.setDate(7, DateTimeHelper.toDate(usuario.getDataNascimento()));
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deletar(Usuario usuario) {
        String sql = "DELETE FROM USUARIO WHERE ID = ?";
        try (Connection c = getConnection()) {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, usuario.getId());
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Usuario buscarPorId(int id) {
        Usuario usuario = new Usuario();
        try (Connection c = getConnection()) {
            PreparedStatement pstm = c.prepareStatement("SELECT * FROM USUARIO WHERE ID = ?");
            pstm.setInt(1, id);
            ResultSet list = pstm.executeQuery();
            while (list.next()) {
                if (list.getInt("ID") == id) {
                    usuario.setCpf(list.getString("CPF"));
                    usuario.setNome(list.getString("NOME"));
                    usuario.setUsername(list.getString("USERNAME"));
                    usuario.setSenha(list.getString("SENHA"));
                    usuario.setCodigoPerfil(list.getInt("CODIGO_PERFIL"));
                    usuario.setTelefone(list.getString("TELEFONE"));
                    usuario.setMatricula(list.getString("MATRICULA"));
                    LocalDate dataNascimento = DateTimeHelper.toLocalDate(list.getDate("DATA_NASCIMENTO"));
                    usuario.setDataNascimento(dataNascimento);
                    return usuario;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void atualizar(Usuario usuario) {
        String sql = "update USUARIO " +
                "set CPF             = ?, " +
                "    NOME            = ?, " +
                "    USERNAME        = ?, " +
                "    SENHA           = ?, " +
                "    CODIGO_PERFIL   = ?, " +
                "    TELEFONE        = ?, " +
                "    MATRICULA       = ?, " +
                "    DATA_NASCIMENTO = ?, " +
                "    where ID = ?; ";

        try (Connection c = getConnection()) {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, usuario.getCpf());
            pstm.setString(2, usuario.getNome());
            pstm.setString(3, usuario.getUsername());
            pstm.setString(4, usuario.getSenha());
            pstm.setInt(5, usuario.getCodigoPerfil());
            pstm.setString(6, usuario.getTelefone());
            pstm.setDate(7, DateTimeHelper.toDate(usuario.getDataNascimento()));
            pstm.setInt(8, usuario.getId());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Usuario> listarTodos() {
        List<Usuario> listaDeUsuarios = new ArrayList<Usuario>();

        try (Connection c = getConnection()) {
            PreparedStatement pst = c.prepareStatement("SELECT * FROM USUARIO");
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
                LocalDate dataNascimento = DateTimeHelper.toLocalDate(list.getDate("DATA_NASCIMENTO"));
                usuario.setDataNascimento(dataNascimento);
                listaDeUsuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listaDeUsuarios;
    }

    public Usuario loginBD(String username, String senha) {
        Usuario usuario = new Usuario();

        String sql = "SELECT * FROM USUARIO WHERE USERNAME = ? AND SENHA = ?;";

        try (Connection c = getConnection()) {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, username);
            pstm.setString(2, senha);
    
            ResultSet linhasDaTabela = pstm.executeQuery();
    
            while (linhasDaTabela.next()) {
                usuario.setCpf(linhasDaTabela.getString("CPF"));
                usuario.setNome(linhasDaTabela.getString("NOME"));
                usuario.setUsername(linhasDaTabela.getString("USERNAME"));
                usuario.setSenha(linhasDaTabela.getString("SENHA"));
                usuario.setCodigoPerfil(linhasDaTabela.getInt("CODIGO_PERFIL"));
                usuario.setTelefone(linhasDaTabela.getString("TELEFONE"));
                usuario.setMatricula(linhasDaTabela.getString("MATRICULA"));
                LocalDate dataNascimento = DateTimeHelper.toLocalDate(linhasDaTabela.getDate("DATA_NASCIMENTO"));
                usuario.setDataNascimento(dataNascimento);
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;

    }

    public boolean existeUsername(String username) {
        try (Connection c = getConnection()) {
            PreparedStatement pstm = c.prepareStatement("SELECT USERNAME FROM USUARIO WHERE USERNAME = ?");
            pstm.setString(1, username);
            ResultSet linhasDaTabela = pstm.executeQuery();
    
            while (linhasDaTabela.next()) {
                if (linhasDaTabela.getString("USERNAME") != null)
                    return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public Usuario buscarPorCpf(String cpf) {
        Usuario usuario = new Usuario();
        try (Connection c = getConnection()) {
            PreparedStatement pstm = c.prepareStatement("select * from USUARIO where CPF = ?");
            pstm.setString(1, cpf);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getString("CPF").equals(cpf)) {
                    usuario.setId(resultSet.getInt("ID"));
                    usuario.setCpf(resultSet.getString("CPF"));
                    usuario.setNome(resultSet.getString("NOME"));
                    usuario.setUsername(resultSet.getString("USERNAME"));
                    usuario.setSenha(resultSet.getString("SENHA"));
                    usuario.setCodigoPerfil(resultSet.getInt("CODIGO_PERFIL"));
                    usuario.setTelefone(resultSet.getString("TELEFONE"));
                    usuario.setMatricula(resultSet.getString("MATRICULA"));
                    usuario.setDataNascimento(DateTimeHelper.toLocalDate(resultSet.getDate("DATA_NASCIMENTO")));      
                    return usuario;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return null;
    }
}
