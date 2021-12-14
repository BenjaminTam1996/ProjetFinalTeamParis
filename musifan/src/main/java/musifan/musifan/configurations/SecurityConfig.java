package musifan.musifan.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/images/**", "/css/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		//@formatter:off
		http
			.antMatcher("/api/**")
				.csrf().ignoringAntMatchers("/api/**")
				.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authorizeRequests()
					.antMatchers(HttpMethod.OPTIONS).anonymous()
					.antMatchers("/api/auth").authenticated()
					.antMatchers(HttpMethod.POST, "/api/utilisateur").permitAll()
					.antMatchers(HttpMethod.POST, "/api/artiste").permitAll()
					.antMatchers("/api/utilsateur/**").hasRole("UTILISATEUR")
					.antMatchers(HttpMethod.GET,"/api/artiste/**").hasAnyRole("ARTISTE", "UTILISATEUR")
					.antMatchers("/api/artiste/**").hasRole("ARTISTE")
					//Auth lieu
					.antMatchers(HttpMethod.POST,"/api/lieu/**").hasRole("ARTISTE")
					.antMatchers(HttpMethod.GET, "/api/lieu/**").hasAnyRole("ARTISTE","UTILISATEUR")
					//Auth concert
					.antMatchers(HttpMethod.POST,"/api/concert/**").hasRole("ARTISTE")
					.antMatchers(HttpMethod.PUT,"/api/concert/**").hasRole("ARTISTE")
					.antMatchers(HttpMethod.DELETE,"/api/concert/**").hasRole("ARTISTE")
					.antMatchers(HttpMethod.GET, "/api/concert/**").hasAnyRole("ARTISTE","UTILISATEUR")
					//Auth album
					.antMatchers(HttpMethod.POST,"/api/album/**").hasRole("ARTISTE")
					.antMatchers(HttpMethod.DELETE,"/api/album/**").hasRole("ARTISTE")
					.antMatchers(HttpMethod.GET, "/api/album/**").hasAnyRole("ARTISTE","UTILISATEUR")
					//Auth chansons
					.antMatchers(HttpMethod.GET, "/api/chansons/**").hasAnyRole("ARTISTE","UTILISATEUR")
					//Auth publications
					.antMatchers(HttpMethod.POST,"/api/publication/**").hasRole("ARTISTE")
					.antMatchers(HttpMethod.DELETE,"/api/publication/**").hasRole("ARTISTE")
					.antMatchers(HttpMethod.GET, "/api/publication/**").hasAnyRole("ARTISTE","UTILISATEUR")
					//Auth commandes
					.antMatchers(HttpMethod.POST,"/api/commande/**").hasRole("UTILISATEUR")
					.antMatchers(HttpMethod.DELETE,"/api/commande/**").hasRole("UTILISATEUR")
				.and()	
				.httpBasic();
		//@formatter:on
	}
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
