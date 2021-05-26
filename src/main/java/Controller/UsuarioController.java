package Controller;

import Entidades.Usuario;
import Persistencia.UsuarioDAO;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioController {
    
    StringBuilder mensagensDeErro = new StringBuilder();
    UsuarioDAO usuarioDao = new UsuarioDAO();
    
    public void cadastrarUsuario(Usuario usuario) throws SQLException {
        
        usuario.setCodigoPerfil(102);
        
        usuario.setMatricula("2532");
        
        if (validarDadosDeTela(usuario)) {
            
            usuarioDao.salvar(usuario);
            
        }
        
    }
    
    private boolean validarDadosDeTela(Usuario usuario) throws SQLException {

        // REGRA 01 - CPF NÃO PODE SER NULO 
        if (usuario.getCpf() == null || usuario.getCpf().equals("")) {
            
            mensagensDeErro.append("O CPF deve ser preenchido! \n");
        } else {

            // REGRA 02 - CPF ÚNICO
            for (Usuario usuarioBD : usuarioDao.listarTodos()) {
                
                if (usuarioBD.equals(usuario.getCpf())) {
                    mensagensDeErro.append("O CPF informado já está cadastrado !");
                }
                
            }
            
        }

        //  REGRA 03 - USERNAME NÃO PODE SER NULO OU SEM PREENCHIMENTO
        if (usuario.getUsername() == null || usuario.getUsername().equals("")) {
            mensagensDeErro.append("O USERNAME deve ser preenchido! \n");
            
        } else {

            // REGRA 04 - USERNAME NÃO PODE TER MAIS DE 8 CARACTERES
            if (usuario.getUsername().length() > 8) {
                
                mensagensDeErro.append("O USERNAME deve ter no máximo 08 caracteres \n");
            }

            // REGRA 05 - USERNAME NÃO PODE TER MENOS DE 3 CARACTERES
            if (usuario.getUsername().length() < 3) {
                mensagensDeErro.append("O USERNAME deve ter no mímimo 03 caracteres \n");
            }

            // REGRA 06 - USERNAME NÃO PODE EXISTIR NO BANCO        
            if (usuarioDao.existeUsername(usuario.getUsername())) {
                mensagensDeErro.append("O USERNAME ");
                mensagensDeErro.append(usuario.getUsername());
                mensagensDeErro.append(" já existe na base de dados! Insira um Username diferente! \n");
                
            }
            
        }
        
        if (mensagensDeErro.length() != 0) {
            
            JOptionPane.showMessageDialog(null, mensagensDeErro.toString());
            
            return false;
            
        }

        return true;
        
    }
}
