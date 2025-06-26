package cl.prueba.cliente.Service;

import java.util.List;

import cl.prueba.cliente.dto.ClienteDTO;

public interface IClienteService {
    ClienteDTO insertarCliente (ClienteDTO cliente);

    List<ClienteDTO> getTodosClientes();

    ClienteDTO getClienteById(Long id);

    ClienteDTO actualizarCliente(ClienteDTO cliente);

    boolean eliminarCliente(Integer id);

    

}
