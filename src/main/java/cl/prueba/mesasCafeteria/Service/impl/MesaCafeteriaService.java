package cl.prueba.mesasCafeteria.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.prueba.mesasCafeteria.Repository.IMesaCafeteriaRepository;
import cl.prueba.mesasCafeteria.Service.IMesaCafeteriaService;
import cl.prueba.mesasCafeteria.dto.MesaCafeteriaDTO;

@Service
public class MesaCafeteriaService implements IMesaCafeteriaService{

    @Autowired
    IMesaCafeteriaRepository jav;

    @Override
    public List<MesaCafeteriaDTO> getTodosMesas() {
        return (List<MesaCafeteriaDTO>) jav.findAll();
    }

    @Override
    public MesaCafeteriaDTO insertarMesaCafeteriaDTO(MesaCafeteriaDTO mesas) {
        return jav.save(mesas);

    }

    @Override
    public MesaCafeteriaDTO getMesasById(Long id) {
        return jav.findById(id.intValue()).orElse(null);// .orElse significa si encuentra el Producto, lo devuelve. Si no lo encuentra, devuelve null en vez de lanzar una excepcion. basicamente para no poner un if y un else, te lo complementa basicamente.

    }

    @Override
    public MesaCafeteriaDTO actualizarProducto(MesaCafeteriaDTO mesas) {
        return jav.save(mesas);
    }
    
}
