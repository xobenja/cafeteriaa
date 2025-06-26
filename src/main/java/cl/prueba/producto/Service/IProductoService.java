package cl.prueba.producto.Service;

import java.util.List;

import cl.prueba.producto.dto.ProductoDTO;

public interface IProductoService {
    ProductoDTO insertarProducto(ProductoDTO producto);

    List<ProductoDTO> getTodosProductos();
    ProductoDTO getProductoById(Long id);
    boolean eliminarProducto(Integer id);
    ProductoDTO actualizarProducto(ProductoDTO producto);

}
