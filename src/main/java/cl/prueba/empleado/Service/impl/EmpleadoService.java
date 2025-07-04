package cl.prueba.empleado.Service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.prueba.empleado.dto.EmpleadoDTO;
import cl.prueba.uno.Entity.CafeteriaEntity;
import cl.prueba.uno.Repository.ICafeteriaRepository;
import cl.prueba.uno.dto.CafeteriaDTO;
import cl.prueba.empleado.Entity.EmpleadoEntity;
import cl.prueba.empleado.Repository.IEmpleadoRepository;
import cl.prueba.empleado.Service.IEmpleadoService;


@Service
public class EmpleadoService implements IEmpleadoService {

    @Autowired
    private IEmpleadoRepository repository;

    @Autowired
    private ICafeteriaRepository cafeteriaRepository;

    
    
    // Conversión Entity -> DTO
    /*private EmpleadoDTO entityToDTO(EmpleadoEntity entity) {
        return new EmpleadoDTO(
            entity.getIdEmpleado(),
            entity.getNombre(),
            entity.getApellidoP(),
            entity.getApellidoM(),
            entity.getRut(),
            entity.getTelefono(),
            
        );
    }*/

    private EmpleadoDTO entityToDTO(EmpleadoEntity entity) {
        CafeteriaDTO cafeteriaDTO =null;
        if (entity.getIdCafeteria() != null) {
            CafeteriaEntity cafeteria = entity.getIdCafeteria();
            cafeteriaDTO = new CafeteriaDTO(
                cafeteria.getIdCafeteria(),
                cafeteria.getNombreLocal()
            );
            
        }
        return new EmpleadoDTO(
            entity.getIdEmpleado(),
            entity.getNombre(),
            entity.getApellidoP(),
            entity.getApellidoM(),
            entity.getRut(),
            entity.getTelefono(),
            cafeteriaDTO
        );
    }

    // Conversión DTO -> Entity para insertar (sin ID)
    private EmpleadoEntity dtoToEntityInsert(EmpleadoDTO dto) {
    EmpleadoEntity entity = new EmpleadoEntity();
    entity.setNombre(dto.getNombre());
    entity.setApellidoP(dto.getApellidoP());
    entity.setApellidoM(dto.getApellidoM());
    entity.setRut(dto.getRut());
    entity.setTelefono(dto.getTelefono());

    if (dto.getIdCafeteria() != null) {
        int cafeteriaId = dto.getIdCafeteria().getIdCafeteria();
        if (cafeteriaId > 0) {
            Optional<CafeteriaEntity> cafeteriaOpt = cafeteriaRepository.findById(cafeteriaId);
            if (cafeteriaOpt.isPresent()) {
                entity.setIdCafeteria(cafeteriaOpt.get());
            } else {
                throw new RuntimeException("Cafetería no encontrada con ID: " + cafeteriaId);
            }
        } else {
            entity.setIdCafeteria(null);
        }
    } else {
        entity.setIdCafeteria(null);
    }

    return entity;
}

    @Override
    public EmpleadoDTO insertarEmpleados(EmpleadoDTO dto) {
        EmpleadoEntity entity = dtoToEntityInsert(dto);
        EmpleadoEntity saved = repository.save(entity);
        return entityToDTO(saved);
    }

    @Override
    public List<EmpleadoDTO> getTodosEmpleados() {
        List<EmpleadoEntity> entities = (List<EmpleadoEntity>) repository.findAll();
        return entities.stream().map(this::entityToDTO).collect(Collectors.toList());
    }

    @Override
    public EmpleadoDTO getEmpleadosById(Integer id) {
        Optional<EmpleadoEntity> entityOpt = repository.findById(id);
        return entityOpt.map(this::entityToDTO).orElse(null);
    }

    @Override
    public EmpleadoDTO actualizarEmpleados(EmpleadoDTO dto) {
        if (dto.getIdEmpleado() == null) {
            throw new IllegalArgumentException("El ID del empleado es obligatorio para actualizar");
        }

        Optional<EmpleadoEntity> existingOpt = repository.findById(dto.getIdEmpleado());
        if (existingOpt.isEmpty()) {
            throw new RuntimeException("Empleado no encontrado con ID: " + dto.getIdEmpleado());
        }

        EmpleadoEntity entityToUpdate = existingOpt.get();
        // Actualizamos solo los campos editables
        entityToUpdate.setNombre(dto.getNombre());
        entityToUpdate.setApellidoP(dto.getApellidoP());
        entityToUpdate.setApellidoM(dto.getApellidoM());
        entityToUpdate.setRut(dto.getRut());
        entityToUpdate.setTelefono(dto.getTelefono());

        EmpleadoEntity updated = repository.save(entityToUpdate);
        return entityToDTO(updated);
    }

    @Override
    public boolean eliminarEmpleados(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
