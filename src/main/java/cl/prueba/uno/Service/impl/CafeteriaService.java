package cl.prueba.uno.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.prueba.uno.Excepcion.CafeteriaNoEncontrada;
import cl.prueba.uno.Repository.ICafeteriaRepository;
import cl.prueba.uno.Service.ICafeteriaService;
import cl.prueba.uno.dto.CafeteriaDTO;
import jakarta.transaction.Transactional;

@Service
public class CafeteriaService implements ICafeteriaService{
    @Autowired
    ICafeteriaRepository west;

    @Override
    public CafeteriaDTO insertarCafeteria(CafeteriaDTO cafeteria) {
        return west.save(cafeteria);
        
    }

    @Override
    public List<CafeteriaDTO> getTodos() {
        return(List<CafeteriaDTO>)west.findAll();
    }


    @Override
    public CafeteriaDTO getById(Long id) {
        return west.findById(id.intValue()).get();
        
    }

    @Override
    public CafeteriaDTO updateCafeteria(CafeteriaDTO cafeteria) {
        return west.save(cafeteria);
    }
    
    @Transactional
    @Override
    public boolean deleteById(Integer id) {
        Optional<CafeteriaDTO> cafeteriaOptional = west.findById(id);
        if (cafeteriaOptional.isEmpty()) {
            throw new CafeteriaNoEncontrada("LA CAFETERIA SELECCIONADA NO SE ENCONTRO CON ID: " + id);
        }
        west.deleteById(id);
        return true;

        
    }

}
