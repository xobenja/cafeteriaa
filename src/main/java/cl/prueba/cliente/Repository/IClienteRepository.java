package cl.prueba.cliente.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.prueba.cliente.dto.ClienteDTO;


@Repository
public interface IClienteRepository extends CrudRepository<ClienteDTO,Integer> {

}
