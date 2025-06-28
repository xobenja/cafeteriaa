package cl.prueba.pedido.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.prueba.pedido.Entity.PedidoEntity;
//import cl.prueba.pedido.dto.PedidoDTO;

@Repository
public interface IPedidoRepository extends CrudRepository <PedidoEntity, Integer>{

}
