package controllers;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import datasouces.hsqldb.models.Usuario;
import datasouces.hsqldb.repository.UsuarioDAO;

public class UsuarioController {

    StringBuilder mensagensDeErro = new StringBuilder();
    UsuarioDAO usuarioDao = new UsuarioDAO();

    public void cadastrarUsuario(Usuario usuario) throws SQLException {
        if (validarDadosDeTela(usuario))
            usuarioDao.salvar(usuario);
    }

    private boolean validarDadosDeTela(Usuario usuario) throws SQLException {
        // REGRA 01 - CPF NÃO PODE SER NULO
        if (usuario.getCpf() == null || usuario.getCpf().equals(""))
            mensagensDeErro.append("O CPF deve ser preenchido! \n");

        // REGRA 02 - CPF ÚNICO
        if (usuarioDao.buscarPorCpf(usuario.getCpf()) != null)
            mensagensDeErro.append("O CPF já consta no banco! \n");

        // REGRA 03 - USERNAME NÃO PODE SER NULO OU SEM PREENCHIMENTO
        if (usuario.getUsername() == null || usuario.getUsername().equals(""))
            mensagensDeErro.append("O USERNAME deve ser preenchido! \n");

        // REGRA 04 - USERNAME NÃO PODE TER MAIS DE 8 CARACTERES
        if (usuario.getUsername().length() > 8)
            mensagensDeErro.append("O USERNAME deve ter no máximo 08 caracteres \n");

        // REGRA 05 - USERNAME NÃO PODE TER MENOS DE 3 CARACTERES
        if (usuario.getUsername().length() < 3)
            mensagensDeErro.append("O USERNAME deve ter no mímimo 03 caracteres \n");
            
        // REGRA 06 - USERNAME NÃO PODE EXISTIR NO BANCO
        if (usuarioDao.existeUsername(usuario.getUsername())) {
            mensagensDeErro.append("O USERNAME ");
            mensagensDeErro.append(usuario.getUsername());
            mensagensDeErro.append(" já existe na base de dados! Insira um Username diferente! \n");
        }

        // REGRA 07 - SENHA MAIOR QUE 5 CARACTERES
        if (usuario.getSenha().length() < 5)
            mensagensDeErro.append("A SENHA deve ter no mímimo 05 caracteres \n");

        if (mensagensDeErro.length() != 0) {
            JOptionPane.showMessageDialog(null, mensagensDeErro.toString(), "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
