package controllers;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import datasouces.hsqldb.models.Consulta;
import datasouces.hsqldb.repository.ConsultaDAO;

public class ConsultaController {

    StringBuilder mensagensDeErro = new StringBuilder();
    ConsultaDAO consultaDao = new ConsultaDAO();

    public void cadastrarConsulta(Consulta consulta) throws SQLException {
        if (validarDadosDeTela(consulta))
            consultaDao.salvar(consulta);
    }

    private boolean validarDadosDeTela(Consulta consulta) throws SQLException {
        // REGRA 05 - NÃO EXISTE DUAS CONSULTA NO MESMO DIA E HORÁRIO
        if (consultaDao.existeDataEHora(consulta))
            mensagensDeErro.append("DIA e HORÁRIO já marcado! \n");

        if (mensagensDeErro.length() != 0) {
            JOptionPane.showMessageDialog(null, mensagensDeErro.toString(), "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
