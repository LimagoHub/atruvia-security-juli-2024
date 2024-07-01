package org.example.simplesecurity.config;


import lombok.RequiredArgsConstructor;
import org.example.simplesecurity.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.intercept.RunAsManager;
import org.springframework.security.access.intercept.RunAsManagerImpl;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity( securedEnabled = true,prePostEnabled = true, jsr250Enabled = true)
@RequiredArgsConstructor
public class SecurityConfig {

	private final UserRepository userRepository;


	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests(requests -> requests
						.requestMatchers("/", "/home").permitAll()
						.requestMatchers("/unsecure/*").permitAll()
						.requestMatchers("/secure/*").hasAnyRole("USER", "GUEST")
						.anyRequest().authenticated()
				)
				.formLogin(form -> form
						.loginPage("/login")
						.permitAll()
				)
				.logout(LogoutConfigurer::permitAll);



		return http.build();
	}


		@Bean
		public UserDetailsService userDetailsService() {
			return username -> userRepository.findById(username)
					.orElseThrow(() -> new UsernameNotFoundException(username));
		}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}









}