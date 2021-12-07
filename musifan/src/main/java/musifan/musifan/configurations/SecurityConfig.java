//package musifan.musifan.configurations;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//public class SecurityConfig extends WebSecurityConfigurerAdapter{
//	
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/images/**", "/css/**");
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		//@formatter:off
//		http
//			.antMatcher("/api/**")
//				.csrf().ignoringAntMatchers("/api/**")
//				.and()
//				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//				.and()
//				.authorizeRequests()
//					.antMatchers(HttpMethod.OPTIONS).anonymous()
//					.antMatchers("/api/auth").authenticated()
//					.antMatchers(HttpMethod.POST, "/api/utilisateur").permitAll()
//					.antMatchers(HttpMethod.POST, "/api/artiste").permitAll()
//					.antMatchers("/api/**").hasRole("USER")
//				.and()
//				.httpBasic();
//		//@formatter:on
//	}
//	
//	@Autowired
//	private UserDetailsService userDetailsService;
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService);
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//}
