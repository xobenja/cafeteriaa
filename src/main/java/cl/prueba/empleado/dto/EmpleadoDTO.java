package cl.prueba.empleado.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import cl.prueba.uno.dto.CafeteriaDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class EmpleadoDTO {

    private Integer idEmpleado;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String rut;
    private String telefono;
    private CafeteriaDTO idCafeteria;

}

