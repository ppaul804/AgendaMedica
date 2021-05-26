
package Entidades;

import java.util.Date;
import lombok.*;

@Setter
@Getter
public class Usuario {
    
    private int id;
    private String cpf;
    private String nome;
    private String username;
    private String senha;
    private int codigoPerfil;
    private String telefone;
    private String matricula;
    private Date dataNascimento;
}
