// accedes a a base de datos y practicaente es el itermediario 



package cl.prueba.empleado.Repository;

import org.springframework.data.repository.CrudRepository;

import cl.prueba.empleado.Entity.EmpleadoEntity;
//import cl.prueba.empleado.dto.EmpleadoDTO;

public interface IEmpleadoRepository extends CrudRepository<EmpleadoEntity,Integer>{

}
