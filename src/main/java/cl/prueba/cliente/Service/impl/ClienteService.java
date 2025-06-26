package cl.prueba.cliente.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.prueba.cliente.Repository.IClienteRepository;
import cl.prueba.cliente.Service.IClienteService;
import cl.prueba.cliente.dto.ClienteDTO;

@Service
public class ClienteService implements IClienteService{
    @Autowired
    IClienteRepository west;
    



    @Override
    public ClienteDTO insertarCliente(ClienteDTO cliente) {
        return west.save(cliente);
    }




    @Override
    public List<ClienteDTO> getTodosClientes() {
        return(List<ClienteDTO>)west.findAll();
    }




    @Override
    public ClienteDTO getClienteById(Long id) {
        return west.findById(id.intValue()).get();
    }




    @Override
    public ClienteDTO actualizarCliente(ClienteDTO cliente) {
        return west.save(cliente);
    }




    @Override
    public boolean eliminarCliente(Integer id) {
        west.deleteById(id);
        return true;
    }

}
