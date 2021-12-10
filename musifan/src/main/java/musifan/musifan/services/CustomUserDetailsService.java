package musifan.musifan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import musifan.musifan.entity.Compte;
import musifan.musifan.repositories.ArtisteRepository;
import musifan.musifan.repositories.UtilisateurRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private ArtisteRepository artisteRepository;
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Compte compte = artisteRepository.findByMail(username).orElse(null);
		
		if (compte == null) {
			compte = utilisateurRepository.findByMail(username).orElseThrow(() -> {
				throw new UsernameNotFoundException("utilisateur inconnu");
			});
		}
		return compte;
	}
}
