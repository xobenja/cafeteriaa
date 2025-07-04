package cl.prueba.uno.Service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.prueba.empleado.Entity.EmpleadoEntity;
import cl.prueba.empleado.dto.EmpleadoDTO;
import cl.prueba.uno.Entity.CafeteriaEntity;
import cl.prueba.uno.Excepcion.CafeteriaNoEncontrada;
import cl.prueba.uno.Repository.ICafeteriaRepository;
import cl.prueba.uno.Service.ICafeteriaService;
import cl.prueba.uno.dto.CafeteriaDTO;
import jakarta.transaction.Transactional;

@Service
public class CafeteriaService implements ICafeteriaService {

    @Autowired
    private ICafeteriaRepository west;

    /* 
    @Override
    @Transactional
    public CafeteriaDTO insertarCafeteria(CafeteriaDTO dto) {
        CafeteriaEntity entity = new CafeteriaEntity(dto.getIdCafeteria(), dto.getNombreLocal(), dto.getEmpleados().setNombreLocal()
        );
        CafeteriaEntity saved = west.save(entity);
        return new CafeteriaDTO(saved.getIdCafeteria(), saved.getNombreLocal(), null);
    }

    */

@Override
@Transactional
public CafeteriaDTO insertarCafeteria(CafeteriaDTO dto) {
    CafeteriaEntity entity = new CafeteriaEntity(dto.getIdCafeteria(), dto.getNombreLocal());
    entity.setEmpleados(dto.getEmpleado().stream()
            .map(emp -> new EmpleadoEntity(emp.getIdEmpleado(), emp.getNombre(), emp.getApellidoP(), emp.getApellidoM(), emp.getRut(), emp.getTelefono(), entity))
            .collect(Collectors.toList()));

    CafeteriaEntity saved = west.save(entity);
    return new CafeteriaDTO(saved.getIdCafeteria(), saved.getNombreLocal(), saved.getEmpleados().stream()
            .map(emp -> new EmpleadoDTO(emp.getIdEmpleado(), emp.getNombre(), emp.getApellidoP(), emp.getApellidoM(), emp.getRut(), emp.getTelefono(),  null))
            .collect(Collectors.toList()));
}

    @Override
    @Transactional
    public List<CafeteriaDTO> getTodos() {
        List<CafeteriaEntity> entities = (List<CafeteriaEntity>) west.findAll();

        return entities.stream().map(e -> {
            List<EmpleadoDTO> empleados = e.getEmpleados() == null ? List.of() : e.getEmpleados().stream().map(emp ->
                new EmpleadoDTO(
                    emp.getIdEmpleado(),
                    emp.getNombre(),
                    emp.getApellidoP(),
                    emp.getApellidoM(),
                    emp.getRut(),
                    emp.getTelefono(),
                    null  // para evitar recursión, deja cafeteria en null
                )
            ).collect(Collectors.toList());

            return new CafeteriaDTO(e.getIdCafeteria(), e.getNombreLocal(), empleados);
        }).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CafeteriaDTO getById(Long id) {
        Optional<CafeteriaEntity> entityOpt = west.findById(id.intValue());
        if (entityOpt.isEmpty()) {
            throw new CafeteriaNoEncontrada("No se encontró la cafetería con ID: " + id);
        }

        CafeteriaEntity e = entityOpt.get();

        List<EmpleadoDTO> empleados = e.getEmpleados() == null ? List.of() : e.getEmpleados().stream().map(emp ->
            new EmpleadoDTO(
                emp.getIdEmpleado(),
                emp.getNombre(),
                emp.getApellidoP(),
                emp.getApellidoM(),
                emp.getRut(),
                emp.getTelefono(),
                null
            )
        ).collect(Collectors.toList());

        return new CafeteriaDTO(e.getIdCafeteria(), e.getNombreLocal(), empleados);
    }

    @Override
    @Transactional
    public CafeteriaDTO updateCafeteria(CafeteriaDTO dto) {
        Optional<CafeteriaEntity> entityOpt = west.findById(dto.getIdCafeteria());
        if (entityOpt.isEmpty()) {
            throw new CafeteriaNoEncontrada("No se encontró la cafetería con ID: " + dto.getIdCafeteria());
        }

        CafeteriaEntity entity = entityOpt.get();
        entity.setNombreLocal(dto.getNombreLocal());
        // No modificar empleados aquí, se manejan por separado

        CafeteriaEntity updated = west.save(entity);

        List<EmpleadoDTO> empleados = updated.getEmpleados() == null ? List.of() : updated.getEmpleados().stream().map(emp ->
            new EmpleadoDTO(
                emp.getIdEmpleado(),
                emp.getNombre(),
                emp.getApellidoP(),
                emp.getApellidoM(),
                emp.getRut(),
                emp.getTelefono(),
                null
            )
        ).collect(Collectors.toList());

        return new CafeteriaDTO(updated.getIdCafeteria(), updated.getNombreLocal(), empleados);
    }

    @Override
    @Transactional
    public boolean deleteById(Integer id) {
        Optional<CafeteriaEntity> cafeteriaOptional = west.findById(id);
        if (cafeteriaOptional.isEmpty()) {
            throw new CafeteriaNoEncontrada("LA CAFETERIA SELECCIONADA NO SE ENCONTRO CON ID: " + id);
        }
        west.deleteById(id);
        return true;
    }
}
