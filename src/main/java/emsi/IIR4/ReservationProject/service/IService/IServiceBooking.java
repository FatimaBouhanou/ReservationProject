package emsi.IIR4.ReservationProject.service.IService;
import java.util.List;

import emsi.IIR4.ReservationProject.dao.entities.Booking;
public interface IServiceBooking {

	    Booking saveBooking(Booking booking);

	   
	    List<Booking> getAllBookings();

	   
	    Booking getBookingById(Long id);

	    
	    Booking updateBooking(Long id, Booking updatedBooking);

	   
	    void deleteBooking(Long id);
	

}
