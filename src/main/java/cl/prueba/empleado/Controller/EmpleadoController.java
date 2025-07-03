package cl.prueba.empleado.Controller;

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

import cl.prueba.empleado.Service.IEmpleadoService;
import cl.prueba.empleado.dto.EmpleadoDTO;

@RestController
@RequestMapping("/api/crud/Empleado")

public class EmpleadoController {
    @Autowired
    IEmpleadoService Servicio;

    @GetMapping
    public List<EmpleadoDTO> getAll(){
        return Servicio.getTodosEmpleados();
    }
    @PostMapping//Añadir
    public EmpleadoDTO inseEmpleadoDTO(@RequestBody EmpleadoDTO empleado){
        return Servicio.insertarEmpleados(empleado);
    }
    @GetMapping("/{id}")//Mostrar
    public EmpleadoDTO getById(@PathVariable Integer id){
        return Servicio.getEmpleadosById(id);
    }
    @PutMapping("/{id}")//Modificar
    public EmpleadoDTO deleteById(@PathVariable Integer id,@RequestBody EmpleadoDTO empleado){
        empleado.setIdEmpleado(id);
        return Servicio.actualizarEmpleados(empleado);
    }

    @DeleteMapping("/{id}")//Eliminar
    public boolean deleteById(@PathVariable Integer id){
        return Servicio.eliminarEmpleados(id);
    }

}










// recibe peticones del usuario. (es coo el resepcionista)