package cl.prueba.mesasCafeteria.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mesas_messiRonaldo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MesaCafeteriaEntity {

    @Id
    @Column(name = "id_mesaCafeteria")
    private int idMesaCafeteria;

    @Column(name = "disponibilidad")
    private String disponibilidad;
}