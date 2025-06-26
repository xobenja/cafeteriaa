package cl.prueba.uno.dto;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="cafeteria_messiRonaldo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


public class CafeteriaDTO {
    @Id
    @Column(name="id_cafeteria")
    private int idCafeteria;
    private String nombreLocal;
}
