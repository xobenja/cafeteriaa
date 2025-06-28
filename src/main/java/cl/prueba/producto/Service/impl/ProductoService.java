package cl.prueba.producto.Service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.prueba.producto.Entity.ProductoEntity;
import cl.prueba.producto.Repository.IProductoRepository;
import cl.prueba.producto.Service.IProductoService;
import cl.prueba.producto.dto.ProductoDTO;

@Service
public class ProductoService implements IProductoService {
    @Autowired
    IProductoRepository west;

    // Conversión manual
    private ProductoDTO toDTO(ProductoEntity entity) {
        return new ProductoDTO(
            entity.getIdProducto(),
            entity.getNombre(),
            entity.getCategoriaProducto(),
            entity.getDescripcionDetalle(),
            entity.getPrecio()
        );
    }

    private ProductoEntity toEntity(ProductoDTO dto) {
        return new ProductoEntity(
            dto.getIdProducto(),
            dto.getNombre(),
            dto.getCategoriaProducto(),
            dto.getDescripcionDetalle(),
            dto.getPrecio()
        );
    }

    @Override
    public ProductoDTO insertarProducto(ProductoDTO producto) {
        ProductoEntity entity = toEntity(producto);
        ProductoEntity saved = west.save(entity);
        return toDTO(saved);
    }

    @Override
    public List<ProductoDTO> getTodosProductos() {
        List<ProductoEntity> entities = (List<ProductoEntity>) west.findAll();
        return entities.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductoDTO getProductoById(Long id) {
        Optional<ProductoEntity> entityOpt = west.findById(id.intValue());
        return entityOpt.map(this::toDTO).orElse(null);
    }

    @Override
    public boolean eliminarProducto(Integer id) {
        try {
            west.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public ProductoDTO actualizarProducto(ProductoDTO producto) {
        ProductoEntity entity = toEntity(producto);
        ProductoEntity updated = west.save(entity);
        return toDTO(updated);
    }
}