package emsi.IIR4.ReservationProject.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index"; // Assuming you have an index.html in your templates
    }
    
    @GetMapping("/register")
    public String register() {
        return "register"; // Assuming you have a register.html in your templates
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup"; // Assuming you have a signup.html in your templates
    }
}
