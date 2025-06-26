package cl.prueba.empleado.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.prueba.empleado.Repository.IEmpleadoRepository;
import cl.prueba.empleado.Service.IEmpleadoService;
import cl.prueba.empleado.dto.EmpleadoDTO;


@Service
public class EmpleadoService implements IEmpleadoService{
    @Autowired
    IEmpleadoRepository west;

    @Override
    public EmpleadoDTO insertarEmpleados(EmpleadoDTO empleados) {
        return west.save(empleados);
        
    }

    @Override
    public List<EmpleadoDTO> getTodosEmpleados() {
        return(List<EmpleadoDTO>)west.findAll();
    }

    @Override
    public EmpleadoDTO getEmpleadosById(Long id) {
        return west.findById(id.intValue()).get();
    }

    @Override
    public EmpleadoDTO actualizarEmpleados(EmpleadoDTO empleados) {
        return west.save(empleados);
    }

    @Override
    public boolean eliminarEmpleados(Integer id) {
        west.deleteById(id);
        return true;
    }

}
