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
        // REGRA 05 - ID PLANO DE SAUDE MENOR QUE ZERO
        if (consulta.getIdPlanoDeSaude() <= 0)
            mensagensDeErro.append("O ID PLANO DE SAUDE é um número inválido! \n");

        // REGRA 05 - ID PACIENTE MENOR QUE ZERO
        if (consulta.getIdPlanoDeSaude() <= 0)
            mensagensDeErro.append("O ID PACIENTE é um número inválido! \n");

        // REGRA 05 - CRM MÉDICO MENOR QUE ZERO
        if (consulta.getIdPlanoDeSaude() <= 0)
            mensagensDeErro.append("O CRM MÉDICO é um número inválido! \n");

        if (mensagensDeErro.length() != 0) {
            JOptionPane.showMessageDialog(null, mensagensDeErro.toString(), "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
