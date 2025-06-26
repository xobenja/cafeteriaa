package cl.prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"cl.prueba.uno","cl.prueba.producto","cl.prueba.pedido", "cl.prueba.mesasCafeteria","cl.prueba.cliente","cl.prueba.empleado","cl.prueba.boleta"})
public class UnoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnoApplication.class, args);
	}

}