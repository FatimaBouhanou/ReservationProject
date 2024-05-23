package emsi.IIR4.ReservationProject.dao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import emsi.IIR4.ReservationProject.dao.entities.Annonce;
import lombok.Data;
import lombok.NoArgsConstructor;


public interface IAnnonceRepo extends JpaRepository<Annonce, Integer> {
	List<Annonce> findByAnnonceNameContaining(String name);

}
