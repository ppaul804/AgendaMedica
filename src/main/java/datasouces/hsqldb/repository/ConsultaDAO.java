package datasouces.hsqldb.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import datasouces.hsqldb.config.ConexaoBD;
import datasouces.hsqldb.models.Consulta;
import helper.DateTimeHelper;

public class ConsultaDAO extends ConexaoBD implements InterfaceDAO<Consulta> {

    @Override
    public void salvar(Consulta consulta) {
        String sql = "insert into CONSULTA (ID_PACIENTE, CRM_MEDICO, ID_PLANO_DE_SAUDE, SALA, DATA_DA_CONSULTA, HORA_DA_CONSULTA) " +
                "values (?, ?, ?, ?, ?, ?); ";

        try (Connection c = getConnection()) {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, consulta.getIdPaciente());
            pstm.setInt(2, consulta.getCrmMedico());
            pstm.setInt(3, consulta.getIdPlanoDeSaude());
            pstm.setString(4, consulta.getSala());
            pstm.setDate(5, DateTimeHelper.toDate(consulta.getDataDaConsulta()));
            pstm.setTime(6, DateTimeHelper.toTime(consulta.getHoraDaConsulta()));
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deletar(Consulta consulta) {
        String sql = "DELETE FROM CONSULTA WHERE ID = ?";
        try (Connection c = getConnection()) {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, consulta.getId());
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Consulta buscarPorId(int id) {
        Consulta consulta = new Consulta();
        try (Connection c = getConnection()) {
            PreparedStatement pstm = c.prepareStatement("SELECT * FROM CONSULTA WHERE ID = ?");
            pstm.setInt(1, id);
            ResultSet list = pstm.executeQuery();
            while (list.next()) {
                if (list.getInt("ID") == id) {
                    consulta.setId(list.getInt("ID"));
                    consulta.setIdPaciente(list.getInt("ID_PACIENTE"));
                    consulta.setCrmMedico(list.getInt("CRM_MEDICO"));
                    consulta.setIdPlanoDeSaude(list.getInt("ID_PLANO_DE_SAUDE"));
                    consulta.setSala(list.getString("SALA"));
                    consulta.setDataDaConsulta(DateTimeHelper.toLocalDate(list.getDate("DATA_DA_CONSULTA")));
                    consulta.setHoraDaConsulta(DateTimeHelper.toLocalTime(list.getTime("HORA_DA_CONSULTA")));
                    return consulta;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void atualizar(Consulta consulta) {
        String sql = "update CONSULTA " +
                "set ID_PLANO_DE_SAUDE = ?, " +
                "    ID_PACIENTE       = ?, " +
                "    CRM_MEDICO        = ?, " +
                "    SALA              = ?, " +
                "    DATA_DA_CONSULTA  = ?, " +
                "    HORA_DA_CONSULTA  = ? " +
                "where ID = ?; ";

        try (Connection c = getConnection()) {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, consulta.getIdPaciente());
            pstm.setInt(2, consulta.getCrmMedico());
            pstm.setInt(3, consulta.getIdPlanoDeSaude());
            pstm.setString(4, consulta.getSala());
            pstm.setDate(5, DateTimeHelper.toDate(consulta.getDataDaConsulta()));
            pstm.setTime(6, DateTimeHelper.toTime(consulta.getHoraDaConsulta()));
            pstm.setInt(7, consulta.getId());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Consulta> listarTodos() {
        List<Consulta> listaDeConsultas = new ArrayList<Consulta>();

        try (Connection c = getConnection()) {
            PreparedStatement pst = c.prepareStatement("select * from CONSULTA; ");
            ResultSet list = pst.executeQuery();
            while (list.next()) {
                // ID,ID_PACIENTE,CRM_MEDICO,ID_PLANO_DE_SAUDE,SALA,DATA_DA_CONSULTA,HORA_DA_CONSULTA
                Consulta consulta = new Consulta();
                consulta.setId(list.getInt("ID"));
                consulta.setIdPaciente(list.getInt("ID_PACIENTE"));
                consulta.setCrmMedico(list.getInt("CRM_MEDICO"));
                consulta.setIdPlanoDeSaude(list.getInt("ID_PLANO_DE_SAUDE"));
                consulta.setSala(list.getString("SALA"));
                consulta.setDataDaConsulta(DateTimeHelper.toLocalDate(list.getDate("DATA_DA_CONSULTA")));
                consulta.setHoraDaConsulta(DateTimeHelper.toLocalTime(list.getTime("HORA_DA_CONSULTA")));
                listaDeConsultas.add(consulta);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listaDeConsultas;
    }

}
