package cl.prueba.mesasCafeteria.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.prueba.mesasCafeteria.Entity.MesaCafeteriaEntity;
//import cl.prueba.mesasCafeteria.dto.MesaCafeteriaDTO;

@Repository
public interface IMesaCafeteriaRepository extends CrudRepository<MesaCafeteriaEntity, Integer>{

}
