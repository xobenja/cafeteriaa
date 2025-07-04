package cl.prueba.empleado.Entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import cl.prueba.uno.Entity.CafeteriaEntity;
import lombok.*;

@Entity
@Table(name = "Empleados_messiRonaldo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empleado_seq")
    @SequenceGenerator(name = "empleado_seq", sequenceName = "seq_empleados", allocationSize = 1)
    @Column(name = "id_Empleados")
    private Integer idEmpleado;

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

    @ManyToOne
    @JoinColumn(name = "idCafeteria")
    private CafeteriaEntity idCafeteria;
    
    //@JsonBackReference  // Para evitar ciclos infinitos en JSON
}
