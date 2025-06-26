package cl.prueba.boleta.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.prueba.boleta.Repository.IBoletaRepository;
import cl.prueba.boleta.Service.IBoletaService;
import cl.prueba.boleta.dto.BoletaDTO;

@Service
public class BoletaService implements IBoletaService{
    @Autowired
    IBoletaRepository wast;

    @Override
    public List<BoletaDTO> getTodosProductos() {
        return(List<BoletaDTO>)wast.findAll();
    }

    @Override
    public BoletaDTO insertarboleta(BoletaDTO boleta) {
        return wast.save(boleta);
    }

    @Override
    public BoletaDTO getBoletaById(Long id) {
        return wast.findById(id.intValue()).get();

    }

    

}
