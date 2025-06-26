package cl.prueba.uno.Service;
import java.util.List;

import cl.prueba.uno.dto.CafeteriaDTO;

public interface ICafeteriaService {
    CafeteriaDTO insertarCafeteria (CafeteriaDTO cafeteria);
    
    List<CafeteriaDTO> getTodos();
    CafeteriaDTO getById(Long id);
    boolean deleteById(Integer id);
    CafeteriaDTO updateCafeteria(CafeteriaDTO cafeteria);

}
