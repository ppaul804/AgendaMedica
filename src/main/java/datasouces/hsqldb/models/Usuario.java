
package datasouces.hsqldb.models;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

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
    private LocalDate dataNascimento;
}
