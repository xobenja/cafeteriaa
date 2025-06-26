package cl.prueba.producto.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.prueba.producto.Repository.IProductoRepository;
import cl.prueba.producto.Service.IProductoService;
import cl.prueba.producto.dto.ProductoDTO;


@Service
public class ProductoService implements IProductoService {
    @Autowired
    IProductoRepository west;

    @Override
    public ProductoDTO insertarProducto(ProductoDTO producto) {
        return west.save(producto);
    }

    @Override
    public List<ProductoDTO> getTodosProductos() {
        return (List<ProductoDTO>) west.findAll();
    }

    @Override
    public ProductoDTO getProductoById(Long id) {
        return west.findById(id.intValue()).orElse(null);// .orElse significa si encuentra el Producto, lo devuelve. Si no lo encuentra, devuelve null en vez de lanzar una excepcion. basicamente para no poner un if y un else, te lo complementa basicamente.
    }

    @Override
    public boolean eliminarProducto(Integer id) {
        try {
            west.deleteById(id);
            return true;
            // catch es si algo falla (por ejemplo, no existe el producto), captura la excepcion y devuelve false.
        } catch (Exception error) { //} catch (Exception error) { //error.printStackTrace(); // Imprime el error en consola //return false; //}
            return false;
        }
    }

    @Override
    public ProductoDTO actualizarProducto(ProductoDTO producto) {
        return west.save(producto);
    }
}
