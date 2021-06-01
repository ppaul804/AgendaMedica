package controllers;

import java.math.BigDecimal;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import datasouces.hsqldb.models.Medico;
import datasouces.hsqldb.repository.MedicoDAO;

public class MedicoController {

    StringBuilder mensagensDeErro = new StringBuilder();
    MedicoDAO medicoDao = new MedicoDAO();

    public void cadastrarMedico(Medico medico) throws SQLException {
        if (validarDadosDeTela(medico))
            medicoDao.salvar(medico);
    }

    private boolean validarDadosDeTela(Medico medico) throws SQLException {
        // REGRA 01 - NOME NÃO PODE SER NULO
        if (medico.getNome() == null || medico.getNome().equals(""))
            mensagensDeErro.append("O NOME deve ser preenchido! \n");
        
        // REGRA 01 - ESPECIALIDADE NÃO PODE SER NULO
        if (medico.getEspecialidade() == null || medico.getEspecialidade().equals(""))
            mensagensDeErro.append("O ESPECIALIDADE deve ser preenchido! \n");

        // REGRA 02 - SALARIO MAIOR QUE ZERO
        if (medico.getSalario().compareTo(BigDecimal.ZERO) < 0)
            mensagensDeErro.append("O SALARIO deve ser maior que zero! \n");

        if (mensagensDeErro.length() != 0) {
            JOptionPane.showMessageDialog(null, mensagensDeErro.toString(), "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
