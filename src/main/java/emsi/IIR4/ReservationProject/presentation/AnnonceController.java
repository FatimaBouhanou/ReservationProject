package emsi.IIR4.ReservationProject.presentation;

import java.util.ArrayList;
import java.util.List;

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
    public String getHome(Model model,@RequestParam(defaultValue ="0") int numPage ) {
    	Page<Annonce> listAnnonce = as.listerAnnonce(numPage);
    	int currentPage = numPage;
    	int totalPage = listAnnonce.getTotalPages();
        model.addAttribute("list", listAnnonce);
        model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalPage", totalPage);
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
    //---------------------------------------------
    @GetMapping("/booking")
    public String showBookingForm(@RequestParam Integer id, Model model) throws Exception {
       
        Annonce selectedAnnonce = as.rechercherParId(id);
        
        model.addAttribute("selectedAnnonce", selectedAnnonce);
        // Return the booking page
        return "booking";
    }
    //---------------------------------------------
    @GetMapping("/ads")
    public String getAds(Model model, @RequestParam(defaultValue = "0") int numPage) {
        Page<Annonce> liste = as.listerAnnonce(numPage);
        model.addAttribute("list", liste);

        int currentPage = liste.getNumber(); // Get the current page number
        int totalPage = liste.getTotalPages(); // Get the total number of pages

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPage", totalPage);

        return "listAnnonces";
    }


    @GetMapping("/searchAnnonce")
    public String rechercherParId(@RequestParam(name = "annonceId") Integer searchQuery, Model model) {
        try {
            Annonce annonce = as.rechercherParId(searchQuery);
            if (annonce != null) {
                List<Annonce> annonces = new ArrayList<>();
                annonces.add(annonce);
                model.addAttribute("liste", annonces);
            } else {
                model.addAttribute("errorMessage", "Client introuvable");
            }
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Erreur");
        }
        return "searchResult";
    }


	//search by name
    @GetMapping("/searchByName")
    public String searchByName(@RequestParam("annonceName") String annonceName, Model model) throws Exception {
        List<Annonce> searchResults = as.searchByName(annonceName);
        model.addAttribute("list", searchResults);
        return "searchResult"; // Replace "your-template-name" with the name of your Thymeleaf template
    }
    
}