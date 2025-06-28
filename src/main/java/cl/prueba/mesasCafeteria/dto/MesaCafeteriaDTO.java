package cl.prueba.mesasCafeteria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MesaCafeteriaDTO {
    private int idMesas;
    private String disponibilidad;
}