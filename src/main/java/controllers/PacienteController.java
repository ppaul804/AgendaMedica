package controllers;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import datasouces.hsqldb.models.Paciente;
import datasouces.hsqldb.repository.PacienteDAO;

public class PacienteController {

    StringBuilder mensagensDeErro = new StringBuilder();
    PacienteDAO pacienteDao = new PacienteDAO();

    public void cadastrarPaciente(Paciente paciente) throws SQLException {
        if (validarDadosDeTela(paciente))
            pacienteDao.salvar(paciente);
    }

    private boolean validarDadosDeTela(Paciente paciente) throws SQLException {
        // REGRA 01 - CPF NÃO PODE SER NULO
        if (paciente.getCpf() == null || paciente.getCpf().equals(""))
            mensagensDeErro.append("O CPF deve ser preenchido! \n");

        // REGRA 02 - CPF ÚNICO
        if (pacienteDao.buscarPorCpf(paciente.getCpf()) != null)
            mensagensDeErro.append("O CPF já consta no banco! \n");

        // REGRA 03 - NOME NÃO PODE SER NULO OU SEM PREENCHIMENTO
        if (paciente.getNome() == null || paciente.getNome().equals(""))
            mensagensDeErro.append("O NOME deve ser preenchido! \n");

        // REGRA 04 - TELEFONE NÃO PODE SER NULO OU SEM PREENCHIMENTO
        if (paciente.getTelefone() != null || paciente.getTelefone().equals(""))
            mensagensDeErro.append("O USERNAME deve ter no máximo 08 caracteres \n");

            // REGRA 04 - ENDEREÇO NÃO PODE SER NULO OU SEM PREENCHIMENTO
        if (paciente.getEndereco() != null || paciente.getEndereco().equals(""))
            mensagensDeErro.append("O ENDEREÇO deve ter no máximo 08 caracteres \n");

        if (mensagensDeErro.length() != 0) {
            JOptionPane.showMessageDialog(null, mensagensDeErro.toString(), "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
