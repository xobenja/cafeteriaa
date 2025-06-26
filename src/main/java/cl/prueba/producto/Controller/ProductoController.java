package cl.prueba.producto.Controller;

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

import cl.prueba.producto.Service.IProductoService;
import cl.prueba.producto.dto.ProductoDTO;

@RestController
@RequestMapping("/api/crud/producto")
public class ProductoController {
    @Autowired
    IProductoService Servicio;

    @GetMapping
    public List<ProductoDTO> getAll(){
        return Servicio.getTodosProductos();
    }
    @PostMapping//Añadir
    public ProductoDTO inseProductoDTO(@RequestBody ProductoDTO producto){
        return Servicio.insertarProducto(producto);
    }
    @GetMapping("/{id}")//Mostrar
    public ProductoDTO getById(@PathVariable Long id){
        return Servicio.getProductoById(id);
    }
    @PutMapping("/{id}")//Modificar
    public ProductoDTO deleteById(@PathVariable Integer id,@RequestBody ProductoDTO producto){
        producto.setIdProducto(id);
        return Servicio.actualizarProducto(producto);
    }

    @DeleteMapping("/{id}")//Eliminar
    public boolean deleteById(@PathVariable Integer id){
        return Servicio.eliminarProducto(id);
    }

}
