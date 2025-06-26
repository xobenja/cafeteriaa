package cl.prueba.producto.dto;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="producto_messiRonaldo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


public class ProductoDTO {
    @Id
    @Column(name="id_producto")
    private int idProducto;
    private String nombre; // que es?
    private String categoriaProducto; // ah que categoria pertenece
    private String descripcionDetalle; // detalle completo del producto
    private int precio; // precio, solo trabajamos con numeros enteros
}
