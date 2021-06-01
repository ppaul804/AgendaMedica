package datasouces.hsqldb.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import datasouces.hsqldb.config.ConexaoBD;
import datasouces.hsqldb.models.Perfil;

public class PerfilDAO extends ConexaoBD implements InterfaceDAO<Perfil> {

    @Override
    public void salvar(Perfil perfil) {
        String sql = "INSERT INTO PERFIL ("
                + "CODIGO,"
                + "NOME,"
                + "DESCRICAO) VALUES (?,?,?);";
        
        try (Connection c = getConnection()) {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, perfil.getCodigo());
            pstm.setString(2, perfil.getNome());
            pstm.setString(3, perfil.getDescricao());
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deletar(Perfil perfil) {
        String sql = "DELETE FROM PERFIL WHERE CODIGO = ?";
        try (Connection c = getConnection()) {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, perfil.getCodigo());
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Perfil buscarPorId(int id) {
        Perfil perfil = new Perfil();
        try (Connection c = getConnection()) {
            PreparedStatement pstm = c.prepareStatement("SELECT * FROM PERFIL WHERE CODIGO = ?");
            pstm.setInt(1, id);
            ResultSet list = pstm.executeQuery();
            while (list.next()) {
                if (list.getInt("CODIGO") == id) {
                    perfil.setCodigo(list.getInt("CODIGO"));
                    perfil.setNome(list.getString("NOME"));
                    perfil.setDescricao(list.getString("DESCRICAO"));
                    return perfil;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void atualizar(Perfil perfil) {
        String sql = "UPDATE PERFIL SET "
                + "NOME = ?,"
                + "DESCRICAO = ?"
                + "WHERE CODIGO = ?";

        try (Connection c = getConnection()) {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, perfil.getNome());
            pstm.setString(2, perfil.getDescricao());
            pstm.setInt(3, perfil.getCodigo());
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Perfil> listarTodos() {
        List<Perfil> listaDePerfis = new ArrayList<>();

        try (Connection c = getConnection()) {
            PreparedStatement pstm = c.prepareStatement("SELECT * FROM PERFIL ;");
            ResultSet linhasDaTabelas = pstm.executeQuery();
            while (linhasDaTabelas.next()) {                
                Perfil perfil = new Perfil();
                perfil.setCodigo(linhasDaTabelas.getInt("CODIGO"));
                perfil.setNome(linhasDaTabelas.getString("NOME"));
                perfil.setDescricao(linhasDaTabelas.getString("DESCRICAO"));
                listaDePerfis.add(perfil);
            }
        } catch (Exception e) {
            System.out.println();
        }
        return listaDePerfis;
    }

}
