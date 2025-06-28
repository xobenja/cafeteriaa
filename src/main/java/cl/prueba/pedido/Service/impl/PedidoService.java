package cl.prueba.pedido.Service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.prueba.pedido.Entity.PedidoEntity;
import cl.prueba.pedido.Repository.IPedidoRepository;
import cl.prueba.pedido.Service.IPedidoService;
import cl.prueba.pedido.dto.PedidoDTO;

@Service
public class PedidoService implements IPedidoService {

    @Autowired
    IPedidoRepository xd;

    private PedidoDTO toDTO(PedidoEntity entity) {
        return new PedidoDTO(entity.getIdPedidos());
    }

    private PedidoEntity toEntity(PedidoDTO dto) {
        return new PedidoEntity(dto.getIdPedidos());
    }

    @Override
    public List<PedidoDTO> getTodosPedidos() {
        List<PedidoEntity> entities = (List<PedidoEntity>) xd.findAll();
        return entities.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PedidoDTO insertarPedidos(PedidoDTO pedido) {
        PedidoEntity entity = toEntity(pedido);
        return toDTO(xd.save(entity));
    }

    @Override
    public PedidoDTO getProductoById(Long id) {
        Optional<PedidoEntity> entity = xd.findById(id.intValue());
        return entity.map(this::toDTO).orElse(null);
    }

    @Override
    public PedidoDTO actualizarPedido(PedidoDTO pedido) {
        PedidoEntity entity = toEntity(pedido);
        return toDTO(xd.save(entity));
    }

    @Override
    public boolean eliminarPedido(Integer id) {
        try {
            xd.deleteById(id);
            return true;
        } catch (Exception error) {
            return false;
        }
    }
}