
package datasouces.hsqldb.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PlanoDeSaude {

    private int id;
    private String codigoPlano;
    private String operadora;
    private String telefone;
    private String endereco;
    private String registroAns;

}
