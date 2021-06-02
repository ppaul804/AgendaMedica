package controllers;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import datasouces.hsqldb.models.PlanoDeSaude;
import datasouces.hsqldb.repository.PlanoDeSaudeDAO;

public class PlanoDeSaudeController {

    StringBuilder mensagensDeErro = new StringBuilder();
    PlanoDeSaudeDAO planoDeSaudeDao = new PlanoDeSaudeDAO();

    public void cadastrarPlanoDeSaude(PlanoDeSaude planoDeSaude) throws SQLException {
        if (validarDadosDeTela(planoDeSaude))
            planoDeSaudeDao.salvar(planoDeSaude);
    }

    private boolean validarDadosDeTela(PlanoDeSaude planoDeSaude) throws SQLException {
        // REGRA 01 - CODIGO PLANO NÃO PODE SER NULO
        if (planoDeSaude.getCodigoPlano() == null || planoDeSaude.getCodigoPlano().equals(""))
            mensagensDeErro.append("O CODIGO PLANO deve ser preenchido! \n");

        // REGRA 02 - O OPERADORA DEVE SER PREENCHIDO
        if (planoDeSaude.getOperadora() == null || planoDeSaude.getOperadora().equals(""))
        mensagensDeErro.append("O Operadora deve ser preenchido! \n");
        
        // REGRA 03 - TELEFONE NÃO PODE SER NULO OU SEM PREENCHIMENTO
        if (planoDeSaude.getTelefone() == null || planoDeSaude.getTelefone().equals(""))
        mensagensDeErro.append("TELEFONE não pode ser nulo ou sem preenchimento! \n");
        
        // REGRA 04 - ENDERECO NÃO PODE SER NULO OU SEM PREENCHIMENTO
        if (planoDeSaude.getEndereco() == null || planoDeSaude.getEndereco().equals(""))
            mensagensDeErro.append("ENDERECO não pode ser nulo ou sem preenchimento \n");

        // REGRA 05 - REGISTRO ANS NÃO PODE SER NULO OU SEM PREENCHIMENTO
        if (planoDeSaude.getRegistroAns() == null || planoDeSaude.getRegistroAns().equals(""))
            mensagensDeErro.append("REGISTRO ANS não pode ser nulo ou sem preenchimento \n");
            
        if (mensagensDeErro.length() != 0) {
            JOptionPane.showMessageDialog(null, mensagensDeErro.toString(), "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
