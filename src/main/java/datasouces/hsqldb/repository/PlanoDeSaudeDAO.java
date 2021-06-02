package datasouces.hsqldb.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import datasouces.hsqldb.config.ConexaoBD;
import datasouces.hsqldb.models.PlanoDeSaude;

public class PlanoDeSaudeDAO extends ConexaoBD implements InterfaceDAO<PlanoDeSaude> {

    @Override
    public void salvar(PlanoDeSaude planoDeSaude) {
        String sql = "insert into PLANO_DE_SAUDE (CODIGO_PLANO, OPERADORA, TELEFONE, ENDERECO, REGISTRO_ANS) " +
                "values (?, ?, ?, ?, ?); ";

        try (Connection c = getConnection()) {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, planoDeSaude.getCodigoPlano());
            pstm.setString(2, planoDeSaude.getOperadora());
            pstm.setString(3, planoDeSaude.getTelefone());
            pstm.setString(4, planoDeSaude.getEndereco());
            pstm.setString(5, planoDeSaude.getRegistroAns());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deletar(PlanoDeSaude planoDeSaude) {
        String sql = "DELETE FROM PLANO_DE_SAUDE WHERE ID = ?";
        try (Connection c = getConnection()) {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, planoDeSaude.getId());
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public PlanoDeSaude buscarPorId(int id) {
        PlanoDeSaude planoDeSaude = new PlanoDeSaude();
        try (Connection c = getConnection()) {
            PreparedStatement pstm = c.prepareStatement("SELECT * FROM PLANO_DE_SAUDE WHERE ID = ?");
            pstm.setInt(1, id);
            ResultSet list = pstm.executeQuery();
            while (list.next()) {
                if (list.getInt("ID") == id) {
                    planoDeSaude.setId(list.getInt("ID"));
                    planoDeSaude.setCodigoPlano(list.getString("CODIGO_PLANO"));
                    planoDeSaude.setOperadora(list.getString("OPERADORA"));
                    planoDeSaude.setTelefone(list.getString("TELEFONE"));
                    planoDeSaude.setEndereco(list.getString("ENDERECO"));
                    planoDeSaude.setRegistroAns(list.getString("REGISTRO_ANS"));
                    return planoDeSaude;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void atualizar(PlanoDeSaude planoDeSaude) {
        String sql = "update PLANO_DE_SAUDE " +
                "set CODIGO_PLANO = ?, " +
                "    OPERADORA    = ?, " +
                "    TELEFONE     = ?, " +
                "    ENDERECO     = ?, " +
                "    REGISTRO_ANS = ?, " +
                "    where ID = ?; ";

        try (Connection c = getConnection()) {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, planoDeSaude.getCodigoPlano());
            pstm.setString(2, planoDeSaude.getOperadora());
            pstm.setString(3, planoDeSaude.getTelefone());
            pstm.setString(4, planoDeSaude.getEndereco());
            pstm.setString(5, planoDeSaude.getRegistroAns());
            pstm.setInt(6, planoDeSaude.getId());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<PlanoDeSaude> listarTodos() {
        List<PlanoDeSaude> listaDePlanoDeSaudes = new ArrayList<PlanoDeSaude>();

        try (Connection c = getConnection()) {
            PreparedStatement pst = c.prepareStatement("SELECT * FROM PLANO_DE_SAUDE");
            ResultSet list = pst.executeQuery();
            while (list.next()) {
                PlanoDeSaude planoDeSaude = new PlanoDeSaude();
                planoDeSaude.setId(list.getInt("ID"));
                planoDeSaude.setCodigoPlano(list.getString("CODIGO_PLANO"));
                planoDeSaude.setOperadora(list.getString("OPERADORA"));
                planoDeSaude.setTelefone(list.getString("TELEFONE"));
                planoDeSaude.setEndereco(list.getString("ENDERECO"));
                planoDeSaude.setRegistroAns(list.getString("REGISTRO_ANS"));
                listaDePlanoDeSaudes.add(planoDeSaude);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listaDePlanoDeSaudes;
    }

    public int buscarPorCodigoPlano(String codigoPlano) {
        PlanoDeSaude planoDeSaude = new PlanoDeSaude();
        try (Connection c = getConnection()) {
            PreparedStatement pstm = c.prepareStatement("SELECT * FROM PLANO_DE_SAUDE WHERE CODIGO_PLANO = ?");
            pstm.setString(1, codigoPlano);
            ResultSet list = pstm.executeQuery();
            while (list.next()) {
                if (list.getString("CODIGO_PLANO").equals(codigoPlano)) {
                    planoDeSaude.setId(list.getInt("ID"));
                    planoDeSaude.setCodigoPlano(list.getString("CODIGO_PLANO"));
                    planoDeSaude.setOperadora(list.getString("OPERADORA"));
                    planoDeSaude.setTelefone(list.getString("TELEFONE"));
                    planoDeSaude.setEndereco(list.getString("ENDERECO"));
                    planoDeSaude.setRegistroAns(list.getString("REGISTRO_ANS"));
                    return planoDeSaude.getId();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

}
