package cl.prueba.empleado.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Empleados_messiRonaldo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoEntity {

    @Id
    @Column(name = "id_Empleados")
    private int idEmpleado;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidoP")
    private String apellidoP;

    @Column(name = "apellidoM")
    private String apellidoM;

    @Column(name = "rut")
    private String rut;

    @Column(name = "telefono")
    private String telefono;
}