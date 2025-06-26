package cl.prueba.mesasCafeteria.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.prueba.mesasCafeteria.Service.IMesaCafeteriaService;
import cl.prueba.mesasCafeteria.dto.MesaCafeteriaDTO;


@RestController
@RequestMapping("/api/crud/mesasMessiRonaldo")
public class MesaCafeteriaController {

    @Autowired
    IMesaCafeteriaService servicio;

    @GetMapping
    public List<MesaCafeteriaDTO> getAll(){
        return servicio.getTodosMesas();
    }
    @PostMapping//Añadir
    public MesaCafeteriaDTO inseMesaCafeteriaDTO(@RequestBody MesaCafeteriaDTO mesas){
        return servicio.insertarMesaCafeteriaDTO(mesas);
    }
    @GetMapping("/{id}")//Mostrar
    public MesaCafeteriaDTO getById(@PathVariable Long id){
        return servicio.getMesasById(id);
    }
    @PutMapping("/{id}")//Modificar
    public MesaCafeteriaDTO deleteById(@PathVariable Integer id,@RequestBody MesaCafeteriaDTO mesas){
        mesas.setIdMesas(id);
        return servicio.actualizarProducto(mesas);
    }
}
