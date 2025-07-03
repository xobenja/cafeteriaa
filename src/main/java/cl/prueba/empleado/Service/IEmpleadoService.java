package cl.prueba.empleado.Service;

import java.util.List;
import cl.prueba.empleado.dto.EmpleadoDTO;

public interface IEmpleadoService {

    EmpleadoDTO insertarEmpleados(EmpleadoDTO dto);

    List<EmpleadoDTO> getTodosEmpleados();

    EmpleadoDTO getEmpleadosById(Integer id);

    EmpleadoDTO actualizarEmpleados(EmpleadoDTO dto);

    boolean eliminarEmpleados(Integer id);
}
