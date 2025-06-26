package cl.prueba.boleta.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.prueba.boleta.Service.IBoletaService;
import cl.prueba.boleta.dto.BoletaDTO;

@RestController
@RequestMapping("/api/crud/boleta")
public class BoletaController {
    @Autowired
    IBoletaService Servicio;

    @GetMapping
    public List<BoletaDTO> getAll(){
        return Servicio.getTodosProductos();
    }
    @PostMapping//Añadir
    public BoletaDTO inseBoletaDTO(@RequestBody BoletaDTO boleta){
        return Servicio.insertarboleta(boleta);
    }
    @GetMapping("/{id}")//Mostrar
    public BoletaDTO getById(@PathVariable Long id){
        return Servicio.getBoletaById(id);
    }
}
