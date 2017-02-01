package de.kluge.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import de.kluge.model.User;
import de.kluge.model.repository.UserRepository;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	protected UserRepository myUserRepository;

	/**
	 * Spezifiziert, welche HTTP-Requests eine Autorisierung mit welcher Rolle
	 * benoetigen, und den Pfad zum Login-Dialog
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/Upload").hasRole(User.MEINE_USER_ROLLENNAME).antMatchers("/Upload/**")
				.permitAll().and().formLogin().loginPage("/User/login").failureUrl("/User/login?error=true");

		http.csrf().disable();
	}

	/**
	 * Spezifiziert, wie die Authentifizierung erfolgt, im Beispiel per JPA und
	 * DB
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());
	}

	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		return new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				UserDetails userDetails = myUserRepository.findOne(username);
				if (userDetails != null) {
					return userDetails;
				}
				throw new UsernameNotFoundException("Benutzer '" + username + "' nicht vorhanden.");
			}
		};
	}
}