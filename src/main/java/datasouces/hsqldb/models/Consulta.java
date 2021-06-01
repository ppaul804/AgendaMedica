
package datasouces.hsqldb.models;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Consulta {

    private int id;
    private int idPaciente;
    private int crmMedico;
    private int idPlanoDeSaude;
    private String sala;
    private LocalDate dataDaConsulta;
    private LocalTime horaDaConsulta;

}
