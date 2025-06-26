package cl.prueba.pedido.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.prueba.pedido.Service.IPedidoService;
import cl.prueba.pedido.dto.PedidoDTO;

@RestController
@RequestMapping("/api/crud/pedido")
public class PedidoController {

    @Autowired
    IPedidoService servicio;

    @GetMapping
    public List<PedidoDTO> getAll(){
        return servicio.getTodosPedidos();
    }
    @PostMapping//Añadir
    public PedidoDTO insePediDto(@RequestBody PedidoDTO pedido){
        return servicio.insertarPedidos(pedido);
    }
    @GetMapping("/{id}")//Mostrar
    public PedidoDTO getById(@PathVariable Long id){
        return servicio.getProductoById(id);
    }
    @PutMapping("/{id}")//Modificar
    public PedidoDTO deleteById(@PathVariable Integer id,@RequestBody PedidoDTO pedido){
        pedido.setIdPedidos(id);
        return servicio.actualizarPedido(pedido);
    }

    @DeleteMapping("/{id}")//Eliminar
    public boolean deleteById(@PathVariable Integer id){
        return servicio.eliminarPedido(id);
    }


}
