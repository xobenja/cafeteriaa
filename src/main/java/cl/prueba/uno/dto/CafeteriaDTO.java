package cl.prueba.uno.dto;

import java.util.List;

import cl.prueba.empleado.dto.EmpleadoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CafeteriaDTO {
    private int idCafeteria;
    private String nombreLocal;
    private List<EmpleadoDTO> empleado;

    public CafeteriaDTO(Integer idCafeteria, String nombreLocal, List<EmpleadoDTO> empleado) {
    this.idCafeteria = idCafeteria;
    this.nombreLocal = nombreLocal;
    this.empleado = empleado;
}
}
