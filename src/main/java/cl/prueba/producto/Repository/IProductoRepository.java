package cl.prueba.producto.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.prueba.producto.dto.ProductoDTO;

@Repository
public interface IProductoRepository extends CrudRepository<ProductoDTO,Integer> {
}
