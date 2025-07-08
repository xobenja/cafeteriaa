    package cl.prueba.uno.Service.impl;


    import cl.prueba.empleado.Entity.EmpleadoEntity;
    import cl.prueba.empleado.Repository.IEmpleadoRepository;
    import cl.prueba.empleado.Service.impl.EmpleadoService;
    import cl.prueba.empleado.dto.EmpleadoDTO;
    import cl.prueba.uno.Entity.CafeteriaEntity;
    import cl.prueba.uno.Repository.ICafeteriaRepository;
    import cl.prueba.uno.dto.CafeteriaDTO;
    import jakarta.transaction.Transactional;

    import org.assertj.core.api.Assertions;
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Test;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.test.context.SpringBootTest;
    import org.springframework.test.context.TestPropertySource;

    @SpringBootTest
    @TestPropertySource(locations = "classpath:application-test.properties")
    @Transactional
    public class EmpleadoServiceIntegrationTest {
        @Autowired
        private EmpleadoService empleadoService;

        @Autowired
        private ICafeteriaRepository cafeteriaRepository;

        @Autowired
        private IEmpleadoRepository empleadoRepository;

        @BeforeEach
        void setUp() {
            // Limpiar la BD antes de cada test
            empleadoRepository.deleteAll();
            cafeteriaRepository.deleteAll();
        }
        @Test
void insertarEmpleado_conDatosValidos_guardaCorrectamente() {
    CafeteriaEntity cafeteria = new CafeteriaEntity();
    cafeteria.setNombreLocal("PruebaCafe");
    cafeteria = cafeteriaRepository.save(cafeteria);

    System.out.println("ID cafetería en test: " + cafeteria.getIdCafeteria());

    EmpleadoDTO dto = new EmpleadoDTO();
    dto.setNombre("Juan");
    dto.setApellidoP("Perez");
    dto.setApellidoM("Soto");
    dto.setRut("11.111.111-1");
    dto.setTelefono("987654321");
    dto.setIdCafeteria(
        new CafeteriaDTO(cafeteria.getIdCafeteria(), cafeteria.getNombreLocal())
    );

    EmpleadoDTO result = empleadoService.insertarEmpleados(dto);

    Assertions.assertThat(result).isNotNull();
    Assertions.assertThat(result.getIdEmpleado()).isNotNull();
    Assertions.assertThat(result.getIdCafeteria()).isNotNull();
    Assertions.assertThat(result.getIdCafeteria().getIdCafeteria())
            .isEqualTo(cafeteria.getIdCafeteria());
}

        /*@Test
void insertarEmpleado_conDatosValidos_guardaCorrectamente() {
    // Arrange
    CafeteriaEntity cafeteria = new CafeteriaEntity();
    cafeteria.setNombreLocal("PruebaCafe");
    cafeteria = cafeteriaRepository.save(cafeteria);
    cafeteriaRepository.flush();

    System.out.println("ID cafetería en test: " + cafeteria.getIdCafeteria());

    EmpleadoDTO dto = new EmpleadoDTO();
    dto.setNombre("Juan");
    dto.setApellidoP("Perez");
    dto.setApellidoM("Soto");
    dto.setRut("11.111.111-1");
    dto.setTelefono("987654321");
    dto.setIdCafeteria(
        new CafeteriaDTO(cafeteria.getIdCafeteria(), cafeteria.getNombreLocal())
    );

    // Act
    EmpleadoDTO result = empleadoService.insertarEmpleados(dto);

    // Assert
    Assertions.assertThat(result).isNotNull();
    Assertions.assertThat(result.getIdEmpleado()).isNotNull();
    Assertions.assertThat(result.getNombre()).isEqualTo("Juan");

    Assertions.assertThat(result.getIdCafeteria()).isNotNull();
    Assertions.assertThat(result.getIdCafeteria().getIdCafeteria())
            .isEqualTo(cafeteria.getIdCafeteria());

    EmpleadoEntity entityInDb = empleadoRepository
            .findById(result.getIdEmpleado())
            .orElseThrow();

    Assertions.assertThat(entityInDb.getNombre()).isEqualTo("Juan");
} */
    }
