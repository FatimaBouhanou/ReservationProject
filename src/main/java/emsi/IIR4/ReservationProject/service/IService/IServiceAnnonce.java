package emsi.IIR4.ReservationProject.service.IService;

import org.springframework.data.domain.Page;
import emsi.IIR4.ReservationProject.dao.entities.Annonce;
import java.util.List;

public interface IServiceAnnonce {
    public void ajouterAnnonce(Annonce a);
    public void supprimerAnnonce(Integer id);
    public void modifierAnnonce(Annonce a);
    public Annonce rechercherParId(Integer id) throws Exception;
    public List<Annonce> listerAnnonce();
}
