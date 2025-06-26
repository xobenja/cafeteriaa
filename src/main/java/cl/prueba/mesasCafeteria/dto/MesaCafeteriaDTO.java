package cl.prueba.mesasCafeteria.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="mesas_messiRonaldo")

public class MesaCafeteriaDTO {

    @Id
    @Column(name="id_mesaCafeteria")
    private int idMesas;
    private String disponibilidad;
    

    
    

}
