package emsi.IIR4.ReservationProject.dao.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Annonce {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer annonceId;
private String annonceName;
private String description;
private double price;
private String dispo;
}
