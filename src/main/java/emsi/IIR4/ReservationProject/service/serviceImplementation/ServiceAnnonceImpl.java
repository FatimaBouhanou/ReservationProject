package emsi.IIR4.ReservationProject.service.serviceImplementation;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import emsi.IIR4.ReservationProject.dao.entities.Annonce;
import emsi.IIR4.ReservationProject.dao.repositories.IAnnonceRepo;
import emsi.IIR4.ReservationProject.service.IService.IServiceAnnonce;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.AssertFalse.List;
import lombok.Data;

@Data
@Transactional
@Service
public class ServiceAnnonceImpl implements IServiceAnnonce{
	private final IAnnonceRepo ar;

	@Override
	public void ajouterAnnonce(Annonce a) {
		// TODO Auto-generated method stub
		ar.save(a);
		
	}

	@Override
	public void supprimerAnnonce(Integer id) {
		// TODO Auto-generated method stub
		ar.deleteById(id);
	}

	@Override
	public void modifierAnnonce(Annonce a) {
		// TODO Auto-generated method stub
		ar.save(a);
	}

	@Override
	public Annonce rechercherParId(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Optional<Annonce> a=ar.findById(id);
		if(a.isPresent())
			return a.get();
		
		else 
			throw new Exception("annoneNotFound");
		
	}

	@Override
	public java.util.List<Annonce> listerAnnonce() {
		return ar.findAll();
	
	}


	

}
