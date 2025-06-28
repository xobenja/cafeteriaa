package cl.prueba.producto.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "producto_messiRonaldo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductoEntity {
    @Id
    @Column(name = "id_producto")
    private int idProducto;

    private String nombre;
    private String categoriaProducto;
    private String descripcionDetalle;
    private int precio;
}