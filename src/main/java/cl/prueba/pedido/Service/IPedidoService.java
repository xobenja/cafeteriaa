package cl.prueba.pedido.Service;

import java.util.List;

import cl.prueba.pedido.dto.PedidoDTO;

public interface IPedidoService {

    List<PedidoDTO> getTodosPedidos();

    PedidoDTO insertarPedidos(PedidoDTO pedido);

    PedidoDTO getProductoById(Long id);

    PedidoDTO actualizarPedido(PedidoDTO pedido);

    boolean eliminarPedido(Integer id);

}
