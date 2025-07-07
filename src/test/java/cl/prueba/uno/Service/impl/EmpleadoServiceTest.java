package cl.prueba.uno.Service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import cl.prueba.empleado.Entity.EmpleadoEntity;
import cl.prueba.empleado.Repository.IEmpleadoRepository;
import cl.prueba.empleado.Service.impl.EmpleadoService;
import cl.prueba.empleado.dto.EmpleadoDTO;
import cl.prueba.uno.Entity.CafeteriaEntity;
import cl.prueba.uno.Repository.ICafeteriaRepository;
import cl.prueba.uno.dto.CafeteriaDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

public class EmpleadoServiceTest {
    @Mock
    private IEmpleadoRepository empleadoRepository;

    @Mock
    private ICafeteriaRepository cafeteriaRepository;

    @InjectMocks
    private EmpleadoService empleadoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testInsertarEmpleados() {
        // Arrange
        EmpleadoDTO dto = new EmpleadoDTO();
        dto.setNombre("Lionel");
        dto.setApellidoP("Messi");
        dto.setApellidoM("Cuccittini");
        dto.setRut("12.345.678-9");
        dto.setTelefono("987654321");
        dto.setIdCafeteria(new CafeteriaDTO(1, "Jarrys", null));

        CafeteriaEntity cafeteriaEntity = new CafeteriaEntity();
        cafeteriaEntity.setIdCafeteria(1);
        cafeteriaEntity.setNombreLocal("Jarrys");

        when(cafeteriaRepository.findById(1)).thenReturn(Optional.of(cafeteriaEntity));

        EmpleadoEntity savedEntity = new EmpleadoEntity();
        savedEntity.setIdEmpleado(100);
        savedEntity.setNombre(dto.getNombre());
        savedEntity.setApellidoP(dto.getApellidoP());
        savedEntity.setApellidoM(dto.getApellidoM());
        savedEntity.setRut(dto.getRut());
        savedEntity.setTelefono(dto.getTelefono());
        savedEntity.setIdCafeteria(cafeteriaEntity);

        when(empleadoRepository.save(any(EmpleadoEntity.class))).thenReturn(savedEntity);

        // Act
        EmpleadoDTO result = empleadoService.insertarEmpleados(dto);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result.getIdEmpleado()).isEqualTo(100);
        assertThat(result.getIdCafeteria().getNombreLocal()).isEqualTo("Jarrys");
    }

    @Test
void testGetTodosEmpleados_ok() {
    // Simulamos cafetería
    CafeteriaEntity cafeteriaEntity = new CafeteriaEntity();
    cafeteriaEntity.setIdCafeteria(2);
    cafeteriaEntity.setNombreLocal("Josesito");

    EmpleadoEntity entity = new EmpleadoEntity();
    entity.setIdEmpleado(10);
    entity.setNombre("Carlos");
    entity.setApellidoP("Gonzalez");
    entity.setApellidoM("Pérez");
    entity.setRut("11.111.111-1");
    entity.setTelefono("987654321");
    entity.setIdCafeteria(cafeteriaEntity);

    when(empleadoRepository.findAll()).thenReturn(List.of(entity));

    var lista = empleadoService.getTodosEmpleados();

    assertThat(lista).hasSize(1);
    assertThat(lista.get(0).getNombre()).isEqualTo("Carlos");
    assertThat(lista.get(0).getIdCafeteria()).isNotNull();
    assertThat(lista.get(0).getIdCafeteria().getIdCafeteria()).isEqualTo(2);
}

}
