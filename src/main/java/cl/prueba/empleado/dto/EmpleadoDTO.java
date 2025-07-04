package cl.prueba.empleado.dto;

import cl.prueba.uno.dto.CafeteriaDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoDTO {

    private Integer idEmpleado;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String rut;
    private String telefono;
    private CafeteriaDTO idCafeteria;

   public EmpleadoDTO(Integer idEmpleado, String nombre, String apellidoP, String apellidoM, String rut, String telefono) {
    this.idEmpleado = idEmpleado;
    this.nombre = nombre;
    this.apellidoP = apellidoP;
    this.apellidoM = apellidoM;
    this.rut = rut;
    this.telefono = telefono;
    this.idCafeteria = idCafeteria;  // siempre null, no la queremos en la respuesta
}
}
