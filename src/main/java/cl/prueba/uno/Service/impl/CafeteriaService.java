package cl.prueba.uno.Service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.prueba.uno.Entity.CafeteriaEntity;
import cl.prueba.uno.Excepcion.CafeteriaNoEncontrada;
import cl.prueba.uno.Repository.ICafeteriaRepository;
import cl.prueba.uno.Service.ICafeteriaService;
import cl.prueba.uno.dto.CafeteriaDTO;
import jakarta.transaction.Transactional;

@Service
public class CafeteriaService implements ICafeteriaService {

    @Autowired
    ICafeteriaRepository west;

    @Override
    public CafeteriaDTO insertarCafeteria(CafeteriaDTO dto) {
        CafeteriaEntity entity = new CafeteriaEntity(dto.getIdCafeteria(), dto.getNombreLocal());
        CafeteriaEntity saved = west.save(entity);
        return new CafeteriaDTO(saved.getIdCafeteria(), saved.getNombreLocal());
    }

    @Override
    public List<CafeteriaDTO> getTodos() {
        List<CafeteriaEntity> entities = (List<CafeteriaEntity>) west.findAll();
        return entities.stream()
                .map(e -> new CafeteriaDTO(e.getIdCafeteria(), e.getNombreLocal()))
                .collect(Collectors.toList());
    }

    @Override
    public CafeteriaDTO getById(Long id) {
        Optional<CafeteriaEntity> entityOpt = west.findById(id.intValue());
        if (entityOpt.isEmpty()) {
            throw new CafeteriaNoEncontrada("No se encontró la cafetería con ID: " + id);
        }
        CafeteriaEntity e = entityOpt.get();
        return new CafeteriaDTO(e.getIdCafeteria(), e.getNombreLocal());
    }

    @Override
    public CafeteriaDTO updateCafeteria(CafeteriaDTO dto) {
        CafeteriaEntity entity = new CafeteriaEntity(dto.getIdCafeteria(), dto.getNombreLocal());
        CafeteriaEntity updated = west.save(entity);
        return new CafeteriaDTO(updated.getIdCafeteria(), updated.getNombreLocal());
    }

    @Override
    @Transactional
    public boolean deleteById(Integer id) {
        Optional<CafeteriaEntity> cafeteriaOptional = west.findById(id);
        if (cafeteriaOptional.isEmpty()) {
            throw new CafeteriaNoEncontrada("LA CAFETERIA SELECCIONADA NO SE ENCONTRO CON ID: " + id);
        }
        west.deleteById(id);
        return true;
    }
}
