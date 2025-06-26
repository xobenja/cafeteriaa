package cl.prueba.pedido.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.prueba.pedido.Repository.IPedidoRepository;
import cl.prueba.pedido.Service.IPedidoService;
import cl.prueba.pedido.dto.PedidoDTO;

@Service
public class PedidoService implements IPedidoService{

    @Autowired
    IPedidoRepository xd;


    @Override
    public List<PedidoDTO> getTodosPedidos() {
        return (List<PedidoDTO>) xd.findAll();
    }

    @Override
    public PedidoDTO insertarPedidos(PedidoDTO pedido) {
        return xd.save(pedido);
    }

    @Override
    public PedidoDTO getProductoById(Long id) {
        return xd.findById(id.intValue()).orElse(null);
    }

    @Override
    public PedidoDTO actualizarPedido(PedidoDTO pedido) {
        return xd.save(pedido);
    }

    @Override
    public boolean eliminarPedido(Integer id) {
        try {
            xd.deleteById(id);
            return true;
            // catch es si algo falla (por ejemplo, no existe el producto), captura la excepcion y devuelve false.
        } catch (Exception error) { //} catch (Exception error) { //error.printStackTrace(); // Imprime el error en consola //return false; //}
            return false;
        }
    }

    



}
