package cl.prueba.mesasCafeteria.Service;

import java.util.List;

import cl.prueba.mesasCafeteria.dto.MesaCafeteriaDTO;

public interface IMesaCafeteriaService {

    List<MesaCafeteriaDTO> getTodosMesas();

    MesaCafeteriaDTO insertarMesaCafeteriaDTO(MesaCafeteriaDTO mesas);

    MesaCafeteriaDTO getMesasById(Long id);

    MesaCafeteriaDTO actualizarProducto(MesaCafeteriaDTO mesas);

}
