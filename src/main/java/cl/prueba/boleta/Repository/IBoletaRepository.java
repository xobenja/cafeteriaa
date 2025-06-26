package cl.prueba.boleta.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.prueba.boleta.dto.BoletaDTO;

@Repository
public interface IBoletaRepository extends CrudRepository<BoletaDTO, Integer>{

}
