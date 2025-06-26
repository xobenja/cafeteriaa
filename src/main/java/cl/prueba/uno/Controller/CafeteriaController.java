package cl.prueba.uno.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.prueba.uno.Service.ICafeteriaService;
import cl.prueba.uno.dto.CafeteriaDTO;

@RestController
@RequestMapping("/api/crud/cafeteria")
public class CafeteriaController {
    @Autowired
    ICafeteriaService Servicio;
    // private final
    private final Map<String, String> selloUnico = Map.of( //  1Mer Map.of   
            "eslogan", "Hecho por John Plaza");
    private final String correoElectronico = "johnplaza2203@gmail.com"; // Correo Personal
    private final String numeroTelefono = "+56 9 32150670"; // Numero Telefono Personal
    private final String nombreNegocio = "Cafeteria messi Ronaldo"; // Nombre Negocio


    @GetMapping()
    public ResponseEntity<Map<String, Object>> getAll() {
        List<CafeteriaDTO> cafeterias = Servicio.getTodos();
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("data", cafeterias);
        respuesta.put("sello (Marca de Agua)", selloUnico);
        respuesta.put("contacto", Map.of( // 2Do Map.of 
                "NombreNegocio",nombreNegocio,
                "email", correoElectronico,
                "telefono", numeroTelefono
        ));
        return ResponseEntity.ok(respuesta);
    }

    @PostMapping // Añadir
    public ResponseEntity<Map<String, Object>> inseCafeteriaDTO(@RequestBody CafeteriaDTO cafeteria) {
        CafeteriaDTO nuevaCafeteria = Servicio.insertarCafeteria(cafeteria);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("data", nuevaCafeteria);
        respuesta.put("sello (Marca de Agua)", selloUnico);
        respuesta.put("contacto", Map.of(
                "NombreNegocio",nombreNegocio,
                "email", correoElectronico,
                "telefono", numeroTelefono
        ));
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/{id}") // Mostrar
    public ResponseEntity<Map<String, Object>> getById(@PathVariable Long id) {
        CafeteriaDTO cafeteria = Servicio.getById(id);
        if (cafeteria != null) {
            Map<String, Object> respuesta = new HashMap<>();
            respuesta.put("data", cafeteria);
            respuesta.put("sello (Marca de Agua)", selloUnico);
            respuesta.put("contacto", Map.of(
                "NombreNegocio",nombreNegocio,
                "email", correoElectronico,
                "telefono", numeroTelefono
            ));
            return ResponseEntity.ok(respuesta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}") // Modificar
    public ResponseEntity<Map<String, Object>> updateCafeteria(@PathVariable Integer id, @RequestBody CafeteriaDTO cafeteria) {
        cafeteria.setIdCafeteria(id);
        CafeteriaDTO updatedCafeteria = Servicio.updateCafeteria(cafeteria);
        if (updatedCafeteria != null) {
            Map<String, Object> respuesta = new HashMap<>();
            respuesta.put("data", updatedCafeteria);
            respuesta.put("sello (Marca de Agua)", selloUnico);
            respuesta.put("contacto", Map.of(
                "NombreNegocio",nombreNegocio,
                "email", correoElectronico,
                "telefono", numeroTelefono
            ));
            
            return ResponseEntity.ok(respuesta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}") // Eliminar
    public ResponseEntity<Map<String, Object>> deleteById(@PathVariable Integer id) {
        boolean deleted = Servicio.deleteById(id);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("deleted", deleted);
        respuesta.put("sello (Marca de Agua)", selloUnico);
        respuesta.put("contacto", Map.of(
                "NombreNegocio",nombreNegocio,
                "email", correoElectronico,
                "telefono", numeroTelefono
        ));
        
        return ResponseEntity.ok(respuesta);
    }

}
