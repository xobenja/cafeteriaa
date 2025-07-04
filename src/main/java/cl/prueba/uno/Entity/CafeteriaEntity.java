package cl.prueba.uno.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
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
    @OneToMany(mappedBy = "idCafeteria", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference  // Para evitar ciclos infinitos en JSON
    private List<EmpleadoEntity> empleados = new ArrayList<>();

    public CafeteriaEntity(int idCafeteria, String nombreLocal) {
        this.idCafeteria = idCafeteria;
        this.nombreLocal = nombreLocal;
        this.empleados = new ArrayList<>(); // Inicializa la lista de empleados
    }
}
