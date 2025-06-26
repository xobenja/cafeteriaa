package cl.prueba.boleta.Service;

import java.util.List;

import cl.prueba.boleta.dto.BoletaDTO;

public interface IBoletaService {

    List<BoletaDTO> getTodosProductos();

    BoletaDTO insertarboleta(BoletaDTO boleta);

    BoletaDTO getBoletaById(Long id);

}
