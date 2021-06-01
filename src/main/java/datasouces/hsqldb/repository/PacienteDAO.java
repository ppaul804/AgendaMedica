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
import datasouces.hsqldb.models.Paciente;
import helper.DateTimeHelper;

public class PacienteDAO extends ConexaoBD implements InterfaceDAO<Paciente> {

    @Override
    public void salvar(Paciente paciente) {
        String sql = "insert into PACIENTE (CPF, NOME, TELEFONE, DATA_DE_NASCIMENTO, ENDERECO, SEXO) " +
                "values (?, ?, ?, ?, ?, ?); ";

        try (Connection c = getConnection()) {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, paciente.getCpf());
            pstm.setString(2, paciente.getNome());
            pstm.setString(3, paciente.getTelefone());
            pstm.setDate(4, DateTimeHelper.toDate(paciente.getDataDeNascimento()));
            pstm.setString(5, paciente.getEndereco());
            pstm.setString(6, String.valueOf(paciente.getSexo()));
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deletar(Paciente paciente) {
        String sql = "DELETE FROM PACIENTE WHERE ID = ?";
        try (Connection c = getConnection()) {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, paciente.getId());
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Paciente buscarPorId(int id) {
        Paciente paciente = new Paciente();
        try (Connection c = getConnection()) {
            PreparedStatement pstm = c.prepareStatement("SELECT * FROM PACIENTE WHERE ID = ?");
            pstm.setInt(1, id);
            ResultSet list = pstm.executeQuery();
            while (list.next()) {
                if (list.getInt("ID") == id) {
                    paciente.setId(list.getInt("ID"));
                    paciente.setCpf(list.getString("CPF"));
                    paciente.setNome(list.getString("NOME"));
                    paciente.setTelefone(list.getString("TELEFONE"));
                    LocalDate dataDeNascimento = DateTimeHelper.toLocalDate(list.getDate("DATA_DE_NASCIMENTO"));
                    paciente.setDataDeNascimento(dataDeNascimento);
                    paciente.setEndereco(list.getString("ENDERECO"));
                    paciente.setSexo(list.getString("SEXO").charAt(0));
                    return paciente;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void atualizar(Paciente paciente) {
        String sql = "update PACIENTE " +
                "set CPF                = ?, " +
                "    NOME               = ?, " +
                "    TELEFONE           = ?, " +
                "    DATA_DE_NASCIMENTO = ?, " +
                "    ENDERECO           = ?, " +
                "    SEXO               = ? " +
                "where ID = ?; ";

        try (Connection c = getConnection()) {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, paciente.getCpf());
            pstm.setString(2, paciente.getNome());
            pstm.setString(3, paciente.getTelefone());
            pstm.setDate(4, DateTimeHelper.toDate(paciente.getDataDeNascimento()));
            pstm.setString(5, paciente.getEndereco());
            pstm.setString(6, String.valueOf(paciente.getSexo()));
            pstm.setInt(7, paciente.getId());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Paciente> listarTodos() {
        List<Paciente> listaDePacientes = new ArrayList<Paciente>();

        try (Connection c = getConnection()) {
            PreparedStatement pst = c.prepareStatement("SELECT * FROM USUARIO");
            ResultSet list = pst.executeQuery();
            while (list.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(list.getInt("ID"));
                paciente.setCpf(list.getString("CPF"));
                paciente.setNome(list.getString("NOME"));
                paciente.setTelefone(list.getString("TELEFONE"));
                LocalDate dataDeNascimento = DateTimeHelper.toLocalDate(list.getDate("DATA_DE_NASCIMENTO"));
                paciente.setDataDeNascimento(dataDeNascimento);
                paciente.setEndereco(list.getString("ENDERECO"));
                paciente.setSexo(list.getString("SEXO").charAt(0));
                listaDePacientes.add(paciente);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listaDePacientes;
    }

    public Paciente buscarPorCpf(String cpf) {
        Paciente paciente = new Paciente();
        try (Connection c = getConnection()) {
            PreparedStatement pstm = c.prepareStatement("select * from PACIENTE where CPF = ?");
            pstm.setString(1, cpf);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getString("CPF").equals(cpf)) {
                    paciente.setId(resultSet.getInt("ID"));
                    paciente.setCpf(resultSet.getString("CPF"));
                    paciente.setNome(resultSet.getString("NOME"));
                    paciente.setTelefone(resultSet.getString("TELEFONE"));
                    LocalDate dataDeNascimento = DateTimeHelper.toLocalDate(resultSet.getDate("DATA_DE_NASCIMENTO"));
                    paciente.setDataDeNascimento(dataDeNascimento);
                    paciente.setEndereco(resultSet.getString("ENDERECO"));
                    paciente.setSexo(resultSet.getString("SEXO").charAt(0));
                    return paciente;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return null;
    }
}
