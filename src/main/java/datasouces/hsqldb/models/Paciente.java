
package datasouces.hsqldb.models;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Paciente {

    private int id;
    private String cpf;
    private String nome;
    private String telefone;
    private LocalDate dataDeNascimento;
    private String endereco;
    private char sexo;

}
