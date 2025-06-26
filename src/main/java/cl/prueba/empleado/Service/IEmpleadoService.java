package cl.prueba.empleado.Service;

import java.util.List;

import cl.prueba.empleado.dto.EmpleadoDTO;

public interface IEmpleadoService  {
    EmpleadoDTO insertarEmpleados (EmpleadoDTO empleados);

    List<EmpleadoDTO> getTodosEmpleados();

    EmpleadoDTO getEmpleadosById(Long id);

    EmpleadoDTO actualizarEmpleados(EmpleadoDTO empleados);

    boolean eliminarEmpleados(Integer id);

}
















// logica del proyecto
