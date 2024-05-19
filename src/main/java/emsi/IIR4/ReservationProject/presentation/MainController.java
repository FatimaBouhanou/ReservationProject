package emsi.IIR4.ReservationProject.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
@Controller
public class MainController {

//index 
	@GetMapping("/")
	public String index() {
		return "index.html";
	}
	
	  // register form
	  @GetMapping("/register")
	  public String register() {
	    return "register.html";
	  }

  // Login form
  @GetMapping("/login1")
  public String login() {
    return "login.html";
  }

}