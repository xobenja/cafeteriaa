package cl.prueba.uno.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import cl.prueba.empleado.dto.EmpleadoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)

public class CafeteriaDTO {
    private int idCafeteria;
    private String nombreLocal;
    private List<EmpleadoDTO> empleado;

    public CafeteriaDTO(Integer idCafeteria, String nombreLocal, List<EmpleadoDTO> empleado) {
    this.idCafeteria = idCafeteria;
    this.nombreLocal = nombreLocal;
    this.empleado = empleado;
}
    public CafeteriaDTO(int idCafeteria, String nombreLocal) {
    this.idCafeteria = idCafeteria;
    this.nombreLocal = nombreLocal;
    this.empleado = new ArrayList<>();  // o new ArrayList<>()
}

}
