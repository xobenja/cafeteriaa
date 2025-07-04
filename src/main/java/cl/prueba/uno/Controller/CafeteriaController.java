package cl.prueba.uno.Controller;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
//import org.springframework.hateoas.Link;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.prueba.uno.Service.ICafeteriaService;
import cl.prueba.uno.dto.CafeteriaDTO;

@RestController
@RequestMapping("/api/crud/cafeteria")
public class CafeteriaController {

    @Autowired
    ICafeteriaService Servicio;

    // Datos personales o del negocio
    private final Map<String, String> selloUnico = Map.of(
            "eslogan", "Hecho por John Plaza");
    private final String correoElectronico = "johnplaza2203@gmail.com";
    private final String numeroTelefono = "+56 9 32150670";
    private final String nombreNegocio = "Cafeteria messi Ronaldo";

    // GET: Todos con HATEOAS
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAll() {
        List<CafeteriaDTO> cafeterias = Servicio.getTodos();

        // Convertimos cada cafetería a un EntityModel con sus links
        List<EntityModel<CafeteriaDTO>> cafeteriasConLinks = cafeterias.stream()
            .map(c -> EntityModel.of(c,
                    linkTo(methodOn(CafeteriaController.class).getById((long) c.getIdCafeteria())).withSelfRel(),
                    linkTo(methodOn(CafeteriaController.class).getAll()).withRel("cafeterias")
            ))
            .collect(Collectors.toList());

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("data", cafeteriasConLinks);
        respuesta.put("sello (Marca de Agua)", selloUnico);
        respuesta.put("contacto", Map.of(
                "NombreNegocio", nombreNegocio,
                "email", correoElectronico,
                "telefono", numeroTelefono
        ));

        return ResponseEntity.ok(respuesta);
    }

    // POST: Insertar
    @PostMapping
    public ResponseEntity<Map<String, Object>> inseCafeteriaDTO(@RequestBody CafeteriaDTO cafeteria) {
        CafeteriaDTO nuevaCafeteria = Servicio.insertarCafeteria(cafeteria);

        EntityModel<CafeteriaDTO> cafeteriaConLinks = EntityModel.of(nuevaCafeteria,
                linkTo(methodOn(CafeteriaController.class).getById((long) nuevaCafeteria.getIdCafeteria())).withSelfRel(),
                linkTo(methodOn(CafeteriaController.class).getAll()).withRel("cafeterias")
        );

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("data", cafeteriaConLinks);
        respuesta.put("sello (Marca de Agua)", selloUnico);
        respuesta.put("contacto", Map.of(
                "NombreNegocio", nombreNegocio,
                "email", correoElectronico,
                "telefono", numeroTelefono
        ));

        return ResponseEntity.ok(respuesta);
    }

    // GET: Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable Long id) {
        CafeteriaDTO cafeteria = Servicio.getById(id);

        if (cafeteria != null) {
            EntityModel<CafeteriaDTO> cafeteriaConLinks = EntityModel.of(cafeteria,
                    linkTo(methodOn(CafeteriaController.class).getById(id)).withSelfRel(),
                    linkTo(methodOn(CafeteriaController.class).getAll()).withRel("cafeterias"),
                    linkTo(methodOn(CafeteriaController.class).deleteById(cafeteria.getIdCafeteria())).withRel("eliminar"),
                    linkTo(methodOn(CafeteriaController.class).updateCafeteria(cafeteria.getIdCafeteria(), cafeteria)).withRel("modificar")
            );

            Map<String, Object> respuesta = new HashMap<>();
            respuesta.put("data", cafeteriaConLinks);
            respuesta.put("sello (Marca de Agua)", selloUnico);
            respuesta.put("contacto", Map.of(
                    "NombreNegocio", nombreNegocio,
                    "email", correoElectronico,
                    "telefono", numeroTelefono
            ));

            return ResponseEntity.ok(respuesta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // PUT: Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateCafeteria(@PathVariable Integer id, @RequestBody CafeteriaDTO cafeteria) {
        cafeteria.setIdCafeteria(id);
        CafeteriaDTO updatedCafeteria = Servicio.updateCafeteria(cafeteria);

        if (updatedCafeteria != null) {
            EntityModel<CafeteriaDTO> cafeteriaConLinks = EntityModel.of(updatedCafeteria,
                    linkTo(methodOn(CafeteriaController.class).getById((long) id)).withSelfRel(),
                    linkTo(methodOn(CafeteriaController.class).getAll()).withRel("cafeterias")
            );

            Map<String, Object> respuesta = new HashMap<>();
            respuesta.put("data", cafeteriaConLinks);
            respuesta.put("sello (Marca de Agua)", selloUnico);
            respuesta.put("contacto", Map.of(
                    "NombreNegocio", nombreNegocio,
                    "email", correoElectronico,
                    "telefono", numeroTelefono
            ));

            return ResponseEntity.ok(respuesta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE: Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteById(@PathVariable Integer id) {
        boolean deleted = Servicio.deleteById(id);

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("deleted", deleted);
        respuesta.put("sello (Marca de Agua)", selloUnico);
        respuesta.put("contacto", Map.of(
                "NombreNegocio", nombreNegocio,
                "email", correoElectronico,
                "telefono", numeroTelefono
        ));

        return ResponseEntity.ok(respuesta);
    }
}
