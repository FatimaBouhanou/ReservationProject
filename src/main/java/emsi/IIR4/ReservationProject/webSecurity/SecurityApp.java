package emsi.IIR4.ReservationProject.webSecurity;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

public class SecurityApp extends WebSecurityConfiguration{
	protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
        .anyRequest().authenticated()
        .and()
    .formLogin()
        .loginPage("/signup")
        .permitAll();
    }
}