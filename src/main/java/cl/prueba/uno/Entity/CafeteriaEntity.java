package cl.prueba.uno.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import cl.prueba.empleado.Entity.EmpleadoEntity;

@Entity
@Table(name = "cafeteriaZ")
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

    // Relación OneToMany con EmpleadoEntity
    @OneToMany(mappedBy = "cafeteria", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference  // Para evitar ciclos infinitos en JSON
    private List<EmpleadoEntity> empleados;
}
