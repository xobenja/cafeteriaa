package cl.prueba.cliente.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="cliente_messiRonaldo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ClienteDTO {

    @Id
    @Column(name="id_cliente")
    private int idCliente;

    private String nombre;
    private String apellido;
    @Column(unique = true, nullable = false, length = 12)
    private String rut; // Ejemplo de RUT: 12345678-9
} 