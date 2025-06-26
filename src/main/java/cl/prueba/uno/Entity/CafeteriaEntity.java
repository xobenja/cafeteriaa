package cl.prueba.uno.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cafeteria_messiRonaldo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CafeteriaEntity {
    @Id
    @Column(name = "id_cafeteria")
    private int idCafeteria;

    @Column(name = "nombre_local")
    private String nombreLocal;
}
