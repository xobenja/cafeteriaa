package cl.prueba.cliente.Service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.prueba.cliente.dto.ClienteDTO;
import cl.prueba.cliente.Entity.ClienteEntity;
import cl.prueba.cliente.Repository.IClienteRepository;
import cl.prueba.cliente.Service.IClienteService;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository repository;

    private ClienteDTO entityToDTO(ClienteEntity entity) {
        return new ClienteDTO(
            entity.getIdCliente(),
            entity.getNombre(),
            entity.getApellido(),
            entity.getRut()
        );
    }

    private ClienteEntity dtoToEntity(ClienteDTO dto) {
        return new ClienteEntity(
            dto.getIdCliente(),
            dto.getNombre(),
            dto.getApellido(),
            dto.getRut()
        );
    }

    @Override
    public ClienteDTO insertarCliente(ClienteDTO dto) {
        ClienteEntity entity = dtoToEntity(dto);
        ClienteEntity saved = repository.save(entity);
        return entityToDTO(saved);
    }

    @Override
    public List<ClienteDTO> getTodosClientes() {
        List<ClienteEntity> entities = (List<ClienteEntity>) repository.findAll();
        return entities.stream().map(this::entityToDTO).collect(Collectors.toList());
    }

    @Override
    public ClienteDTO getClienteById(Long id) {
        ClienteEntity entity = repository.findById(id.intValue()).orElse(null);
        return entity != null ? entityToDTO(entity) : null;
    }

    @Override
    public ClienteDTO actualizarCliente(ClienteDTO dto) {
        ClienteEntity entity = dtoToEntity(dto);
        ClienteEntity updated = repository.save(entity);
        return entityToDTO(updated);
    }

    @Override
    public boolean eliminarCliente(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}