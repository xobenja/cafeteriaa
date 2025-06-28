package cl.prueba.mesasCafeteria.Service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.prueba.mesasCafeteria.Repository.IMesaCafeteriaRepository;
import cl.prueba.mesasCafeteria.Service.IMesaCafeteriaService;
import cl.prueba.mesasCafeteria.dto.MesaCafeteriaDTO;
import cl.prueba.mesasCafeteria.Entity.MesaCafeteriaEntity;

@Service
public class MesaCafeteriaService implements IMesaCafeteriaService {

    @Autowired
    private IMesaCafeteriaRepository repository;

    @Override
    public List<MesaCafeteriaDTO> getTodosMesas() {
        List<MesaCafeteriaDTO> result = new ArrayList<>();
        for (MesaCafeteriaEntity entity : repository.findAll()) {
            result.add(toDTO(entity));
        }
        return result;
    }

    @Override
    public MesaCafeteriaDTO insertarMesaCafeteriaDTO(MesaCafeteriaDTO dto) {
        MesaCafeteriaEntity entity = repository.save(toEntity(dto));
        return toDTO(entity);
    }

    @Override
    public MesaCafeteriaDTO getMesasById(Long id) {
        return repository.findById(id.intValue())
                         .map(this::toDTO)
                         .orElse(null);
    }

    @Override
    public MesaCafeteriaDTO actualizarProducto(MesaCafeteriaDTO dto) {
        MesaCafeteriaEntity entity = repository.save(toEntity(dto));
        return toDTO(entity);
    }

    // Métodos de conversión
    private MesaCafeteriaDTO toDTO(MesaCafeteriaEntity entity) {
        return new MesaCafeteriaDTO(entity.getIdMesaCafeteria(), entity.getDisponibilidad());
    }

    private MesaCafeteriaEntity toEntity(MesaCafeteriaDTO dto) {
        return new MesaCafeteriaEntity(dto.getIdMesas(), dto.getDisponibilidad());
    }
}