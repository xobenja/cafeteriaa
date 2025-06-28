package cl.prueba.empleado.Service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.prueba.empleado.dto.EmpleadoDTO;
import cl.prueba.empleado.Entity.EmpleadoEntity;
import cl.prueba.empleado.Repository.IEmpleadoRepository;
import cl.prueba.empleado.Service.IEmpleadoService;

@Service
public class EmpleadoService implements IEmpleadoService {

    @Autowired
    private IEmpleadoRepository repository;

    // Conversión Entity -> DTO
    private EmpleadoDTO entityToDTO(EmpleadoEntity entity) {
        return new EmpleadoDTO(
            entity.getIdEmpleado(),
            entity.getNombre(),
            entity.getApellidoP(),
            entity.getApellidoM(),
            entity.getRut(),
            entity.getTelefono()
        );
    }

    // Conversión DTO -> Entity
    private EmpleadoEntity dtoToEntity(EmpleadoDTO dto) {
        return new EmpleadoEntity(
            dto.getIdEmpleado(),
            dto.getNombre(),
            dto.getApellidoP(),
            dto.getApellidoM(),
            dto.getRut(),
            dto.getTelefono()
        );
    }

    @Override
    public EmpleadoDTO insertarEmpleados(EmpleadoDTO dto) {
        EmpleadoEntity entity = dtoToEntity(dto);
        EmpleadoEntity saved = repository.save(entity);
        return entityToDTO(saved);
    }

    @Override
    public List<EmpleadoDTO> getTodosEmpleados() {
        List<EmpleadoEntity> entities = (List<EmpleadoEntity>) repository.findAll();
        return entities.stream().map(this::entityToDTO).collect(Collectors.toList());
    }

    @Override
    public EmpleadoDTO getEmpleadosById(Long id) {
        EmpleadoEntity entity = repository.findById(id.intValue()).orElse(null);
        return entity != null ? entityToDTO(entity) : null;
    }

    @Override
    public EmpleadoDTO actualizarEmpleados(EmpleadoDTO dto) {
        EmpleadoEntity entity = dtoToEntity(dto);
        EmpleadoEntity updated = repository.save(entity);
        return entityToDTO(updated);
    }

    @Override
    public boolean eliminarEmpleados(Integer id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}