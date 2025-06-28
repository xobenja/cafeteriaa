package cl.prueba.empleado.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoDTO {

    private int idEmpleado;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String rut;
    private String telefono;
}
