package cl.prueba.cliente.Controller;

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

import cl.prueba.cliente.Service.IClienteService;
import cl.prueba.cliente.dto.ClienteDTO;

@RestController
@RequestMapping("/api/crud/cliente")
public class ClienteController {
    @Autowired
    IClienteService Servicio;

    @GetMapping
    public List<ClienteDTO> getAll(){
        return Servicio.getTodosClientes();
    }
    @PostMapping//Añadir
    public ClienteDTO inseClienteDTO(@RequestBody ClienteDTO cliente){
        return Servicio.insertarCliente(cliente);
    }
    @GetMapping("/{id}")//Mostrar
    public ClienteDTO getById(@PathVariable Long id){
        return Servicio.getClienteById(id);
    }
    @PutMapping("/{id}")//Modificar
    public ClienteDTO deleteById(@PathVariable Integer id,@RequestBody ClienteDTO cliente){
        cliente.setIdCliente(id);
        return Servicio.actualizarCliente(cliente);
    }

    @DeleteMapping("/{id}")//Eliminar
    public boolean deleteById(@PathVariable Integer id){
        return Servicio.eliminarCliente(id);
    }

}
