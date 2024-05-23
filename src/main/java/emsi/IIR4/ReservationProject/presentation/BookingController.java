import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import emsi.IIR4.ReservationProject.dao.entities.Booking;

@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // Method to display the booking form
    @GetMapping("/bookingForm")
    public String showBookingForm(Model model) {
        // Create a new instance of Booking to bind the form data
        Booking booking = new Booking();
        model.addAttribute("booking", booking);
        return "booking-form"; // This should match the name of your Thymeleaf template
    }

    // Method to handle the form submission
    @PostMapping("/ajouterBooking")
    public String addBooking(@ModelAttribute("booking") Booking booking, Model model) {
        // Add your logic here to process the booking
        // You can access the booking details using the Booking object passed as a parameter
        // For example, you can call a service method to save the booking to a database
        bookingService.saveBooking(booking);
        
        // Redirect to a confirmation page or any other page after successful booking
        return "redirect:/confirmation";
    }
}
