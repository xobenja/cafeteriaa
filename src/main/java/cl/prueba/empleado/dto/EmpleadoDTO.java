package cl.prueba.empleado.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Empleados_messiRonaldo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


public class EmpleadoDTO {
    @Id
    @Column(name="id_Empleados")
    private int idEmpleado;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String rut;
    private String telefono;
}




//caja de informacion