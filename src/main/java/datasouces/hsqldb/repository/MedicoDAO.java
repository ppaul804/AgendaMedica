package datasouces.hsqldb.repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import datasouces.hsqldb.config.ConexaoBD;
import datasouces.hsqldb.models.Medico;
import helper.DateTimeHelper;

public class MedicoDAO extends ConexaoBD implements InterfaceDAO<Medico> {

    @Override
    public void salvar(Medico medico) {
        String sql = "insert into MEDICO (NOME, ESPECIALIDADE, SEXO, DATA_DE_NASCIMENTO, SALARIO) " +
                "values (?, ?, ?, ?, ?); ";

        try (Connection c = getConnection()) {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, medico.getNome());
            pstm.setString(2, medico.getEspecialidade());
            pstm.setString(3, String.valueOf(medico.getSexo()));
            pstm.setDate(4, DateTimeHelper.toDate(medico.getDataDeNascimento()));
            pstm.setInt(5, medico.getSalario().intValue());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deletar(Medico medico) {
        String sql = "DELETE FROM MEDICO WHERE CRM = ?";
        try (Connection c = getConnection()) {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, medico.getCrm());
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Medico buscarPorId(int crm) {
        Medico medico = new Medico();
        try (Connection c = getConnection()) {
            PreparedStatement pstm = c.prepareStatement("SELECT * FROM MEDICO WHERE CRM = ?");
            pstm.setInt(1, crm);
            ResultSet list = pstm.executeQuery();
            while (list.next()) {
                if (list.getInt("CRM") == crm) {
                    medico.setCrm(list.getInt("CRM"));
                    medico.setNome(list.getString("NOME"));
                    medico.setEspecialidade(list.getString("ESPECIALIDADE"));
                    medico.setSexo(list.getString("SEXO").charAt(0));
                    LocalDate dataDeNascimento = DateTimeHelper.toLocalDate(list.getDate("DATA_DE_NASCIMENTO"));
                    medico.setDataDeNascimento(dataDeNascimento);
                    medico.setSalario(new BigDecimal(list.getInt("SALARIO")));
                    return medico;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void atualizar(Medico medico) {
        String sql = "update MEDICO " +
                "set NOME               = ?, " +
                "    ESPECIALIDADE      = ?, " +
                "    SEXO               = ?, " +
                "    DATA_DE_NASCIMENTO = ?, " +
                "    SALARIO            = ?, " +
                "    where CRM = ?; ";

        try (Connection c = getConnection()) {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, medico.getNome());
            pstm.setString(2, medico.getEspecialidade());
            pstm.setString(3, String.valueOf(medico.getSexo()));
            pstm.setDate(4, DateTimeHelper.toDate(medico.getDataDeNascimento()));
            pstm.setInt(5, medico.getSalario().intValue());
            pstm.setInt(6, medico.getCrm());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Medico> listarTodos() {
        List<Medico> listaDeMedicos = new ArrayList<Medico>();

        try (Connection c = getConnection()) {
            PreparedStatement pst = c.prepareStatement("SELECT * FROM MEDICO");
            ResultSet list = pst.executeQuery();
            while (list.next()) {
                Medico medico = new Medico();
                medico.setCrm(list.getInt("CRM"));
                medico.setNome(list.getString("NOME"));
                medico.setEspecialidade(list.getString("ESPECIALIDADE"));
                medico.setSexo(list.getString("SEXO").charAt(0));
                LocalDate dataDeNascimento = DateTimeHelper.toLocalDate(list.getDate("DATA_DE_NASCIMENTO"));
                medico.setDataDeNascimento(dataDeNascimento);
                medico.setSalario(new BigDecimal(list.getInt("SALARIO")));
                listaDeMedicos.add(medico);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listaDeMedicos;
    }

    public int buscarPorNome(String nome) {
        Medico medico = new Medico();
        try (Connection c = getConnection()) {
            PreparedStatement pstm = c.prepareStatement("SELECT * FROM MEDICO WHERE NOME = ?");
            pstm.setString(1, nome);
            ResultSet list = pstm.executeQuery();
            while (list.next()) {
                if (list.getString("NOME").equals(nome)) {
                    medico.setCrm(list.getInt("CRM"));
                    medico.setNome(list.getString("NOME"));
                    medico.setEspecialidade(list.getString("ESPECIALIDADE"));
                    medico.setSexo(list.getString("SEXO").charAt(0));
                    LocalDate dataDeNascimento = DateTimeHelper.toLocalDate(list.getDate("DATA_DE_NASCIMENTO"));
                    medico.setDataDeNascimento(dataDeNascimento);
                    medico.setSalario(new BigDecimal(list.getInt("SALARIO")));
                    return medico.getCrm();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }
}
