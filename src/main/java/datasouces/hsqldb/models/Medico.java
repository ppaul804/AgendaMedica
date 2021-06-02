
package datasouces.hsqldb.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Medico {

    private int crm;
    private String nome;
    private String especialidade;
    private char sexo;
    private LocalDate dataDeNascimento;
    private BigDecimal salario;

}
