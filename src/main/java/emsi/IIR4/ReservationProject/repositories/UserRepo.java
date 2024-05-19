package emsi.IIR4.ReservationProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import emsi.IIR4.ReservationProject.dao.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

}
