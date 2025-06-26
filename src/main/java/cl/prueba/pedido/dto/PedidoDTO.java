package cl.prueba.pedido.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name="pedidos_messiRonaldo")
public class PedidoDTO {

    @Id
    @Column(name="id_pedido")
    private int idPedidos;
}
