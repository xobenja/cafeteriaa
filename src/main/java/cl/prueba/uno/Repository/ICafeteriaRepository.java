package cl.prueba.uno.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import cl.prueba.uno.Entity.CafeteriaEntity;
//import cl.prueba.uno.dto.CafeteriaDTO;

@Repository
public interface ICafeteriaRepository extends CrudRepository<CafeteriaEntity,Integer> {

}
