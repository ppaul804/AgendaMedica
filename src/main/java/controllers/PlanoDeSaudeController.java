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
        // REGRA 01 - CPF NÃO PODE SER NULO
        if (planoDeSaude.getCodigoPlano() == null || planoDeSaude.getCodigoPlano().equals(""))
            mensagensDeErro.append("O CodigoPlano deve ser preenchido! \n");

        // REGRA 02 - CPF ÚNICO
        if (planoDeSaude.getOperadora() == null || planoDeSaude.getOperadora().equals(""))
        mensagensDeErro.append("O Operadora deve ser preenchido! \n");
        
        // REGRA 03 - USERNAME NÃO PODE SER NULO OU SEM PREENCHIMENTO
        if (planoDeSaude.getTelefone() == null || planoDeSaude.getTelefone().equals(""))
        mensagensDeErro.append("O USERNAME deve ser preenchido! \n");
        
        // REGRA 04 - USERNAME NÃO PODE TER MAIS DE 8 CARACTERES
        if (planoDeSaude.getEndereco() == null || planoDeSaude.getEndereco().equals(""))
            mensagensDeErro.append("O USERNAME deve ter no máximo 08 caracteres \n");

        // REGRA 05 - USERNAME NÃO PODE TER MENOS DE 3 CARACTERES
        if (planoDeSaude.getRegistroAns() == null || planoDeSaude.getRegistroAns().equals(""))
            mensagensDeErro.append("O USERNAME deve ter no mímimo 03 caracteres \n");
            
        if (mensagensDeErro.length() != 0) {
            JOptionPane.showMessageDialog(null, mensagensDeErro.toString(), "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
