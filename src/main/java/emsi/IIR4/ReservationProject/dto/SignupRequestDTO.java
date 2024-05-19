package emsi.IIR4.ReservationProject.dto;

import emsi.IIR4.ReservationProject.dao.entities.User;
import lombok.Data;
@Data
public class SignupRequestDTO {
	private Integer userID;
	private String firstName;
	private String lastName;
	private String email;
	private String pw;
	private String phone;
	
}
