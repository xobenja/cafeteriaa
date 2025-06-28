package cl.prueba.boleta.Service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.prueba.boleta.Repository.IBoletaRepository;
import cl.prueba.boleta.Service.IBoletaService;
import cl.prueba.boleta.dto.BoletaDTO;
import cl.prueba.boleta.Entity.BoletaEntity;

@Service
public class BoletaService implements IBoletaService {

    @Autowired
    IBoletaRepository wast;

    @Override
public List<BoletaDTO> getTodosProductos() {
    return StreamSupport.stream(wast.findAll().spliterator(), false)
        .map(this::convertToDTO)
        .collect(Collectors.toList());
}

    @Override
    public BoletaDTO insertarboleta(BoletaDTO boleta) {
        BoletaEntity entity = convertToEntity(boleta);
        BoletaEntity saved = wast.save(entity);
        return convertToDTO(saved);
    }

    @Override
    public BoletaDTO getBoletaById(Long id) {
        Optional<BoletaEntity> entity = wast.findById(id.intValue());
        return entity.map(this::convertToDTO).orElse(null); // o lanza excepción si no existe
    }
    private BoletaDTO convertToDTO(BoletaEntity entity) {
        return new BoletaDTO(entity.getIdBoleta());
    }

    private BoletaEntity convertToEntity(BoletaDTO dto) {
        return new BoletaEntity(dto.getIdBoleta());
    }
}