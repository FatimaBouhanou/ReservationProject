package emsi.IIR4.ReservationProject.presentation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import emsi.IIR4.ReservationProject.dao.entities.Annonce;
import emsi.IIR4.ReservationProject.service.IService.IServiceAnnonce;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Controller
public class AnnonceController {
    private final IServiceAnnonce as;

    @GetMapping("/home")
    public String getHome(Model model) {
        java.util.List<Annonce> listAnnonce = as.listerAnnonce(); // Fetch all announcements
        model.addAttribute("list", listAnnonce);
        return "index";
    }

    @GetMapping("/addAnnonce")
    public String getFormAdd(Model model) {
        model.addAttribute("annonce", new Annonce());
        return "addAnnonce";
    }

    @PostMapping("/ajouterAnnonce")
    public String ajouterAnnonce(@Valid Annonce a, BindingResult br) {
        if (br.hasErrors()) {
            return "addAnnonce";
        } else {
            as.ajouterAnnonce(a);
            return "redirect:/home";
        }
    }

    
    @GetMapping("/modifier")
	public String showUpdateForm(@RequestParam Integer id, Model model) throws Exception {
		Annonce a = as.rechercherParId(id);
		model.addAttribute("annonce", a);
		return "updateForm";
	}
	
	@PostMapping("/modifier")
	public String updateAnnonce( @Valid  Annonce annonce, BindingResult result, RedirectAttributes redirectAttributes	) {
		if (result.hasErrors()) {
			return "updateForm";
		}
		as.modifierAnnonce(annonce);
		redirectAttributes.addFlashAttribute("message","annonce modifiée avec succès");
		return "redirect:/home";
	}

	
	//
    @GetMapping("/delete")
    public String deleteAnnonce(@RequestParam Integer id) {
        as.supprimerAnnonce(id);
        return "redirect:/home";
    }
}
